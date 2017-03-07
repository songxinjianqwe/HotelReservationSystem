package hrs.server.Controller.WebMarketController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.WebMarketController.IWebDiscountController;
import hrs.common.Exception.Promotion.WebDiscountService.WebDiscountNotFoundException;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.LocationVO;
import hrs.common.VO.WebDiscountVO;
import hrs.server.Service.Interface.HotelService.CommCircleService;
import hrs.server.Service.Interface.HotelService.LocationService;
import hrs.server.Service.Interface.PromotionService.WebDiscountService;
@Controller
public class WebDiscountController implements IWebDiscountController{
	@Autowired
	private WebDiscountService service;
	@Autowired
	private LocationService locationService;
	@Autowired
	private CommCircleService commCircleService;
	
	@Override
	public List<WebDiscountVO> findAll() throws WebDiscountNotFoundException {
		return service.findAll();
	}

	@Override
	public void add(WebDiscountVO webdiscountvo) {
		service.add(webdiscountvo);
	}

	@Override
	public void update(WebDiscountVO webdiscountvo) {
		service.update(webdiscountvo);
	}

	@Override
	public void delete(int id) {
		service.delete(id);
	}
	
	@Override
	public List<LocationVO> findAllLocations() {
		return locationService.findAll();
	}

	@Override
	public List<CommercialCircleVO> findCircleByLoc(int locID) {
		return commCircleService.findByLoc(locID);
	}
}
