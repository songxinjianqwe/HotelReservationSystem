package hrs.server.Service.Impl.PromotionService.WebDiscountService;

import org.springframework.stereotype.Component;

import hrs.common.VO.OrderVO;
/**
 * 
* @ClassName: SpecialCommercialCircleWebDiscount
* @Description: 特定商圈优惠策略
* @author NewSong
* @date 2016年11月19日 下午9:56:16
*
 */
@Component("SpecialCommercialCircleWebDiscount")
public class SpecialCommercialCircleWebDiscount extends WebDiscount {

	@Override
	public OrderVO discount(OrderVO order) {
		if (order.hotel.commercialCircle.equals(webDiscount.commercialCircle)) {
			order.webDiscounts.put(webDiscount, order.value * (1-webDiscount.discount));
		}
		return order;
	}

}
