package hrs.server.DAO.Impl.PromotionDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.HotelDiscountPO;
import hrs.common.util.ResultMessage;
import hrs.common.util.type.HotelDiscountType;
import hrs.server.DAO.Interface.PromotionDAO.HotelDiscountDAO;

@SuppressWarnings("all")
@Repository
public class HotelDiscountDAOImpl implements HotelDiscountDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public ResultMessage add(HotelDiscountPO hoteldiscountpo) {
		getSession().save(hoteldiscountpo);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(HotelDiscountPO hoteldiscountpo) {
		getSession().update(hoteldiscountpo);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(int id) {
		HotelDiscountPO po = new HotelDiscountPO();
		po.setId(id);
		getSession().delete(po);
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<HotelDiscountPO> findAllByHotelID(int hotelID) {
		String hql = "from HotelDiscountPO disc inner join fetch disc.hotel hotel " + "where hotel.id = :hotelID";
		return getSession().createQuery(hql).setParameter("hotelID", hotelID).getResultList();
	}

	@Override
	public List<HotelDiscountPO> findByHotelIDAndType(int hotelID, HotelDiscountType type) {
		String hql = "from HotelDiscountPO disc inner join fetch disc.hotel hotel " 
					 + "where hotel.id = :hotelID and disc.type = :type";
		return getSession().createQuery(hql).setParameter("hotelID", hotelID)
										    .setParameter("type", type)
										    .getResultList();
	}

}
