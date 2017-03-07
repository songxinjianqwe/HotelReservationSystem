package hrs.common.Controller.WebStaffController;

import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;

public interface IWebUserController {
	UserVO findUserByUsername(String username) throws UserNotFoundException;
	void updateUser(UserVO uservo);
}
