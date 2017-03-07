package hrs.server.Controller.WebMarketController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.WebMarketController.IWebOrderController;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.OrderVO;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RestoreValueType;
import hrs.server.Service.Interface.OrderService.OrderSearchService;
import hrs.server.Service.Interface.OrderService.OrderService;
@Controller
public class WebOrderController implements IWebOrderController{
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderSearchService orderSearchService;
	
	@Override
	public List<OrderVO> findOrderByOrderStatus(OrderStatus status) throws OrderNotFoundException {
		return orderSearchService.findByOrderStatus(status);
	}

	@Override
	public OrderVO findOrderByID(int id) throws OrderNotFoundException {
		return orderSearchService.findByID(id);
	}

	@Override
	public void revokeOrder(OrderVO ordervo,RestoreValueType type) {
		orderService.revokeByWebMarketer(ordervo, type);
	}

	@Override
	public List<OrderVO> findOrderByUsername(String username) throws OrderNotFoundException {
		return orderSearchService.findByUsername(username);
	}

	@Override
	public List<OrderVO> findOrderByUsernameAndStatus(String username, OrderStatus status)
			throws OrderNotFoundException {
		return orderSearchService.findByUsernameAndStatus(username, status);
	}
	
	@Override
	public List<OrderVO> findOrderByOrderStatusAndPlaceTime(OrderStatus status,Date date) throws OrderNotFoundException{
		return orderSearchService.findByOrderStatusAndPlaceTime(status, date);
	}
}
