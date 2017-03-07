package hrs.server.Service.Interface.HotelService;

import java.util.List;

import hrs.common.VO.LocationVO;

public interface LocationService {
	List<LocationVO> findAll();
}
