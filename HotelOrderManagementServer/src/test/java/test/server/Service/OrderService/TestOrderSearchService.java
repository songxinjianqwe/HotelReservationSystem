package test.server.Service.OrderService;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.OrderVO;
import hrs.common.util.type.OrderStatus;
import hrs.server.Service.Interface.OrderService.OrderSearchService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestOrderSearchService {
	@Autowired
	private OrderSearchService service;
	
	
	@Test
	public void testFindByID() throws OrderNotFoundException {
		OrderVO vo = service.findByID(20);
		System.out.println(vo);
		assertEquals(vo.id,20);
	}

	@Test
	public void testFindByUsernameAndStatus() throws OrderNotFoundException {
		List<OrderVO> list = service.findByUsernameAndStatus("admin", OrderStatus.Executed);
		for (OrderVO vo : list) {
			System.out.println(vo);
			assertEquals(vo.user.username, "admin");
			assertEquals(vo.status, OrderStatus.Executed);
		}
	}

	@Test
	public void testFindByHotelAndUsername() throws OrderNotFoundException {
		List<OrderVO> list = service.findByHotelAndUsername(1, "admin");
		for (OrderVO vo : list) {
			System.out.println(vo);
			assertEquals(vo.hotel.id, 1);
			assertEquals(vo.user.username, "admin");
		}
	}
	
	@Test
	public void testFindByUsername() throws OrderNotFoundException {
		List<OrderVO> list = service.findByUsername("admin");
		for (OrderVO vo : list) {
			System.out.println(vo);
			assertEquals(vo.user.username, "admin");
		}
	}
	
	@Test
	public void testFindByOrderStatus() throws OrderNotFoundException {
		List<OrderVO> list = service.findByOrderStatus(OrderStatus.Unexecuted);
		for (OrderVO vo : list) {
			System.out.println(vo);
			assertEquals(vo.status, OrderStatus.Unexecuted);
		}
	}
	
	@Test
	public void testFindByHotelID() throws OrderNotFoundException{
		List<OrderVO> list = service.findByHotelID(1);
		System.out.println(list.size());
		for (OrderVO vo : list) {
			System.out.println(vo);
			assertEquals(vo.hotel.id,1);
		}
	}
	
	@Test
	public void testFindByOrderStatusAndPlaceTime() throws OrderNotFoundException {
		List<OrderVO> list = service.findByOrderStatusAndPlaceTime(OrderStatus.Unexecuted, new Date());
		System.out.println(list.size());
		for (OrderVO vo : list) {
			System.out.println(vo);
			assertEquals(vo.status, OrderStatus.Unexecuted);
		}
	}
}
