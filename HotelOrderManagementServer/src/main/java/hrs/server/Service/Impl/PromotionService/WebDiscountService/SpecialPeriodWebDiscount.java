package hrs.server.Service.Impl.PromotionService.WebDiscountService;

import org.springframework.stereotype.Component;

import hrs.common.VO.OrderVO;
/**
 * 
* @ClassName: SpecialPeriodWebDiscount
* @Description: 特定日期优惠策略
* @author NewSong
* @date 2016年11月19日 下午9:56:29
*
 */
@Component("SpecialPeriodWebDiscount")
public class SpecialPeriodWebDiscount extends WebDiscount{

	@Override
	public OrderVO discount(OrderVO order) {
		if(webDiscount.beginTime.before(order.placeTime) && webDiscount.endTime.after(order.placeTime)){
			order.webDiscounts.put(webDiscount, order.value*(1-webDiscount.discount));
		}
		return order;
	}
}
