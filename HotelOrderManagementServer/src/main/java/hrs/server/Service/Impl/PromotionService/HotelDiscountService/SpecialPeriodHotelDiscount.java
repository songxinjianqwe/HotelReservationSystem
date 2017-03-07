package hrs.server.Service.Impl.PromotionService.HotelDiscountService;

import org.springframework.stereotype.Component;

import hrs.common.VO.OrderVO;
/**
 * 
* @ClassName: SpecialPeriodHotelDiscount
* @Description: 特定日期优惠策略
* @author NewSong
* @date 2016年11月19日 下午9:53:13
*
 */
@Component("SpecialPeriodHotelDiscount")
public class SpecialPeriodHotelDiscount extends HotelDiscount {

	@Override
	public OrderVO discount(OrderVO order) {
		System.out.println(order.placeTime);
		System.out.println(hotelDiscount.beginTime);
		System.out.println(hotelDiscount.endTime);
		if(hotelDiscount.beginTime.before(order.placeTime) && hotelDiscount.endTime.after(order.placeTime)){
			order.hotelDiscounts.put(hotelDiscount, (1-hotelDiscount.discount)*order.value);
		}
		return order;
	}
}
