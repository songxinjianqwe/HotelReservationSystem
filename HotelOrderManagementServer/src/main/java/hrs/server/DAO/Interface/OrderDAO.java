package hrs.server.DAO.Interface;

import java.util.Date;
import java.util.List;

import hrs.common.POJO.OrderPO;
import hrs.common.util.ResultMessage;
import hrs.common.util.type.OrderStatus;

public interface OrderDAO {
	 OrderPO findByID(int ID);
	 List<OrderPO> findByHotelID(int hotelID);
	 List<OrderPO> findByUsernameAndStatus(String username,OrderStatus status);
	 List<OrderPO> findByHotelAndUsername(int hotelID,String username);
	 List<OrderPO> findByUsername(String username);
	 List<OrderPO> findByHotelAndStatus(int hotelID, OrderStatus type);
	 List<OrderPO> findByOrderStatus(OrderStatus status);
	 List<OrderPO> findByHotelAndTime(int hotelID,Date begin,Date end);
	 List<OrderPO> findByOrderStatusAndPlaceTime(OrderStatus status,Date begin,Date end);
	 ResultMessage add(OrderPO orderpo);
	 ResultMessage update(OrderPO orderpo);
}
