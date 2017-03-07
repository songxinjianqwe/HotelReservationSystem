package hrs.server.Controller.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.UserController.IUserController;
import hrs.common.Exception.CreditRecordService.CreditRecordNotFoundException;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.CreditRecordVO;
import hrs.common.VO.UserVO;
import hrs.common.util.DesUtil;
import hrs.server.Service.Interface.CreditRecordService.CreditRecordService;
import hrs.server.Service.Interface.UserService.UserService;

@Controller
public class UserController implements IUserController{
	@Autowired
	private UserService userService;
	@Autowired
	private CreditRecordService creditRecordService;
	
	@Override
	public void updateUser(UserVO uservo) {
		userService.update(uservo);
	}
	
	@Override
	public UserVO findUserByUsername(String username) throws UserNotFoundException {
		return userService.findByUsername(username);
	}
	@Override
	
	public List<CreditRecordVO> findCreditRecordByUsername(String username) throws CreditRecordNotFoundException {
		System.out.println(username);
		DesUtil util = DesUtil.getInstance();
		System.out.println(util.encode(username));
		return creditRecordService.findByUsername(username);
	}
	
	
}
