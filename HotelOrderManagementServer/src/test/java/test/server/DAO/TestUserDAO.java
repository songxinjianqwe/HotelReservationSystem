package test.server.DAO;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.UserPO;
import hrs.common.util.DesUtil;
import hrs.common.util.type.UserType;
import hrs.server.DAO.Interface.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestUserDAO {
	@Autowired
	private UserDAO dao;

	@Transactional
	@Test
	public void testFindByUsername() {
		UserPO po = dao.findByUserName("BB3FDC628A6D0E98");
		System.out.println(po);
		assertEquals(po.getPassword(),"BB3FDC628A6D0E98");
		System.out.println(DesUtil.getInstance().decode("62705AD9289355ABD186E5A0C6DE4DA9"));
		System.out.println(DesUtil.getInstance().encode("宋欣建"));
	}

	@Transactional
	@Test
	public void testAdd() {
		//admin123 666666 150150150 AreYouOK
		UserPO po = new UserPO("9BC27F3B2939ACE257909D9E68C8AAFE", "A73A379C888ABD82BF0BE6B7B960ED89", "3871AF9FFD001DA1DC9DD693D1C27C13", "7665B5F9A725927F2EC9993BED1B6724", 0, 0, UserType.Normal);;
		dao.add(po);
		assertEquals(po,dao.findByUserName("9BC27F3B2939ACE257909D9E68C8AAFE"));
	}

	@Transactional
	@Test
	public void testUpdate() {
		UserPO po = dao.findByUserName("BB3FDC628A6D0E98");
		po.setName("DCDE7C63EEED6B23");
		dao.update(po);
		assertEquals(dao.findByUserName("BB3FDC628A6D0E98").getName(),"DCDE7C63EEED6B23");
	}
}
