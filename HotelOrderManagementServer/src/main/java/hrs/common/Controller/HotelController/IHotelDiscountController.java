package hrs.common.Controller.HotelController;

import java.util.List;

import hrs.common.Exception.Promotion.HotelDiscountService.HotelDiscountNotFoundException;
import hrs.common.Exception.PromotionService.EnterpriseNotFoundException;
import hrs.common.VO.EnterpriseVO;
import hrs.common.VO.HotelDiscountVO;

public interface IHotelDiscountController {
	void add(HotelDiscountVO hoteldiscountvo);
	void update(HotelDiscountVO hoteldiscountvo);
	void delete(int id);
	List<HotelDiscountVO> findAllByHotelID(int hotelID) throws HotelDiscountNotFoundException;
	List<EnterpriseVO> findNotAddedEnterpriseByHotelID(int hotelID) throws EnterpriseNotFoundException;
}
