package hrs.common.Controller.HotelController;

import java.util.List;

import hrs.common.Exception.RoomService.RoomNotFoundException;
import hrs.common.VO.RoomVO;
import hrs.common.util.type.RoomType;

public interface IRoomController {
	void updateRoom(RoomVO roomvo);
	void addRoom(RoomVO roomvo);
	List<RoomType> findNotAddedRoomType(int hotelID);
	List<RoomVO> findByHotelID(int hotelID) throws RoomNotFoundException;
}
