package hrs.server.Service.Interface.OfflineRecordService;

import java.util.List;

import hrs.common.Exception.OfflineRecordService.OfflineRecordNotFoundException;
import hrs.common.VO.OfflineRecordVO;

public interface OfflineRecordService {
	OfflineRecordVO findByID(int id) throws OfflineRecordNotFoundException;
	void checkin(OfflineRecordVO offlinerecordvo);
	void checkout(OfflineRecordVO offlinerecordvo);
	List<OfflineRecordVO> findByHotelID(int hotelID) throws OfflineRecordNotFoundException;
}
