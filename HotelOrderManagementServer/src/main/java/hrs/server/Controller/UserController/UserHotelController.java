package hrs.server.Controller.UserController;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.LocationVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.FilterCondition;
import hrs.common.util.type.OrderRule;
import hrs.server.Service.Interface.HotelService.CommCircleService;
import hrs.server.Service.Interface.HotelService.HotelService;
import hrs.server.Service.Interface.HotelService.LocationService;
import hrs.server.Service.Interface.OrderService.OrderSearchService;
@Controller
public class UserHotelController implements IUserHotelController{
	@Autowired
	private HotelService hotelService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private CommCircleService commCircleService;
	@Autowired
	private OrderSearchService orderSearchService;

	@Override
	public List<OrderVO> findOrderByHotelAndUsername(int hotelID, String username) throws OrderNotFoundException {
		return orderSearchService.findByHotelAndUsername(hotelID, username);
	}


	@Override
	public Map<HotelVO, List<OrderVO>> findOrderedHotelAndOrder(String username) throws OrderNotFoundException {
		return hotelService.findOrderedHotelAndOrder(username);
	}

	@Override
	public Map<HotelVO, List<RoomVO>> findHotels(int loc, int circle, Date begin, Date end,String username) throws HotelNotFoundException {
		return hotelService.find(loc, circle, begin, end, username);
	}

	@Override
	public Map<HotelVO, List<RoomVO>> filterHotels(Map<HotelVO, List<RoomVO>> data,List<FilterCondition> conditions) {
		return hotelService.filter(data, conditions);
	}

	@Override
	public Map<HotelVO, List<RoomVO>> orderHotels(Map<HotelVO, List<RoomVO>> data,OrderRule rule, boolean isDecrease) {
		return hotelService.order(data, rule, isDecrease);
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
