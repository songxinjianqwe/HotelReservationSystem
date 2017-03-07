package test.server.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.Exception.PromotionService.EnterpriseNotFoundException;
import hrs.common.Exception.UserService.UserExistedException;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.Exception.UserService.UserPasswordErrorException;
import hrs.common.VO.EnterpriseVO;
import hrs.common.VO.UserVO;
import hrs.common.util.type.UserType;
import hrs.server.Service.Interface.PromotionService.EnterpriseService;
import hrs.server.Service.Interface.UserService.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestUserService {
	@Autowired
	private UserService service;
	@Autowired
	private EnterpriseService enterpriseService;

	@Test
	public void testFindByUsername() throws UserNotFoundException {
		UserVO vo = service.findByUsername("admin");
		System.out.println(vo);
		assertEquals(vo.password,"admin");
	}
	
	@Test
	public void testValidateCredit(){
		assertTrue(service.validateCredit("admin"));
	}
	

	@Test(expected = UserExistedException.class)
	public void testRegister1() throws UserExistedException {
		service.register(new UserVO("admin","admin","宋欣建","232131"));
	}
	
	@Test
	public void testRegister2() throws UserExistedException, UserNotFoundException, EnterpriseNotFoundException {
		UserVO vo = new UserVO("admin661", "admin661", "123123", "呵呵", 0, 1, UserType.Enterprise,"酒店ttt");
		service.register(vo);
		vo = service.findByUsername("admin661");
		assertEquals(vo.password,"admin661");
		/*List<EnterpriseVO> list = enterpriseService.getAllEnterprises();
		for(EnterpriseVO enterprise:list){
			if(enterprise.name.equals("酒店ttt")){
				return;
			}
		}
		fail();*/
	}
	
	@Test
	public void testUpdate() throws UserNotFoundException {
		UserVO vo = service.findByUsername("admin");
		vo.credit = 3000;
		service.update(vo);
		assertEquals(service.findByUsername("admin").credit, 3000);
	}

	@Test(expected = UserPasswordErrorException.class)
	public void testLogin1() throws UserNotFoundException, UserPasswordErrorException {
		service.login("admin", "2222");
	}

	@Test(expected = UserNotFoundException.class)
	public void testLogin2() throws UserNotFoundException, UserPasswordErrorException {
		service.login("admin111", "2222");
	}

	@Test
	public void testLogin3() throws UserNotFoundException, UserPasswordErrorException {
		assertEquals(service.login("admin", "admin").username, "admin");
	}

}
