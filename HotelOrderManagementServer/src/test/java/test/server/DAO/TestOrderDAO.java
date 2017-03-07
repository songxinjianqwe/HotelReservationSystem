package test.server.DAO;

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

import hrs.common.POJO.HotelPO;
import hrs.common.POJO.OrderPO;
import hrs.common.POJO.UserPO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RoomType;
import hrs.server.DAO.Interface.OrderDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestOrderDAO {
	@Autowired
	private OrderDAO dao;
	@Transactional	
	@Test
	public void testFindByID() {
		OrderPO po = dao.findByID(15);
		assertEquals(po.getId(), 15);
	}

	@Transactional
	@Test
	public void testFindByUsernameAndType() {
		List<OrderPO> list = dao.findByUsernameAndStatus("admin", OrderStatus.Unexecuted);
		for (OrderPO po : list) {
			System.out.println(po);
			assertEquals(po.getUser().getUsername(), "admin");
			assertEquals(po.getStatus(), OrderStatus.Unexecuted);
		}
	}

	@Transactional
	@Test
	public void testFindByHotelAndUsername() {
		List<OrderPO> list = dao.findByHotelAndUsername(1, "admin");
		for (OrderPO po : list) {
			System.out.println(po);
			assertEquals(po.getHotel().getId(), 1);
			assertEquals(po.getUser().getUsername(), "admin");
		}
	}

	@Transactional
	@Test
	public void testFindByUsername() {
		List<OrderPO> list = dao.findByUsername("admin");
		for (OrderPO po : list) {
			System.out.println(po);
			assertEquals(po.getUser().getUsername(), "admin");
		}
	}

	@Transactional
	@Test
	public void testFindByOrderType() {
		List<OrderPO> list = dao.findByOrderStatus(OrderStatus.Unexecuted);
		for (OrderPO po : list) {
			System.out.println(po);
			assertEquals(po.getStatus(), OrderStatus.Unexecuted);
		}
	}

	@Transactional
	@Test
	public void testFindByHotelAndTime() throws ParseException {
		Date begin = DateHelper.parseWithHMS("2016-10-01 08:18:12");
		Date end = DateHelper.parseWithHMS("2016-10-23 20:24:09");
		List<OrderPO> list = dao.findByHotelAndTime(1, begin, end);
		System.out.println(list.size());
		for (OrderPO po : list) {
			System.out.println(po);
			assertTrue(po.getExecTime().after(begin));
			assertTrue(po.getExpectedCheckoutTime().before(end));
		}
	}
	
	@Transactional
	@Test
	public void testFindByHotelAndType(){
		List<OrderPO> list = dao.findByHotelAndStatus(1, OrderStatus.Unexecuted);
		for(OrderPO po:list){
			System.out.println(po);
			assertEquals(po.getHotel().getId(),1);
			assertEquals(po.getStatus(),OrderStatus.Unexecuted);
		}
	}
	
	@Transactional
	@Test
	public void testAdd() throws ParseException {
		Date curr = DateHelper.parseWithHMS("2016-10-01 02:18:12");
		Date begin = DateHelper.parseWithHMS("2016-10-01 08:18:12");
		Date end = DateHelper.parseWithHMS("2016-10-23 20:24:09");
		HotelPO hotel = new HotelPO();
		hotel.setId(1);
		UserPO user = new UserPO();
		user.setId(2);
		OrderPO po = new OrderPO(curr,begin, end, OrderStatus.Unexecuted, hotel, 300, RoomType.Single, 1,
				false, user);
		dao.add(po);
		assertEquals(dao.findByID(po.getId()),po);
	}

	@Transactional
	@Test
	public void testUpdate() {
		OrderPO po = dao.findByID(10);
		po.setNum(10);
		dao.update(po);
		assertEquals(dao.findByID(10).getNum(), 10);
	}
	
	@Transactional
	@Test
	public void testFindByHotelID(){
		List<OrderPO> list = dao.findByHotelID(1);
		System.out.println(list.size());
		for (OrderPO po : list) {
			System.out.println(po);
			assertEquals(po.getHotel().getId(),1);
		}
	}
	
	@Transactional
	@Test
	public void testFindByOrderStatusAndTime() throws ParseException{
		Date begin = DateHelper.parseWithHMS("2016-12-23 00:00:00");
		Date end = DateHelper.parseWithHMS("2016-12-23 23:59:59");
		System.out.println(begin);
		System.out.println(end);
		List<OrderPO> list = dao.findByOrderStatusAndPlaceTime(OrderStatus.Unexecuted, begin, end);
		System.out.println(list.size());
		for (OrderPO po : list) {
			System.out.println(po);
			assertEquals(po.getStatus(),OrderStatus.Unexecuted);
		}
	}
	
	
}
