package hrs.server.Controller.HotelController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.HotelController.IHotelController;
import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.LocationVO;
import hrs.server.Service.Interface.HotelService.CommCircleService;
import hrs.server.Service.Interface.HotelService.HotelService;
import hrs.server.Service.Interface.HotelService.LocationService;
@Controller
public class HotelController implements IHotelController{
	@Autowired
	private HotelService hotelService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private CommCircleService commCircleService;
	
	@Override
	public HotelVO findHotelByID(int hotelID) throws HotelNotFoundException {
		return hotelService.findByID(hotelID);
	}

	@Override
	public void updateHotel(HotelVO hotelvo) {
		hotelService.update(hotelvo);
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
