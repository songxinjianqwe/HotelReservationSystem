package hrs.server.Controller.HotelController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hrs.common.Controller.HotelController.IRoomController;
import hrs.common.Exception.RoomService.RoomNotFoundException;
import hrs.common.VO.RoomVO;
import hrs.common.util.type.RoomType;
import hrs.server.Service.Interface.RoomService.RoomService;

public class RoomController implements IRoomController{
	@Autowired
	private RoomService service;
	
	@Override
	public void updateRoom(RoomVO roomvo) {
		service.update(roomvo);
	}

	@Override
	public void addRoom(RoomVO roomvo) {
		service.add(roomvo);
	}

	@Override
	public List<RoomType> findNotAddedRoomType(int hotelID) {
		return service.findNotAddedRoomType(hotelID);
	}

	@Override
	public List<RoomVO> findByHotelID(int hotelID) throws RoomNotFoundException {
		return service.findByHotelID(hotelID);
	}
	
}
