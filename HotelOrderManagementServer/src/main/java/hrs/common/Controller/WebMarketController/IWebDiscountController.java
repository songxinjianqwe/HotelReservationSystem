package hrs.common.Controller.WebMarketController;

import java.util.List;

import hrs.common.Exception.Promotion.WebDiscountService.WebDiscountNotFoundException;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.LocationVO;
import hrs.common.VO.WebDiscountVO;

public interface IWebDiscountController {
	List<WebDiscountVO> findAll() throws WebDiscountNotFoundException;
	void add (WebDiscountVO webdiscountvo);
	void update(WebDiscountVO webdiscountvo);
	void delete(int id);
	List<LocationVO> findAllLocations();
	List<CommercialCircleVO> findCircleByLoc(int locID);
}
