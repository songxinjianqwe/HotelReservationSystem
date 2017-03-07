package test.server.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.CreditRecordService.CreditRecordNotFoundException;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.CreditRecordVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.UserVO;
import hrs.common.util.type.CreditRecordType;
import hrs.server.Service.Interface.CreditRecordService.CreditRecordService;
import hrs.server.Service.Interface.UserService.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestCreditRecordService {
	@Autowired
	private CreditRecordService service;
	@Autowired
	private UserService userService;

	@Test
	public void testfindByUsername() throws CreditRecordNotFoundException {
		List<CreditRecordVO> vos = service.findByUsername("admin");
		for (CreditRecordVO vo : vos) {
			System.out.println(vo);
			assertEquals(vo.user.username, "admin");
		}
	}

	@Test
	public void testAdd() throws CreditRecordNotFoundException, UserNotFoundException {
		OrderVO order = new OrderVO();
		order.id = 22;
		UserVO user = userService.findByUsername("admin");
		CreditRecordVO vo = new CreditRecordVO(order, user, CreditRecordType.Execute, 400);
		service.add(vo);
		List<CreditRecordVO> list = service.findByUsername("admin");

		assertEquals(userService.findByUsername("admin").credit, 1200,0.01);
		assertEquals(userService.findByUsername("admin").VIPLevel, 2);
		for (CreditRecordVO record : list) {
			if (record.variation == 400 && record.type == CreditRecordType.Execute) {
				return;
			}
		}
		fail();
	}
	
	@Transactional
	@Test
	public void testCharge() throws UserNotFoundException {
		UserVO user = userService.findByUsername("admin");
		System.out.println(user.credit);
		service.charge(user, 300); 
		UserVO u2 = userService.findByUsername("admin");
		System.out.println(u2.credit);
	}

}
