package hrs.server.Controller.WebStaffController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.WebStaffController.IWebUserController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;
import hrs.server.Service.Interface.UserService.UserService;

@Controller
public class WebUserController implements IWebUserController {
	@Autowired
	private UserService service;

	@Override
	public UserVO findUserByUsername(String username) throws UserNotFoundException {
		return service.findByUsername(username);
	}

	@Override
	public void updateUser(UserVO uservo) {
		service.update(uservo);
	}
}
