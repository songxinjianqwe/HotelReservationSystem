package hrs.server.DAO.Interface;

import java.util.List;

import hrs.common.POJO.StaffPO;
import hrs.common.util.ResultMessage;

public interface StaffDAO {
	ResultMessage update(StaffPO staffpo);

	ResultMessage add(StaffPO staffpo);

	StaffPO findByUsername(String username);

	List<StaffPO> findByHotelName(String hotelName);
}
