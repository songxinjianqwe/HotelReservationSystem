package test.server.Controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.Controller.UserController.IUserController;
import hrs.common.Exception.CreditRecordService.CreditRecordNotFoundException;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.CreditRecordVO;
import hrs.common.util.DateHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestUserController {
	@Autowired
	private IUserController userController;
	
	@Test
	public void testFindByUsername() throws CreditRecordNotFoundException{
		List<CreditRecordVO> list = userController.findCreditRecordByUsername("admin");
		for(CreditRecordVO vo:list){
			System.out.println(DateHelper.format(vo.date));
		}
	}
	
	@Test
	public void testFindUserByUsername() throws UserNotFoundException{
		System.out.println(userController.findUserByUsername("admin"));
	}
}
