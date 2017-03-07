package test.server.DAO.HotelDAO;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.LocationPO;
import hrs.server.DAO.Interface.HotelDAO.LocationDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestLocationDAO {
	@Autowired
	private LocationDAO dao;
	
	@Transactional
	@Test
	public void testFindAll() {
		List<LocationPO> list = dao.findAll();
		for (LocationPO po : list) {
			System.out.println(po);
		}
		assertNotNull(list);
	}

}
