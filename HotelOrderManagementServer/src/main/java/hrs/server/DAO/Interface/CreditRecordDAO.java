package hrs.server.DAO.Interface;

import java.util.List;

import hrs.common.POJO.CreditRecordPO;
import hrs.common.util.ResultMessage;

public interface CreditRecordDAO {
	 List<CreditRecordPO> findByUsername(String username);
	 ResultMessage add(CreditRecordPO creditrecordpo);
}
