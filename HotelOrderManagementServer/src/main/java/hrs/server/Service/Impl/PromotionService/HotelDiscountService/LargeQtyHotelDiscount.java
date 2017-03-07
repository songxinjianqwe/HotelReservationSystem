package hrs.server.Service.Impl.PromotionService.HotelDiscountService;

import org.springframework.stereotype.Component;

import hrs.common.VO.OrderVO;
/**
 * 
* @ClassName: LargeQtyHotelDiscount
* @Description: 量大从优
* @author NewSong
* @date 2016年11月19日 下午9:53:34
*
 */
@Component("LargeQtyHotelDiscount")
public class LargeQtyHotelDiscount extends HotelDiscount {


	@Override
	public OrderVO discount(OrderVO order) {
		if(order.roomNum >= hotelDiscount.minQty){
			order.hotelDiscounts.put(hotelDiscount, (1-hotelDiscount.discount)*order.value);
		}
		return order;
	}

}
