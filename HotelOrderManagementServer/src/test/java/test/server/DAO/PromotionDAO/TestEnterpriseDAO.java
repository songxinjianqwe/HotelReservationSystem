package test.server.DAO.PromotionDAO;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.EnterprisePO;
import hrs.server.DAO.Interface.PromotionDAO.EnterpriseDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestEnterpriseDAO {
	@Autowired
	private EnterpriseDAO dao;
	@Transactional
	@Test
	public void testFindAll(){
		List<EnterprisePO> list=dao.findAll();
		for(EnterprisePO po : list){
			System.out.println(po);
		}
		assertNotNull(list);
	}
	
	@Transactional
	@Test
	public void testAdd(){
		EnterprisePO po = new EnterprisePO("青年旅社");
		dao.add(po);
		List<EnterprisePO> list = dao.findAll();
		assertTrue(list.contains(po));
	}
	
}
