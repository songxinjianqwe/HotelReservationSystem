package hrs.common.Controller.WebMarketController;

import java.util.Date;
import java.util.List;

import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.OrderVO;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RestoreValueType;

public interface IWebOrderController {
	List<OrderVO> findOrderByOrderStatus(OrderStatus status) throws OrderNotFoundException;
	OrderVO findOrderByID(int id) throws OrderNotFoundException;
	void revokeOrder(OrderVO ordervo,RestoreValueType type);
	List<OrderVO> findOrderByUsername(String username) throws OrderNotFoundException;
	List<OrderVO> findOrderByUsernameAndStatus(String username, OrderStatus status) throws OrderNotFoundException;
	List<OrderVO> findOrderByOrderStatusAndPlaceTime(OrderStatus status,Date date) throws OrderNotFoundException;
}
