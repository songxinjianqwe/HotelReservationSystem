package test.server.DAO.PromotionDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.WebDiscountPO;
import hrs.common.util.type.WebsiteDiscountType;
import hrs.server.DAO.Interface.PromotionDAO.WebDiscountDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestWebDiscountDAO {
	@Autowired
	private WebDiscountDAO dao;
	
	@Transactional
	@Test
	public void testAdd() {
		WebDiscountPO po = new WebDiscountPO(0.8, WebsiteDiscountType.VIP, null, null, 3);
		dao.add(po);
		assertTrue(dao.findAll().contains(po));
	}
	@Transactional
	@Test
	public void testUpdate() {
		WebDiscountPO po = dao.findAll().get(0);
		po.setDiscount(0.9);
		dao.update(po);
		assertEquals(dao.findAll().get(0).getDiscount(), 0.9, 0.001);
	}
	@Transactional
	@Test
	public void testFindAll() {
		List<WebDiscountPO> pos = dao.findAll();
		for (WebDiscountPO po : pos) {
			System.out.println(po);
		}
		assertNotNull(pos);
	}
	@Transactional
	@Test
	public void testDelete() {
		List<WebDiscountPO> list = dao.findAll();
		WebDiscountPO po = list.get(0);
		dao.delete(po.getId());
		assertFalse(dao.findAll().contains(po.getId()));
	}
	
	
}
