package test.server.DAO.PromotionDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.HotelDiscountPO;
import hrs.common.POJO.HotelPO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.HotelDiscountType;
import hrs.server.DAO.Interface.PromotionDAO.HotelDiscountDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestHotelDiscountDAO {
	@Autowired
	private HotelDiscountDAO dao;

	@Transactional
	@Test
	public void testAdd() throws ParseException {
		Date begin = DateHelper.parseWithHMS("2016-10-01 08:18:12");
		Date end = DateHelper.parseWithHMS("2016-10-23 20:24:09");
		HotelPO hotel = new HotelPO();
		hotel.setId(5);
		HotelDiscountPO po = new HotelDiscountPO(hotel, 0.9, HotelDiscountType.Birthday, null, 0, begin, end);
		dao.add(po);
		List<HotelDiscountPO> list = dao.findAllByHotelID(5);
		assertTrue(list.contains(po));
	}

	@Transactional
	@Test
	public void testUpdate() {
		List<HotelDiscountPO> list = dao.findAllByHotelID(4);
		HotelDiscountPO po = list.get(0);
		po.setMinQty(10);
		dao.update(po);
		list = dao.findAllByHotelID(4);
		assertEquals(list.get(0).getMinQty(),10);
	}

	@Transactional
	@Test
	public void testDelete() {
		dao.delete(10);
		assertEquals(dao.findAllByHotelID(4).size(),0);
	}

	@Transactional
	@Test
	public void testFindAllByHotelID() {
		List<HotelDiscountPO> list = dao.findAllByHotelID(4);
		for (HotelDiscountPO po : list) {
			System.out.println(po);
			assertEquals(po.getHotel().getId(), 4);
		}
	}
	
	@Transactional
	@Test
	public void testFindByHotelIDAndType(){
		List<HotelDiscountPO> list = dao.findByHotelIDAndType(1	, HotelDiscountType.Enterprise);
		for (HotelDiscountPO po : list) {
			System.out.println(po);
			assertEquals(po.getHotel().getId(), 1);
			assertEquals(po.getType(),HotelDiscountType.Enterprise);
		}
	}
}
