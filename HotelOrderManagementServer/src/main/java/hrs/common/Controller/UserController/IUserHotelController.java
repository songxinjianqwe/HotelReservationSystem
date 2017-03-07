package hrs.common.Controller.UserController;

import java.util.Date;
import java.util.List;
import java.util.Map;

import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.CommercialCircleVO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.LocationVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.FilterCondition;
import hrs.common.util.type.OrderRule;

public interface IUserHotelController {

	/**
	 * 前两个方法是为了显示酒店详细信息准备的
	 * 
	 * @param hotelID
	 * @param username
	 * @return
	 * @throws OrderNotFoundException 
	 */
	List<OrderVO> findOrderByHotelAndUsername(int hotelID, String username) throws OrderNotFoundException;

	Map<HotelVO, List<OrderVO>> findOrderedHotelAndOrder(String username) throws OrderNotFoundException;

	Map<HotelVO, List<RoomVO>> findHotels(int loc, int circle, Date begin, Date end,String username) throws HotelNotFoundException;

	Map<HotelVO, List<RoomVO>> filterHotels(Map<HotelVO, List<RoomVO>> data, List<FilterCondition> conditions);

	Map<HotelVO, List<RoomVO>> orderHotels(Map<HotelVO, List<RoomVO>> data,OrderRule rule, boolean isDecrease);

	List<LocationVO> findAllLocations();

	List<CommercialCircleVO> findCircleByLoc(int locID);

}
