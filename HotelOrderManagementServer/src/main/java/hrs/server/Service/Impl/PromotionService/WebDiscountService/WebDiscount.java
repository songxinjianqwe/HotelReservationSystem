package hrs.server.Service.Impl.PromotionService.WebDiscountService;

import hrs.common.VO.OrderVO;
import hrs.common.VO.WebDiscountVO;
/**
 * 
* @ClassName: WebDiscount
* @Description: 所有网站优惠策略的共同基类
* @author NewSong
* @date 2016年11月19日 下午9:56:03
*
 */
public abstract class WebDiscount {
protected WebDiscountVO webDiscount;
	
	public void setWebDiscountVO(WebDiscountVO webDiscount) {
		this.webDiscount = webDiscount;
	}
	public abstract OrderVO discount(OrderVO order);
}
