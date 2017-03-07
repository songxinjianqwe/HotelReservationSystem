package hrs.server.Service.Impl.OrderService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.OrderPO;
import hrs.common.VO.CreditRecordVO;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.type.CreditRecordType;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RestoreValueType;
import hrs.server.DAO.Interface.OrderDAO;
import hrs.server.Service.Impl.PromotionService.HotelDiscountService.HotelDiscount;
import hrs.server.Service.Impl.PromotionService.WebDiscountService.WebDiscount;
import hrs.server.Service.Interface.CreditRecordService.CreditRecordService;
import hrs.server.Service.Interface.HotelService.HotelService;
import hrs.server.Service.Interface.OrderService.OrderService;
import hrs.server.Service.Interface.PromotionService.HotelDiscountService;
import hrs.server.Service.Interface.PromotionService.WebDiscountService;

/**
 * 
 * @ClassName: OrderServiceImpl
 * @Description:
 * @author NewSong
 * @date 2016年11月19日 下午9:57:04
 *
 */

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO dao;
	@Autowired
	private HotelDiscountService hotelDiscountService;
	@Autowired
	private WebDiscountService webDiscountService;
	@Autowired
	private CreditRecordService creditRecordService;
	@Autowired
	private HotelService hotelService;

	/**
	 * 
	 * @Title: placeOrder
	 * @Description: 下订单，对订单进行打折 ;前置条件是order的value已经被正确设置
	 * @param order
	 * @return
	 * @see hrs.server.Service.Interface.OrderService.OrderService#placeOrder(hrs.common.VO.OrderVO)
	 */
	@Transactional
	@Override
	public OrderVO placeOrder(OrderVO order) {
		// 读取优惠策略，并对订单进行处理
		// hotelDiscountService.findAllByHotelID(ordervo.getHotelID());
		// webDiscountService.findAll();
		// 读取用户的信息：生日、所在企业、原始信用值
		// 合并后进行优惠
		// 每种优惠策略都设置优惠值
		List<HotelDiscount> hotelStrategies = hotelDiscountService.createAllStrategies(order.hotel.id);
		for (HotelDiscount strategy : hotelStrategies) {
			strategy.discount(order);// 这里传入对象是为了保持一致，因为不同策略需要不同的数据
		}
		for (HotelDiscountVO vo : order.hotelDiscounts.keySet()) {
			order.value -= order.hotelDiscounts.get(vo);
		}

		List<WebDiscount> webStrategies = webDiscountService.createAllStrategies();
		for (WebDiscount strategy : webStrategies) {
			strategy.discount(order);// 这里传入对象是为了保持一致，因为不同策略需要不同的数据
		}
		for (WebDiscountVO vo : order.webDiscounts.keySet()) {
			order.value -= order.webDiscounts.get(vo);
		}
		return order;
	}

	/**
	 * 
	 * @Title: add
	 * @Description: 添加订单
	 * @param ordervo
	 * @see hrs.server.Service.Interface.OrderService.OrderService#add(hrs.common.VO.OrderVO)
	 */
	@Transactional
	@Override
	public void add(OrderVO ordervo) {
		dao.add(new OrderPO(ordervo));
	}

	/**
	 * 
	 * @Title: checkin
	 * @Description: 入住，更新信用记录
	 * @param ordervo
	 * @see hrs.server.Service.Interface.OrderService.OrderService#checkin(hrs.common.VO.OrderVO)
	 */
	@Transactional
	@Override
	public void checkin(OrderVO ordervo) {
		ordervo.checkinTime = new Date();
		ordervo.status = OrderStatus.Executed;
		creditRecordService
				.add(new CreditRecordVO(ordervo, ordervo.user, CreditRecordType.Execute, ordervo.value));
		dao.update(new OrderPO(ordervo));
	}

	/**
	 * 
	 * @Title: checkout
	 * @Description: 退房
	 * @param ordervo
	 * @see hrs.server.Service.Interface.OrderService.OrderService#checkout(hrs.common.VO.OrderVO)
	 */
	@Transactional
	@Override
	public void checkout(OrderVO ordervo) {
		ordervo.checkoutTime = new Date();
		dao.update(new OrderPO(ordervo));
	}

	/**
	 * 
	 * @Title: revokeByUser
	 * @Description: 由用户撤销订单
	 * @param ordervo
	 * @see hrs.server.Service.Interface.OrderService.OrderService#revokeByUser(hrs.common.VO.OrderVO)
	 */
	@Transactional
	@Override
	public void revokeByUser(OrderVO ordervo) {
		ordervo.revokeTime = new Date();
		ordervo.status = OrderStatus.UserRevoked;
		if (isOverTime(ordervo.revokeTime, ordervo.expectedCheckoutTime)) {
			creditRecordService
					.add(new CreditRecordVO(ordervo, ordervo.user, CreditRecordType.Revoke, ordervo.value / 2));
		}
		dao.update(new OrderPO(ordervo));
	}

	/**
	 * 
	 * @Title: isOverTime @Description: 判断是否撤销的订单距离最晚订单执行时间不足6小时
	 *         不存在撤销时间比最晚订单执行时间还晚的情况，因为那个时候订单状态已经被置为异常了，并且只有未执行订单才有撤销选项 @param
	 *         revokeTime @param expectedCheckoutTime @return boolean @throws
	 */
	private boolean isOverTime(Date revokeTime, Date expectedCheckoutTime) {
		System.out.println(revokeTime);
		System.out.println(expectedCheckoutTime);
		return ((expectedCheckoutTime.getTime() - revokeTime.getTime()) / (60 * 60 * 1000)) >= 6;
	}

	/**
	 * 
	 * @Title: revokeByWebMarketer
	 * @Description: 由网站营销人员撤销订单
	 * @param ordervo
	 * @param type
	 * @see hrs.server.Service.Interface.OrderService.OrderService#revokeByWebMarketer(hrs.common.VO.OrderVO,
	 *      hrs.common.util.type.RestoreValueType)
	 */
	@Transactional
	@Override
	public void revokeByWebMarketer(OrderVO ordervo, RestoreValueType type) {
		ordervo.revokeTime = new Date();
		if (type == RestoreValueType.Full) {
			ordervo.status = OrderStatus.RevokedFullValue;
			creditRecordService
					.add(new CreditRecordVO(ordervo, ordervo.user, CreditRecordType.Revoke,  ordervo.value));
		} else if (type == RestoreValueType.Half) {
			ordervo.status = OrderStatus.RevokedHalfValue;
			creditRecordService
					.add(new CreditRecordVO(ordervo, ordervo.user, CreditRecordType.Revoke,  ordervo.value / 2));
		}
		dao.update(new OrderPO(ordervo));
	}

	/**
	 * 
	 * @Title: remark
	 * @Description: 对订单进行评价，同时更新酒店评分
	 * @param ordervo
	 * @param score
	 * @param evaluation
	 * @see hrs.server.Service.Interface.OrderService.OrderService#remark(hrs.common.VO.OrderVO,
	 *      int, java.lang.String)
	 */
	@Transactional
	@Override
	public void remark(OrderVO ordervo, int score, String evaluation) {
		ordervo.score = score;
		ordervo.evaluation = evaluation;
		hotelService.addRemark(ordervo.hotel, score);
		dao.update(new OrderPO(ordervo));
	}

	/**
	 * 
	 * @Title: delayCheckin
	 * @Description: 延迟入住
	 * @param ordervo
	 * @see hrs.server.Service.Interface.OrderService.OrderService#delayCheckin(hrs.common.VO.OrderVO)
	 */
	@Transactional
	@Override
	public void delayCheckin(OrderVO ordervo) {
		ordervo.status = OrderStatus.Executed;
		ordervo.checkinTime = new Date();
		creditRecordService
				.add(new CreditRecordVO(ordervo, ordervo.user, CreditRecordType.Execute, ordervo.value));
		dao.update(new OrderPO(ordervo));
	}

	/**
	 * 
	 * @Title: checkAbNormalOrder
	 * @Description: 定期检查是否存在用户的未执行订单超时
	 * @see hrs.server.Service.Interface.OrderService.OrderService#checkAbNormalOrder()
	 */
	@Transactional
	@Override
	public void checkAbNormalOrder() {
		Date curr = new Date();
		List<OrderPO> pos = dao.findByOrderStatus(OrderStatus.Unexecuted);
		System.out.println(pos.size());
		OrderVO vo = null;
		for (OrderPO po : pos) {
			if (po.getExecTime().before(curr)) {
				po.setStatus(OrderStatus.Abnormal);
				vo = new OrderVO(po);
//				System.out.println("超时:" + vo.id);
				creditRecordService.add(new CreditRecordVO(vo, vo.user, CreditRecordType.Overtime,vo.value));
			}
		}
	}

}
