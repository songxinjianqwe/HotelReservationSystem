package hrs.server.Controller.HotelController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.HotelController.IHotelOrderController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.OrderVO;
import hrs.common.util.type.OrderStatus;
import hrs.server.Service.Interface.OrderService.OrderSearchService;
import hrs.server.Service.Interface.OrderService.OrderService;

@Controller
public class HotelOrderController implements IHotelOrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderSearchService orderSearchService;

	@Override
	public void checkin(OrderVO ordervo) {
		orderService.checkin(ordervo);
	}

	@Override
	public void checkout(OrderVO ordervo) {
		orderService.checkout(ordervo);
	}


	@Override
	public void delayCheckin(OrderVO ordervo) {
		orderService.delayCheckin(ordervo);
	}

	@Override
	public List<OrderVO> findOrderByHotelAndStatus(int hotelID, OrderStatus type) throws OrderNotFoundException {
		return orderSearchService.findByHotelAndStatus(hotelID, type);
	}

	@Override
	public List<OrderVO> findOrderByHotelAndUsername(int hotelID, String username) throws OrderNotFoundException {
		return orderSearchService.findByHotelAndUsername(hotelID, username);
	}

	@Override
	public OrderVO findOrderByID(int id) throws OrderNotFoundException {
		return orderSearchService.findByID(id);
	}
	
	@Override
	public List<OrderVO> findOrderByHotelID(int hotelID) throws OrderNotFoundException{
		return orderSearchService.findByHotelID(hotelID);
	}
}
