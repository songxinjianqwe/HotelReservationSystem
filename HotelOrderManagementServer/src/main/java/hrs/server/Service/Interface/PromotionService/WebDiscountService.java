package hrs.server.Service.Interface.PromotionService;

import java.util.List;

import hrs.common.Exception.Promotion.WebDiscountService.WebDiscountNotFoundException;
import hrs.common.VO.WebDiscountVO;
import hrs.server.Service.Impl.PromotionService.WebDiscountService.WebDiscount;

public interface WebDiscountService {
	List<WebDiscountVO> findAll() throws WebDiscountNotFoundException;
	void add (WebDiscountVO webdiscountvo);
	void update(WebDiscountVO webdiscountvo);
	void delete(int id);
	List<WebDiscount> createAllStrategies();
}
