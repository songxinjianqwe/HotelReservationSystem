package hrs.server.DAO.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.CreditRecordPO;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.CreditRecordDAO;

@SuppressWarnings("all")
/**
 * 
* @ClassName: CreditRecordDAOImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:19:17
*
 */
@Repository
public class CreditRecordDAOImpl implements CreditRecordDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 
	 * @Title: findByUsername
	 * @Description: 按用户名查找信用记录
	 * @param username
	 * @return  List<CreditRecordPO>
	 * @see hrs.server.DAO.Interface.CreditRecordDAO#findByUsername(java.lang.String)
	 */
	@Override
	public List<CreditRecordPO> findByUsername(String username) {
		String hql = "from CreditRecordPO c inner join fetch c.user user " + "where user.username = :username";
		return getSession().createQuery(hql)
				.setParameter("username", username)
				.getResultList();

	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: 添加信用记录
	 * @param creditrecordpo
	 * @return  ResultMessage
	 * @see hrs.server.DAO.Interface.CreditRecordDAO#add(hrs.common.POJO.CreditRecordPO)
	 */
	@Override
	public ResultMessage add(CreditRecordPO creditrecordpo) {
		getSession().save(creditrecordpo);
		return ResultMessage.SUCCESS;
	}

}
