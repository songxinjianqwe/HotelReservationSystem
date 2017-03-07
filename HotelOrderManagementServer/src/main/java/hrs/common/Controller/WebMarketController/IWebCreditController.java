package hrs.common.Controller.WebMarketController;

import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.UserVO;

public interface IWebCreditController {

	UserVO findUserByUsername(String username) throws UserNotFoundException;

	void charge(UserVO user, int money);
}
