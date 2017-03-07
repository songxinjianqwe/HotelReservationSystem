package hrs.server.DAO.Impl.HotelDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.CommercialCirclePO;
import hrs.server.DAO.Interface.HotelDAO.CommCircleDAO;
/**
 * 
* @ClassName: CommCircleDAOImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:21:17
*
 */
@Repository
public class CommCircleDAOImpl implements CommCircleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 
	 * @Title: findByLoc
	 * @Description: 按城市id查找对应的商圈
	 * @param locID
	 * @return  
	 * @see hrs.server.DAO.Interface.HotelDAO.CommCircleDAO#findByLoc(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CommercialCirclePO> findByLoc(int locID) {
		String hql = "from CommercialCirclePO cc inner join fetch cc.location  location where location.id = :locID";
		return getSession().createQuery(hql).setCacheable(true).setParameter("locID", locID).getResultList();
	}

}
