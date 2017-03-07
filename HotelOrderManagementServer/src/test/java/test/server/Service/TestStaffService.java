package test.server.Service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.Exception.StaffService.StaffExistedException;
import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.Exception.StaffService.StaffPasswordErrorException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.StaffVO;
import hrs.common.util.type.StaffType;
import hrs.server.Service.Interface.StaffService.StaffService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestStaffService {
	@Autowired
	private StaffService service;

	@Test(expected = StaffPasswordErrorException.class)
	public void testLogin1() throws StaffNotFoundExceptioon, StaffPasswordErrorException {
		service.login("admin", "12321311");
	}

	@Test(expected = StaffNotFoundExceptioon.class)
	public void testLogin2() throws StaffNotFoundExceptioon, StaffPasswordErrorException {
		service.login("admin213", "aaa");
	}

	@Test
	public void testLogin3() throws StaffNotFoundExceptioon, StaffPasswordErrorException {
		assertEquals(service.login("admin", "admin").username, "admin");
	}

	@Test
	public void testAdd() throws StaffNotFoundExceptioon, StaffExistedException {
		HotelVO hotel = new HotelVO();
		hotel.id = 4;
		StaffVO staff = new StaffVO("staff234", "110", "老王", StaffType.WebsiteMarketer, hotel);
		service.add(staff);
		assertEquals(service.findByUsername("staff234").password, "110");
	}

	@Test
	public void testUpdate() throws StaffNotFoundExceptioon {
		StaffVO staff = service.findByUsername("admin");
		staff.password = "111";
		service.update(staff);
		assertEquals(service.findByUsername("admin").password, "111");
	}

	@Test
	public void testFindByUsername() throws StaffNotFoundExceptioon {
		StaffVO staff = service.findByUsername("admin");
		assertEquals(staff.password, "admin");
	}

	@Test
	public void testFindByHotelName() throws StaffNotFoundExceptioon {
		List<StaffVO> vos = service.findByHotelName("酒店");
		for(StaffVO vo:vos){
			System.out.println(vo);
		}
	}
}
