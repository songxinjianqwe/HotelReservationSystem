package hrs.server.DAO.Interface.PromotionDAO;

import java.util.List;

import hrs.common.POJO.EnterprisePO;
import hrs.common.util.ResultMessage;

public interface EnterpriseDAO {
	List<EnterprisePO> findAll();
	ResultMessage add(EnterprisePO po);
}
