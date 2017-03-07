package hrs.common.Controller.UserController;

import java.util.List;

import hrs.common.Exception.CreditRecordService.CreditRecordNotFoundException;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.CreditRecordVO;
import hrs.common.VO.UserVO;

public interface IUserController {
	void updateUser(UserVO uservo);
	UserVO findUserByUsername(String username) throws UserNotFoundException;
	List<CreditRecordVO> findCreditRecordByUsername(String username) throws CreditRecordNotFoundException;
}
