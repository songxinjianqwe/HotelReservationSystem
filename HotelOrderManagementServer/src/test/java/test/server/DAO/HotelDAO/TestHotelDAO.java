package test.server.DAO.HotelDAO;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.CommercialCirclePO;
import hrs.common.POJO.HotelPO;
import hrs.common.POJO.LocationPO;
import hrs.common.POJO.StaffPO;
import hrs.server.DAO.Interface.HotelDAO.HotelDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestHotelDAO {
	@Autowired
	private HotelDAO dao;

	@Transactional
	@Test
	public void testFind() {
		List<HotelPO> pos = dao.find(1, 1);
		for (HotelPO po : pos) {
			System.out.println(po);
			assertEquals(po.getLocation().getId(), 1);
			assertEquals(po.getCommercialCircle().getId(), 1);
		}
	}

	@Transactional
	@Test
	public void testFindByID() {
		HotelPO po = dao.findByID(1);
		assertEquals(po.getId(),1);
		System.out.println("TestHotelDAO:"+po.getCommercialCircle());
	}

	@Transactional
	@Test
	public void testUpdate() {
		HotelPO po = dao.findByID(1);
		po.setName("九九九店");
		assertEquals(dao.findByID(1).getName(),"九九九店");
	}

	@Transactional
	@Test
	public void testAdd() {
		LocationPO loc = new LocationPO();
		loc.setId(1);
		CommercialCirclePO circle = new CommercialCirclePO();
		circle.setId(2);
		StaffPO staff = new StaffPO();
		staff.setId(2);
		HotelPO po = new HotelPO("wuli韬韬",5,3, loc, circle, "good", "good",staff,"街道",1);
		dao.add(po);
		assertEquals(po, dao.findByID(po.getId()));
	}
	
	@Transactional
	@Test
	public void testFindByName1(){
		HotelPO po = dao.findByName("呼呼呼酒店");
		System.out.println(po);
		assertEquals(po.getName(),"呼呼呼酒店");
	}
	
	@Transactional
	@Test
	public void testFindByName2(){
		HotelPO po = dao.findByName("呼呼sd 大酒店");
		System.out.println(po);
		assertNull(po);
	}
}
