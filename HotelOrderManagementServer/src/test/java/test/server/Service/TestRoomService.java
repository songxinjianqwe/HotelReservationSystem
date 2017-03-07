package test.server.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.RoomService.RoomNotFoundException;
import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.RoomType;
import hrs.server.Service.Interface.RoomService.RoomService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestRoomService {
	@Autowired
	private RoomService service;

	@Transactional
	@Test
	public void testUpdate() throws RoomNotFoundException {
		RoomVO vo = service.findByHotelAndType(1, RoomType.Single);
		vo.roomNum = 9;
		service.update(vo);
		assertEquals(9, service.findByHotelAndType(1, RoomType.Single).roomNum);
	}

	@Transactional
	@Test
	public void testAdd() throws RoomNotFoundException {
		HotelVO hotel = new HotelVO();
		hotel.id = 6;
		RoomVO vo = new RoomVO(hotel, RoomType.Business, 20, 800);
		service.add(vo);
		assertEquals(vo, service.findByHotelAndType(6, RoomType.Business));
	}

	@Transactional
	@Test
	public void testFindByHotelAndType() throws RoomNotFoundException {
		RoomVO vo = service.findByHotelAndType(1, RoomType.Single);
		assertEquals(8, vo.roomNum);
	}

	@Transactional
	@Test
	public void testFindNotAddedRoomType() {
		List<RoomType> types = service.findNotAddedRoomType(1);
		for (RoomType type : types) {
			System.out.println(type);
		}
		assertFalse(types.contains(RoomType.Single));
	}

	@Transactional
	@Test
	public void testFindAvailableByHotelID() throws ParseException {
		Date begin = DateHelper.parseWithHMS("2016-10-05 12:00:00");
		Date end = DateHelper.parseWithHMS("2016-10-28 00:00:00");
		List<RoomVO> list = service.findAvailableByHotelID(1, begin, end);
		for (RoomVO vo : list) {
			System.out.println(vo);
		}
		assertNotNull(list);
	}

	@Transactional
	@Test
	public void testFindAvailableRoomNum() throws ParseException {
		Date begin = DateHelper.parseWithHMS("2016-10-05 12:00:00");
		Date end = DateHelper.parseWithHMS("2016-10-28 00:00:00");
		assertEquals(service.findAvailableRoomNum(1, RoomType.Single, begin, end), 5);
	}

	@Transactional
	@Test
	public void testFindByHotelID() throws RoomNotFoundException {
		List<RoomVO> list = service.findByHotelID(4);
		for (RoomVO vo : list) {
			System.out.println(vo);
			assertEquals(vo.hotel.id, 4);
		}
	}

}
