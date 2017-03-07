package hrs.server.Service.Interface.OrderService;

import java.util.Date;
import java.util.List;

import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.POJO.OrderPO;
import hrs.common.VO.OrderVO;
import hrs.common.util.type.OrderStatus;

public interface OrderSearchService {
	OrderVO findByID(int id) throws OrderNotFoundException;

	List<OrderVO> findByHotelAndStatus(int hotelID, OrderStatus type) throws OrderNotFoundException;

	List<OrderVO> findByUsernameAndStatus(String username, OrderStatus type) throws OrderNotFoundException;

	List<OrderVO> findByUsername(String username) throws OrderNotFoundException;

	List<OrderVO> findByHotelAndUsername(int hotelID, String username) throws OrderNotFoundException;

	List<OrderVO> findByOrderStatus(OrderStatus status) throws OrderNotFoundException;

	List<OrderVO> findByHotelAndTime(int hotelID, Date begin, Date end) throws OrderNotFoundException;

	List<OrderVO> findByHotelID(int hotelID) throws OrderNotFoundException;

	List<OrderVO> findByOrderStatusAndPlaceTime(OrderStatus status,Date date) throws OrderNotFoundException;
}
