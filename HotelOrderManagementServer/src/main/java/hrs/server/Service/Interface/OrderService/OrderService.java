package hrs.server.Service.Interface.OrderService;

import hrs.common.VO.OrderVO;
import hrs.common.util.type.RestoreValueType;

public interface OrderService {

	OrderVO placeOrder(OrderVO ordervo) ;
	void add(OrderVO ordervo);
	void checkin(OrderVO ordervo);
	void checkout(OrderVO ordervo);
	void revokeByUser(OrderVO ordervo);
	void revokeByWebMarketer(OrderVO ordervo,RestoreValueType type);
	void remark(OrderVO ordervo,int score, String evaluation);
	void delayCheckin(OrderVO ordervo);
	void checkAbNormalOrder();
}
