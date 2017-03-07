package test.server.DAO;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.HotelPO;
import hrs.common.POJO.StaffPO;
import hrs.common.util.type.StaffType;
import hrs.server.DAO.Interface.StaffDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestStaffDAO {
	@Autowired
	private StaffDAO dao;

	@Transactional
	@Test
	public void testAdd() {
		HotelPO hotel = new HotelPO();
		hotel.setId(4);
		StaffPO po = new StaffPO("hotelmanager", "130130130", "wang", StaffType.HotelStaff, hotel);
		dao.add(po);
		assertEquals(po,dao.findByUsername("hotelmanager"));
	}

	@Transactional
	@Test
	public void testUpdate() {
		StaffPO po = dao.findByUsername("admin3");
		po.setName("lulu");
		dao.update(po);
		assertEquals(dao.findByUsername("admin3").getName(),"lulu");
	}

	@Transactional
	@Test
	public void testFindByUsername() {
		assertEquals(dao.findByUsername("BB3FDC628A6D0E98").getUsername(),"BB3FDC628A6D0E98");
	}

	@Transactional
	@Test
	public void testFindByHotelName() {
		List<StaffPO> list = dao.findByHotelName("酒店");
		for(StaffPO po : list){
			System.out.println(po);
		}
	}
}
