package hrs.server.Service.Impl.PromotionService.WebDiscountService;

import org.springframework.stereotype.Component;

import hrs.common.VO.OrderVO;
/**
 * 
* @ClassName: VIPWebDiscount
* @Description: 会员等级优惠策略
* @author NewSong
* @date 2016年11月19日 下午9:56:40
*
 */
@Component("VIPWebDiscount")
public class VIPWebDiscount extends WebDiscount{

	@Override
	public OrderVO discount(OrderVO order) {
		if(order.user.VIPLevel == webDiscount.VIPlevel){
			order.webDiscounts.put(webDiscount, order.value*(1-webDiscount.discount));
		}
		return order;
	}
}
