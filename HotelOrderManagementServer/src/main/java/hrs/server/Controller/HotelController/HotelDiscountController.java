package hrs.server.Controller.HotelController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.HotelController.IHotelDiscountController;
import hrs.common.Exception.Promotion.HotelDiscountService.HotelDiscountNotFoundException;
import hrs.common.Exception.PromotionService.EnterpriseNotFoundException;
import hrs.common.VO.EnterpriseVO;
import hrs.common.VO.HotelDiscountVO;
import hrs.server.Service.Interface.PromotionService.EnterpriseService;
import hrs.server.Service.Interface.PromotionService.HotelDiscountService;
@Controller
public class HotelDiscountController implements IHotelDiscountController{
	@Autowired
	private HotelDiscountService hotelDiscountService;
	@Autowired
	private EnterpriseService enterpriseService;
	
	
	@Override
	public List<EnterpriseVO> findNotAddedEnterpriseByHotelID(int hotelID) throws EnterpriseNotFoundException {
		return enterpriseService.findNotAddedEnterpriseByHotelID(hotelID);
	}

	@Override
	public void add(HotelDiscountVO hoteldiscountvo) {
		hotelDiscountService.add(hoteldiscountvo);
	}

	@Override
	public void update(HotelDiscountVO hoteldiscountvo) {
		hotelDiscountService.update(hoteldiscountvo);
	}

	@Override
	public void delete(int id) {
		hotelDiscountService.delete(id);
	}

	@Override
	public List<HotelDiscountVO> findAllByHotelID(int hotelID) throws HotelDiscountNotFoundException {
		return hotelDiscountService.findAllByHotelID(hotelID);
	}

	
}
