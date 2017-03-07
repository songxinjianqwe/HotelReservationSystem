package hrs.server.Service.Interface.HotelService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.FilterCondition;
import hrs.common.util.type.OrderRule;

public interface HotelService {
	HotelVO findByID(int hotelID) throws HotelNotFoundException;

	void update(HotelVO hotelvo);

	void add(HotelVO hotelvo);

	Map<HotelVO, List<OrderVO>> findOrderedHotelAndOrder(String username) throws OrderNotFoundException;

	Map<HotelVO, List<RoomVO>> find(int loc, int circle, Date begin, Date end,String username) throws HotelNotFoundException;

	Map<HotelVO, List<RoomVO>> filter(Map<HotelVO, List<RoomVO>> data,List<FilterCondition> conditions);

	Map<HotelVO, List<RoomVO>> order(Map<HotelVO, List<RoomVO>> data,OrderRule rule, boolean isDecrease);

	void  addRemark(HotelVO hotel, int score);
	
	HotelVO findByName(String name) throws HotelNotFoundException;
}
