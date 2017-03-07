package hrs.server.Controller.HotelController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.HotelController.IOfflineRecordController;
import hrs.common.Exception.OfflineRecordService.OfflineRecordNotFoundException;
import hrs.common.VO.OfflineRecordVO;
import hrs.common.VO.RoomVO;
import hrs.server.Service.Interface.OfflineRecordService.OfflineRecordService;
import hrs.server.Service.Interface.RoomService.RoomService;
@Controller
public class OfflineRecordController implements IOfflineRecordController{
	@Autowired
	private OfflineRecordService offlineRecordService;
	@Autowired
	private RoomService roomService;
	
	@Override
	public OfflineRecordVO findOfflineRecordByID(int id) throws OfflineRecordNotFoundException {
		return offlineRecordService.findByID(id);
	}


	@Override
	public void offlineCheckin(OfflineRecordVO offlinerecordvo) {
		offlineRecordService.checkin(offlinerecordvo);
	}

	@Override
	public void offlineCheckout(OfflineRecordVO offlinerecordvo) {
		offlineRecordService.checkout(offlinerecordvo);
	}

	@Override
	public List<RoomVO> findAvailableByHotelID(int hotelID, Date begin, Date end) {
		return roomService.findAvailableByHotelID(hotelID, begin, end);
	}


	@Override
	public List<OfflineRecordVO> findByHotelID(int hotelID) throws OfflineRecordNotFoundException {
		return offlineRecordService.findByHotelID(hotelID);
	}
	
}
