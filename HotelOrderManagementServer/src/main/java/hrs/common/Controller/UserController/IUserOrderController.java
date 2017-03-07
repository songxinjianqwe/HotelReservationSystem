package hrs.common.Controller.UserController;

import java.util.List;

import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.VO.OrderVO;
import hrs.common.VO.UserVO;
import hrs.common.util.type.OrderStatus;

public interface IUserOrderController {
	List<OrderVO> findOrdersByUsernameAndStatus(String username, OrderStatus type) throws OrderNotFoundException;
	boolean validateCredit(String username);
	OrderVO placeOrder(OrderVO ordervo);
	void addOrder(OrderVO ordervo);
	void remark(OrderVO ordervo,int score,String evaluation);
	void revoke(OrderVO ordervo);
	void charge(UserVO user,int money);
	List<OrderVO> findByUsername(String username) throws OrderNotFoundException;
}
