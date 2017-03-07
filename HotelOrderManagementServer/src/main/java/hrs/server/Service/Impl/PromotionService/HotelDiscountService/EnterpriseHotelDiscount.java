package hrs.server.Service.Impl.PromotionService.HotelDiscountService;

import org.springframework.stereotype.Component;

import hrs.common.VO.OrderVO;
/**
 * 
* @ClassName: EnterpriseHotelDiscount
* @Description: 特定企业优惠策略
* @author NewSong
* @date 2016年11月19日 下午9:54:15
*
 */
@Component("EnterpriseHotelDiscount")
public class EnterpriseHotelDiscount extends HotelDiscount{
	
	
	@Override
	public OrderVO discount(OrderVO order) {
		if(order.user.enterprise.equals(hotelDiscount.enterprise.name)){
			order.hotelDiscounts.put(hotelDiscount, (1-hotelDiscount.discount)*order.value);
		}
		return order;
	}

}
