package hrs.server.DAO.Interface;

import java.util.List;

import hrs.common.POJO.OfflineRecordPO;
import hrs.common.util.ResultMessage;

public interface OfflineRecordDAO {
	 OfflineRecordPO findByID(int id);
	 ResultMessage add(OfflineRecordPO offlinerecordpo);
	 ResultMessage update(OfflineRecordPO offlinerecordpo);
	 List<OfflineRecordPO> findByHotelID(int hotelID);
}
