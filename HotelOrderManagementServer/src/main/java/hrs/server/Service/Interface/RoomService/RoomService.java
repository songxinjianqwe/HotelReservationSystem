package hrs.server.Service.Interface.RoomService;

import java.util.Date;
import java.util.List;

import hrs.common.Exception.RoomService.RoomNotFoundException;
import hrs.common.VO.RoomVO;
import hrs.common.util.type.RoomType;

public interface RoomService {
	List<RoomVO> findByHotelID(int hotelID) throws RoomNotFoundException;
	RoomVO findByHotelAndType(int hotelID, RoomType type) throws RoomNotFoundException;
	List<RoomVO> findAvailableByHotelID(int hotelID,Date begin,Date end);
	void update(RoomVO roomvo);
	void add(RoomVO roomvo);
	List<RoomType> findNotAddedRoomType(int hotelID);
	int findAvailableRoomNum(int hotelID,RoomType type,Date begin,Date end);
}
