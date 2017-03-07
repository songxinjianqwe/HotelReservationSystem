package hrs.server.Service.Interface.PromotionService;

import java.util.List;

import hrs.common.Exception.PromotionService.EnterpriseNotFoundException;
import hrs.common.VO.EnterpriseVO;

public interface EnterpriseService {
	List<EnterpriseVO> findNotAddedEnterpriseByHotelID(int hotelID) throws EnterpriseNotFoundException;
	void add(EnterpriseVO vo);
}
