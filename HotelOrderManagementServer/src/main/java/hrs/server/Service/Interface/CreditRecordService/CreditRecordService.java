package hrs.server.Service.Interface.CreditRecordService;

import java.util.List;

import hrs.common.Exception.CreditRecordService.CreditRecordNotFoundException;
import hrs.common.VO.CreditRecordVO;
import hrs.common.VO.UserVO;

public interface CreditRecordService {
	List<CreditRecordVO> findByUsername(String username) throws CreditRecordNotFoundException;
	void add(CreditRecordVO creditrecordvo);
	void charge(UserVO user,int money);
}	
