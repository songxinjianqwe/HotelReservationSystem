package hrs.server.Service.Impl.PromotionService.HotelDiscountService;

import org.springframework.stereotype.Component;

import hrs.common.VO.OrderVO;
import hrs.common.util.DateHelper;
/**
 * 
* @ClassName: BirthdayHotelDiscount
* @Description: 会员生日优惠策略
* @author NewSong
* @date 2016年11月19日 下午9:54:29
*
 */
@Component("BirthdayHotelDiscount")
public class BirthdayHotelDiscount extends HotelDiscount {
	

	@Override
	public OrderVO discount(OrderVO order) {
		if(DateHelper.formatWithMD(order.placeTime).equals(DateHelper.formatWithMD(order.user.birthDate))){
			order.hotelDiscounts.put(hotelDiscount, order.value*(1-hotelDiscount.discount));
		}
		return order;
	}
	
}
