package hrs.server.DAO.Impl;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.UserPO;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.UserDAO;
/**
 * 
* @ClassName: UserDAOImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:11:32
*
 */
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 
	 * @Title: findByUserName
	 * @Description: 按用户名查询用户
	 * @param username
	 * @return  
	 * @see hrs.server.DAO.Interface.UserDAO#findByUserName(java.lang.String)
	 */
	@Override
	public UserPO findByUserName(String username) {
		String hql = "from UserPO as user  where user.username = :username";
		UserPO po = null;
		try {
			po = (UserPO) getSession().createQuery(hql).setParameter("username", username).getSingleResult();
		} catch (NoResultException e) {
			
		}
		return po;
	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: 添加用户
	 * @param userpo
	 * @return  ResultMessage
	 * @see hrs.server.DAO.Interface.UserDAO#add(hrs.common.POJO.UserPO)
	 */
	@Override
	public ResultMessage add(UserPO userpo) {
		if (findByUserName(userpo.getUsername()) != null) {
			return ResultMessage.EXISTED;
		} else {
			getSession().save(userpo);
			return ResultMessage.SUCCESS;
		}
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: 更新用户信息
	 * @param userpo
	 * @return ResultMessage
	 * @see hrs.server.DAO.Interface.UserDAO#update(hrs.common.POJO.UserPO)
	 */
	@Override
	public ResultMessage update(UserPO userpo) {
		getSession().merge(userpo);
		return ResultMessage.SUCCESS;
	}

}
