package test.server.DAO;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.CreditRecordPO;
import hrs.common.POJO.UserPO;
import hrs.common.util.type.CreditRecordType;
import hrs.server.DAO.Interface.CreditRecordDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestCreditRecordDAO {
	@Autowired
	private CreditRecordDAO dao;

	@Transactional
	@Test
	public void testFindByUsername() {
		List<CreditRecordPO> list = dao.findByUsername("admin");
		for (CreditRecordPO po : list) {
			System.out.println(po);
			assertEquals(po.getUser().getUsername(), "admin");
		}
	}

	@Transactional
	@Test
	public void testAdd() {
		UserPO user = new UserPO();
		user.setId(1);
		CreditRecordPO po = new CreditRecordPO(null, user, CreditRecordType.Recharge, 400, 800);
		dao.add(po);
		assertEquals(po.getUser().getId(), 1);
	}

}
