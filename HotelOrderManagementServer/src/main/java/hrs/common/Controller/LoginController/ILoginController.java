package hrs.common.Controller.LoginController;

import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.Exception.StaffService.StaffPasswordErrorException;
import hrs.common.Exception.UserService.UserExistedException;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.Exception.UserService.UserPasswordErrorException;
import hrs.common.VO.StaffVO;
import hrs.common.VO.UserVO;

public interface ILoginController {
	void register(UserVO uservo) throws UserExistedException;
	UserVO loginUser(String username,String password) throws UserNotFoundException, UserPasswordErrorException;
	StaffVO loginStaff(String username, String password) throws StaffNotFoundExceptioon, StaffPasswordErrorException;
}
