package hrs.server.Service.Impl.PromotionService.HotelDiscountService;

import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.OrderVO;
/**
 * 
* @ClassName: HotelDiscount
* @Description: 所有酒店优惠策略的共同基类
* @author NewSong
* @date 2016年11月19日 下午9:53:58
*
 */
public abstract class HotelDiscount {
	protected HotelDiscountVO hotelDiscount;
	
	public void setHotelDiscount(HotelDiscountVO hotelDiscount) {
		this.hotelDiscount = hotelDiscount;
	}
	
	public abstract OrderVO discount(OrderVO order);
}
