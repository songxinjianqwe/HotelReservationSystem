package hrs.server.DAO.Impl.HotelDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.LocationPO;
import hrs.server.DAO.Interface.HotelDAO.LocationDAO;
/**
 * 
* @ClassName: LocationDAOImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:21:00
*
 */
@Repository
public class LocationDAOImpl implements LocationDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * 
	 * @Title: findAll
	 * @Description: 返回所有城市
	 * @return  
	 * @see hrs.server.DAO.Interface.HotelDAO.LocationDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LocationPO> findAll() {
		String hql = "from LocationPO";
		return getSession().createQuery(hql).setCacheable(true).getResultList();
	}
}
