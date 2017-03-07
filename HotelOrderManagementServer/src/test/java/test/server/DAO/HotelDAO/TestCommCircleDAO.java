package test.server.DAO.HotelDAO;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.CommercialCirclePO;
import hrs.server.DAO.Interface.HotelDAO.CommCircleDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestCommCircleDAO {
	@Autowired
	private CommCircleDAO dao;

	@Transactional
	@Test
	public void testFindByLocID() {
		List<CommercialCirclePO> list = dao.findByLoc(1);
		for (CommercialCirclePO po : list) {
			System.out.println(po);
			assertEquals(po.getLocation().getId(), 1);
		}
	}

}
