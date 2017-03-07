package test.server.DAO;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.HotelPO;
import hrs.common.POJO.OfflineRecordPO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.RoomType;
import hrs.server.DAO.Interface.OfflineRecordDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestOfflineRecordDAO {
	@Autowired
	private OfflineRecordDAO dao;

	@Transactional
	@Test
	public void testFindByID() {
		OfflineRecordPO po = dao.findByID(5);
		System.out.println(po);
		assertEquals(po.getId(), 5);
	}

	@Transactional
	@Test
	public void testAdd() throws ParseException {
		HotelPO hotel = new HotelPO();
		hotel.setId(1);
		Date begin = DateHelper.parseWithHMS("2016-10-01 08:18:12");
		Date end = DateHelper.parseWithHMS("2016-10-02 20:24:09");
		OfflineRecordPO po = new OfflineRecordPO(hotel, begin, end, RoomType.Single, 1);
		dao.add(po);
		assertEquals(dao.findByID(po.getId()), po);
	}

	@Transactional
	@Test
	public void testUpdate() {
		OfflineRecordPO po = dao.findByID(5);
		po.setNum(2);
		dao.update(po);
		assertEquals(dao.findByID(5), po);
	}
	
	@Transactional
	@Test
	public void testFindByHotelID(){
		List<OfflineRecordPO> list = dao.findByHotelID(1);
		for(OfflineRecordPO po:list){
			System.out.println(po);
			assertEquals(po.getHotel().getId(),1);
		}
	}
}
