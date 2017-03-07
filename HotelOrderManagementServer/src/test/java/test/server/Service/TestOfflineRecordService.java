package test.server.Service;

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

import hrs.common.Exception.OfflineRecordService.OfflineRecordNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OfflineRecordVO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.RoomType;
import hrs.server.Service.Interface.OfflineRecordService.OfflineRecordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestOfflineRecordService {
	@Autowired
	private OfflineRecordService service;
	
	@Test
	public void testFindByID() throws OfflineRecordNotFoundException{
		OfflineRecordVO vo = service.findByID(5);
		System.out.println(vo);
		assertEquals(vo.num,3);
	}

	@Test
	public void testCheckin() throws ParseException, OfflineRecordNotFoundException{
		HotelVO hotel = new HotelVO();
		hotel.id = 1;
		Date begin = DateHelper.parseWithHMS("2016-10-05 12:00:00");
		Date end = DateHelper.parseWithHMS("2016-10-28 00:00:00");
		OfflineRecordVO vo = new OfflineRecordVO(hotel, begin, end, RoomType.Single, 3);
		service.checkin(vo);
		OfflineRecordVO res = service.findByID(6);
		vo.id = 6;
		System.out.println(res);
		assertEquals(res.num,3);
		assertEquals(res.type,RoomType.Single);
	}
	
	@Test
	public void testCheckout() throws OfflineRecordNotFoundException{
		OfflineRecordVO vo = service.findByID(5);
//		service.checkout(vo);
//		assertNotNull(service.findByID(5).checkoutTime);
	}
	
	@Transactional
	@Test
	public void testFindByHotelID() throws OfflineRecordNotFoundException{
		List<OfflineRecordVO> list = service.findByHotelID(1);
		for(OfflineRecordVO vo:list){
			System.out.println(vo);
			assertEquals(vo.hotel.id,1);
		}
	}
}
