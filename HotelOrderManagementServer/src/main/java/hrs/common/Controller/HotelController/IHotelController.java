package hrs.common.Controller.HotelController;

import java.util.List;

import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.LocationVO;

public interface IHotelController {
	HotelVO findHotelByID(int hotelID) throws HotelNotFoundException;
	void updateHotel(HotelVO hotelvo);
	List<LocationVO> findAllLocations();
	List<CommercialCircleVO> findCircleByLoc(int locID);
}
