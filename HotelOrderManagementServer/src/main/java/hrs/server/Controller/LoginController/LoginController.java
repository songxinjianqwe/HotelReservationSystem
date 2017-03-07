package hrs.server.Controller.LoginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.LoginController.ILoginController;
import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.Exception.StaffService.StaffPasswordErrorException;
import hrs.common.Exception.UserService.UserExistedException;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.Exception.UserService.UserPasswordErrorException;
import hrs.common.VO.StaffVO;
import hrs.common.VO.UserVO;
import hrs.server.Service.Interface.StaffService.StaffService;
import hrs.server.Service.Interface.UserService.UserService;
@Controller
public class LoginController implements ILoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private StaffService staffService;

	@Override
	public void register(UserVO uservo) throws UserExistedException {
		userService.register(uservo);;
	}

	@Override
	public UserVO loginUser(String username, String password) throws UserNotFoundException, UserPasswordErrorException {
		return userService.login(username, password);
	}

	@Override
	public StaffVO loginStaff(String username, String password) throws StaffNotFoundExceptioon, StaffPasswordErrorException {
		return staffService.login(username, password);
	}
}
