package hrs.server.Service.Interface.PromotionService;

import java.util.List;

import hrs.common.Exception.Promotion.HotelDiscountService.HotelDiscountNotFoundException;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.util.type.HotelDiscountType;
import hrs.server.Service.Impl.PromotionService.HotelDiscountService.HotelDiscount;

public interface HotelDiscountService {
	void add(HotelDiscountVO hoteldiscountvo);
	void update(HotelDiscountVO hoteldiscountvo);
	void delete(int id);
	List<HotelDiscountVO> findAllByHotelID(int hotelID) throws HotelDiscountNotFoundException;
	List<HotelDiscount> createAllStrategies(int hotelID) ;
	List<HotelDiscountVO> findByHotelIDAndType(int hotelID,HotelDiscountType type);
}
