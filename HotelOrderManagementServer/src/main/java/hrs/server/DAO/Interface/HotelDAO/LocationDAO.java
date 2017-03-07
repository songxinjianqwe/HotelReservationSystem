package hrs.server.DAO.Interface.HotelDAO;

import java.util.List;

import hrs.common.POJO.LocationPO;

public interface LocationDAO {
	List<LocationPO> findAll();
}	
