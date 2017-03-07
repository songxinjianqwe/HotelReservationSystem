package hrs.common.Controller.HotelController;

import java.util.Date;
import java.util.List;

import hrs.common.Exception.OfflineRecordService.OfflineRecordNotFoundException;
import hrs.common.VO.OfflineRecordVO;
import hrs.common.VO.RoomVO;

public interface IOfflineRecordController {
	OfflineRecordVO findOfflineRecordByID(int id) throws OfflineRecordNotFoundException;
	void offlineCheckin(OfflineRecordVO offlinerecordvo);
	void offlineCheckout(OfflineRecordVO offlinerecordvo);
	List<RoomVO> findAvailableByHotelID(int hotelID,Date begin,Date end);
	List<OfflineRecordVO> findByHotelID(int hotelID) throws OfflineRecordNotFoundException;
}
