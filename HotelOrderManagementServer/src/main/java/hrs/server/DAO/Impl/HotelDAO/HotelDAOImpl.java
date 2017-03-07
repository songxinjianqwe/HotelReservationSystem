package hrs.server.DAO.Impl.HotelDAO;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.HotelPO;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.HotelDAO.HotelDAO;
/**
 * 
* @ClassName: HotelDAOImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:21:58
*
 */
@Repository
public class HotelDAOImpl implements HotelDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * 
	 * @Title: findByID
	 * @Description: 按id查找酒店
	 * @param hotelID
	 * @return  
	 * @see hrs.server.DAO.Interface.HotelDAO.HotelDAO#findByID(int)
	 */
	@Override
	public HotelPO findByID(int hotelID) {
		return getSession().get(HotelPO.class, hotelID);
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: 更新酒店信息
	 * @param hotelpo
	 * @return  
	 * @see hrs.server.DAO.Interface.HotelDAO.HotelDAO#update(hrs.common.POJO.HotelPO)
	 */
	@Override
	public ResultMessage update(HotelPO hotelpo) {
		getSession().update(hotelpo);
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: 添加酒店信息
	 * @param hotelpo
	 * @return  
	 * @see hrs.server.DAO.Interface.HotelDAO.HotelDAO#add(hrs.common.POJO.HotelPO)
	 */
	@Override
	public ResultMessage add(HotelPO hotelpo) {
		getSession().save(hotelpo);
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 
	 * @Title: find
	 * @Description: 按照城市和商圈来查找酒店
	 * @param loc
	 * @param circle
	 * @return  
	 * @see hrs.server.DAO.Interface.HotelDAO.HotelDAO#find(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<HotelPO> find(int loc, int circle) {
		String hql = "from HotelPO hotel inner join fetch hotel.location loc "
									  + "inner join fetch hotel.commercialCircle circle "
									  + "where loc.id = :loc and circle.id = :circle";

		return getSession().createQuery(hql).setCacheable(true).setParameter("loc", loc).setParameter("circle", circle).getResultList();
	}
	@Override
	public HotelPO findByName(String name) {
		String hql = "from HotelPO hotel where hotel.name = :name";
		HotelPO po = null;
		try{
			po = (HotelPO) getSession().createQuery(hql).setParameter("name", name).getSingleResult();
		}catch(NoResultException e){
		}
		return po;
	}

}
