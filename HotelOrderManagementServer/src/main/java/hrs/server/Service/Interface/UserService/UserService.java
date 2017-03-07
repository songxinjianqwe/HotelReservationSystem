package hrs.server.Service.Interface.UserService;

import hrs.common.Exception.UserService.UserExistedException;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.Exception.UserService.UserPasswordErrorException;
import hrs.common.VO.UserVO;

public interface UserService {
	UserVO findByUsername(String username) throws UserNotFoundException;
	void register(UserVO uservo) throws UserExistedException;
	void update(UserVO uservo);
	UserVO login(String username,String password) throws UserNotFoundException, UserPasswordErrorException;
	boolean validateCredit(String username);
}
