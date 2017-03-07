package test.server.Service.OrderService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.Exception.CreditRecordService.CreditRecordNotFoundException;
import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.VO.CreditRecordVO;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.UserVO;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RestoreValueType;
import hrs.common.util.type.RoomType;
import hrs.server.Service.Interface.CreditRecordService.CreditRecordService;
import hrs.server.Service.Interface.HotelService.HotelService;
import hrs.server.Service.Interface.OrderService.OrderSearchService;
import hrs.server.Service.Interface.OrderService.OrderService;
import hrs.server.Service.Interface.UserService.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestOrderService {
	@Autowired
	private OrderService service;
	@Autowired
	private OrderSearchService searchService;
	@Autowired
	private UserService userService;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private CreditRecordService creditRecordService;
	

	@Test
	public void testAdd() throws ParseException, OrderNotFoundException {
		HotelVO hotel = new HotelVO();
		hotel.id = 1;
		UserVO user = new UserVO();
		user.id = 1;
		Date placeTime = DateHelper.parseWithHMS("2016-10-05 12:00:00");
		Date execTime = DateHelper.parseWithHMS("2016-10-29 00:00:00");
		Date expectedCheckoutTime = DateHelper.parseWithHMS("2016-10-30 00:00:00");
		OrderVO vo = new OrderVO(placeTime, execTime,null,expectedCheckoutTime,null,null, OrderStatus.Unexecuted, hotel, 300, RoomType.Single, 1,
				false, user, 1,"ok",1);
		service.add(vo);
		List<OrderVO> list = searchService.findByHotelAndStatus(1, OrderStatus.Unexecuted);
		for(OrderVO order:list){
			if(order.evaluation != null && order.evaluation.equals("ok")){
				return;
			}
		}
		fail();
	}

	@Test
	public void testCheckin() throws OrderNotFoundException {
		service.revokeByUser(searchService.findByID(28));
		OrderVO vo = searchService.findByID(28);
		assertNotNull(vo.revokeTime);
		assertEquals(vo.status,OrderStatus.UserRevoked);
	}
	
	@Test
	public void testPlaceOrder() throws ParseException, HotelNotFoundException, UserNotFoundException{
		HotelVO hotel = hotelService.findByID(1);
		System.out.println("DEBUG:"+hotel.commercialCircle);
		UserVO user = userService.findByUsername("admin");
		Date placeTime = DateHelper.parseWithHMS("2016-11-17 12:00:00");
		Date execTime = DateHelper.parseWithHMS("2016-11-20 00:00:00");
		Date expectedCheckoutTime = DateHelper.parseWithHMS("2016-11-30 00:00:00");
		OrderVO vo = new OrderVO(placeTime, execTime,null,expectedCheckoutTime,null,null, OrderStatus.Unexecuted, hotel, 300, RoomType.Single, 3,
				false, user, 1,"ok",1);
		vo = service.placeOrder(vo);
		for(HotelDiscountVO disc:vo.hotelDiscounts.keySet()){
			System.out.println("HotelDiscount:"+disc.type+"   "+vo.hotelDiscounts.get(disc));
		}
		for(WebDiscountVO disc:vo.webDiscounts.keySet()){
			System.out.println("WebDiscount:"+disc.type+"   "+vo.webDiscounts.get(disc));
		}
		System.out.println(vo.value);
	}
	
	
	
	@Test
	public void testCheckout() throws OrderNotFoundException{
		OrderVO vo = searchService.findByID(16);
		service.checkout(vo);
		vo = searchService.findByID(16);
		System.out.println(vo);
		assertNotNull(vo.checkoutTime);
	}
	
	@Test
	public void testRevokeByUser() throws CreditRecordNotFoundException, OrderNotFoundException{
		OrderVO vo = searchService.findByID(29);
		service.revokeByUser(vo);
		vo = searchService.findByID(29);
		assertEquals(vo.status,OrderStatus.UserRevoked);
		List<CreditRecordVO> records = creditRecordService.findByUsername("admin");
		for(CreditRecordVO c:records){
			System.out.println(c);
		}
	}
	
	@Test
	public void testRevokeByWebMarketer() throws CreditRecordNotFoundException, OrderNotFoundException{
		OrderVO vo = searchService.findByID(27);
		service.revokeByWebMarketer(vo, RestoreValueType.Full);
		vo = searchService.findByID(27);
		assertNotNull(vo.revokeTime);
		List<CreditRecordVO> records = creditRecordService.findByUsername("admin2");
		for(CreditRecordVO c:records){
			System.out.println(c);
		}
	}
	
	@Test
	public void testRemark() throws HotelNotFoundException, OrderNotFoundException{
		OrderVO vo = searchService.findByID(25);
		service.remark(vo, 10, "呵呵哒");
		assertEquals(searchService.findByID(25).evaluation,"呵呵哒");
		HotelVO hotel = hotelService.findByID(1);
		System.out.println(hotel);
		assertEquals(hotel.score,10,0.01);
		
	}
	
	@Test
	public void testDelayCheckin() throws CreditRecordNotFoundException, OrderNotFoundException{
		OrderVO vo = searchService.findByID(30);
		service.delayCheckin(vo);
		vo = searchService.findByID(30);
		assertNotNull(vo.checkinTime);
		assertEquals(vo.status,OrderStatus.Executed);
		List<CreditRecordVO> list = creditRecordService.findByUsername("admin");
		for(CreditRecordVO record:list){
			System.out.println(record);
		}
	}
	
	@Test
	public void testCheckAbNormal() throws CreditRecordNotFoundException, OrderNotFoundException{
		service.checkAbNormalOrder();
		assertEquals(searchService.findByID(31).status,OrderStatus.Abnormal);
		List<CreditRecordVO> list = creditRecordService.findByUsername("admin2");
		for(CreditRecordVO record:list){
			System.out.println(record);
		}
	}
}
