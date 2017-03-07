package hrs.server.DAO.Impl.PromotionDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.EnterprisePO;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.PromotionDAO.EnterpriseDAO;
/**
 * 
* @ClassName: EnterpriseDAOImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:20:28
*
 */
@Repository
public class EnterpriseDAOImpl implements EnterpriseDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * 
	 * @Title: findAll
	 * @Description: 查找所有企业
	 * @return  
	 * @see hrs.server.DAO.Interface.PromotionDAO.EnterpriseDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EnterprisePO> findAll() {
		String hql = "from EnterprisePO ";
		return getSession().createQuery(hql).getResultList();
	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: 添加一个企业
	 * @param po
	 * @return  
	 * @see hrs.server.DAO.Interface.PromotionDAO.EnterpriseDAO#add(hrs.common.POJO.EnterprisePO)
	 */
	@Override
	public ResultMessage add(EnterprisePO po) {
		getSession().save(po);
		return ResultMessage.SUCCESS;
	}

}
