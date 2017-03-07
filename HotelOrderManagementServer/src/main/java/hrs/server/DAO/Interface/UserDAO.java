package hrs.server.DAO.Interface;

import hrs.common.POJO.UserPO;
import hrs.common.util.ResultMessage;

public interface UserDAO {
	UserPO findByUserName(String username);
	ResultMessage add(UserPO userpo);
	ResultMessage update(UserPO userpo);
}	
