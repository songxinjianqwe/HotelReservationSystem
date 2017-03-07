package hrs.server.Service.Interface.HotelService;

import java.util.List;

import hrs.common.VO.CommercialCircleVO;

public interface CommCircleService {
	List<CommercialCircleVO> findByLoc(int locID);
}
