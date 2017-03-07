package hrs.server.Service.Impl.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.POJO.OrderPO;
import hrs.common.VO.OrderVO;
import hrs.common.util.DateHelper;
import hrs.common.util.DesUtil;
import hrs.common.util.type.OrderStatus;
import hrs.server.DAO.Interface.OrderDAO;
import hrs.server.Service.Interface.OrderService.OrderSearchService;
/**
 * 
* @ClassName: OrderSearchServiceImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午9:59:47
*
 */
@Service
public class OrderSearchServiceImpl implements OrderSearchService {
	@Autowired
	private OrderDAO dao;
	private DesUtil util;
	/**
	 * 
	 * @Title: findByID
	 * @Description: 按id查找订单
	 * @param id
	 * @return OrderVO
	 * @throws OrderNotFoundException  
	 * @see hrs.server.Service.Interface.OrderService.OrderSearchService#findByID(int)
	 */
	@Transactional
	@Override
	public OrderVO findByID(int id) throws OrderNotFoundException {
		OrderPO po  = dao.findByID(id);
		if(po == null){
			throw new OrderNotFoundException();
		}else{
			return new OrderVO(po);
		}
	}

	/**
	 * 
	 * @Title: findByHotelAndStatus
	 * @Description: 按酒店和订单状态查询订单
	 * @param hotelID
	 * @param status
	 * @return
	 * @throws OrderNotFoundException  
	 * @see hrs.server.Service.Interface.OrderService.OrderSearchService#findByHotelAndStatus(int, hrs.common.util.type.OrderStatus)
	 */
	@Transactional
	@Override
	public List<OrderVO> findByHotelAndStatus(int hotelID, OrderStatus status) throws OrderNotFoundException {
		List<OrderPO> pos = dao.findByHotelAndStatus(hotelID,status);
		if(pos.size() == 0){
			throw new OrderNotFoundException();
		}else{
			return tranfer(pos);
		}
	}

	/**
	 * 
	 * @Title: findByUsernameAndStatus
	 * @Description: 按用户名和订单状态查询订单
	 * @param username
	 * @param status
	 * @return
	 * @throws OrderNotFoundException  
	 * @see hrs.server.Service.Interface.OrderService.OrderSearchService#findByUsernameAndStatus(java.lang.String, hrs.common.util.type.OrderStatus)
	 */
	@Transactional
	@Override
	public List<OrderVO> findByUsernameAndStatus(String username, OrderStatus status) throws OrderNotFoundException {
		util = DesUtil.getInstance();
		List<OrderPO> pos = dao.findByUsernameAndStatus(util.encode(username),status);
		if(pos.size() == 0){
			throw new OrderNotFoundException();
		}else{
			return tranfer(pos);
		}
	}	
	/**
	 * 
	 * @Title: findByUsername
	 * @Description: 按用户名查询订单
	 * @param username
	 * @return
	 * @throws OrderNotFoundException  
	 * @see hrs.server.Service.Interface.OrderService.OrderSearchService#findByUsername(java.lang.String)
	 */
	@Transactional
	@Override
	public List<OrderVO> findByUsername(String username) throws OrderNotFoundException {
		util = DesUtil.getInstance();
		List<OrderPO> pos = dao.findByUsername(util.encode(username));
		if(pos.size() == 0){
			throw new OrderNotFoundException();
		}else{
			return tranfer(pos);
		}
	}
	/**
	 * 
	 * @Title: findByHotelAndUsername
	 * @Description: 按酒店id和用户名查询订单
	 * @param hotelID
	 * @param username
	 * @return
	 * @throws OrderNotFoundException  
	 * @see hrs.server.Service.Interface.OrderService.OrderSearchService#findByHotelAndUsername(int, java.lang.String)
	 */
	@Transactional
	@Override
	public List<OrderVO> findByHotelAndUsername(int hotelID, String username) throws OrderNotFoundException {
		util = DesUtil.getInstance();
		List<OrderPO> pos = dao.findByHotelAndUsername(hotelID, util.encode(username));
		if(pos.size() == 0){
			throw new OrderNotFoundException();
		}else{
			return tranfer(pos);
		}
	}	
	
	/**
	 * 
	 * @Title: findByOrderStatus
	 * @Description: 按订单状态查询订单
	 * @param status
	 * @return
	 * @throws OrderNotFoundException  
	 * @see hrs.server.Service.Interface.OrderService.OrderSearchService#findByOrderStatus(hrs.common.util.type.OrderStatus)
	 */
	@Transactional
	@Override
	public List<OrderVO> findByOrderStatus(OrderStatus status) throws OrderNotFoundException {
		List<OrderPO> pos = dao.findByOrderStatus(status);
		if(pos.size() == 0){
			throw new OrderNotFoundException();
		}else{
			return tranfer(pos);
		}
	}
	
	/**
	 * 
	 * @Title: findByHotelAndTime
	 * @Description: 按用户名和时间查询订单
	 * @param hotelID
	 * @param begin
	 * @param end
	 * @return
	 * @throws OrderNotFoundException  
	 * @see hrs.server.Service.Interface.OrderService.OrderSearchService#findByHotelAndTime(int, java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<OrderVO> findByHotelAndTime(int hotelID, Date begin, Date end) throws OrderNotFoundException {
		List<OrderPO> pos = dao.findByHotelAndTime(hotelID, begin, end);
		if(pos.size() == 0){
			throw new OrderNotFoundException();
		}else{
			return tranfer(pos);
		}
	}
	
	@Transactional
	@Override
	public List<OrderVO> findByHotelID(int hotelID) throws OrderNotFoundException {
		List<OrderPO> pos = dao.findByHotelID(hotelID);
		if(pos.size() == 0){
			throw new OrderNotFoundException();
		}else{
			return tranfer(pos);
		}
	}
	
	/**
	 * 
	 * @Title: findByOrderStatusAndPlaceTime
	 * @Description: TODO
	 * @param status
	 * @param date
	 * @return
	 * @throws OrderNotFoundException  
	 * @see hrs.server.Service.Interface.OrderService.OrderSearchService#findByOrderStatusAndPlaceTime(hrs.common.util.type.OrderStatus, java.util.Date)
	 */
	@Transactional
	@Override
	public List<OrderVO> findByOrderStatusAndPlaceTime(OrderStatus status,Date date) throws OrderNotFoundException{
		Date begin = DateHelper.setHMSZero(date);
		Date end = DateHelper.addOneDay(begin);
		System.out.println(begin);
		System.out.println(end);
		List<OrderPO> pos = dao.findByOrderStatusAndPlaceTime(status, begin, end);
		if(pos.size() == 0){
			throw new OrderNotFoundException();
		}else{
			return tranfer(pos);
		}
	}
	/**
	 * 
	 * @Title: tranfer
	 * @Description: 将PO的List转为VO的List
	 * @param  List<OrderPO>
	 * @return List<OrderVO>   
	 * @throws
	 */
	private List<OrderVO> tranfer(List<OrderPO> pos){
		List<OrderVO> vos = new ArrayList<>();
		OrderVO vo = null;
		for(OrderPO po : pos){
			vo = new OrderVO(po);
			vos.add(vo);
		}
		return vos;
	}

	
}
