package hrs.server.Controller.WebMarketController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.WebMarketController.IWebCreditController;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;
import hrs.server.Service.Interface.CreditRecordService.CreditRecordService;
import hrs.server.Service.Interface.UserService.UserService;
@Controller
public class WebCreditController implements IWebCreditController{
	@Autowired
	private CreditRecordService creditRecordService;
	@Autowired
	private UserService userService;
	
	@Override
	public UserVO findUserByUsername(String username) throws UserNotFoundException {
		return userService.findByUsername(username);
	}

	@Override
	public void charge(UserVO user, int money) {
		creditRecordService.charge(user, money);
	}
}
