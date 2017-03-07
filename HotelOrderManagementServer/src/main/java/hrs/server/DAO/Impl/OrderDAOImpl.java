package hrs.server.DAO.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.OrderPO;
import hrs.common.util.ResultMessage;
import hrs.common.util.type.OrderStatus;
import hrs.server.DAO.Interface.OrderDAO;

/**
 * 
 * @ClassName: OrderDAOImpl
 * @Description: TODO
 * @author NewSong
 * @date 2016年11月19日 下午10:15:33
 *
 */
@SuppressWarnings("all")
@Repository
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 
	 * @Title: findByID
	 * @Description: 按id查找订单
	 * @param id
	 * @return OrderPO
	 * @see hrs.server.DAO.Interface.OrderDAO#findByID(int)
	 */
	@Override
	public OrderPO findByID(int id) {
		return getSession().get(OrderPO.class, id);
	}

	/**
	 * 
	 * @Title: findByUsernameAndStatus
	 * @Description: 按用户名查找订单
	 * @param username
	 * @param status
	 * @return List<OrderPO>
	 * @see hrs.server.DAO.Interface.OrderDAO#findByUsernameAndStatus(java.lang.String,
	 *      hrs.common.util.type.OrderStatus)
	 */
	@Override
	public List<OrderPO> findByUsernameAndStatus(String username, OrderStatus status) {
		String hql = "from OrderPO o inner join fetch o.user u "
				+ "where u.username = :username and o.status = :status";
		return getSession().createQuery(hql).setCacheable(true).setParameter("username", username)
				.setParameter("status", status).getResultList();

	}

	/**
	 * 
	 * @Title: findByHotelAndUsername
	 * @Description: 按酒店和用户名查找订单列表
	 * @param hotelID
	 * @param username
	 * @return List<OrderPO>
	 * @see hrs.server.DAO.Interface.OrderDAO#findByHotelAndUsername(int,
	 *      java.lang.String)
	 */
	@Override
	public List<OrderPO> findByHotelAndUsername(int hotelID, String username) {
		String hql = "from OrderPO o " + "inner join fetch o.hotel hotel " + "inner join fetch o.user u "
				+ "where hotel.id = :hotelID and u.username = :username";
		return getSession().createQuery(hql).setCacheable(true).setParameter("hotelID", hotelID)
				.setParameter("username", username).getResultList();

	}

	/**
	 * 
	 * @Title: findByUsername
	 * @Description: 按用户名查找订单
	 * @param username
	 * @return List<OrderPO>
	 * @see hrs.server.DAO.Interface.OrderDAO#findByUsername(java.lang.String)
	 */
	@Override
	public List<OrderPO> findByUsername(String username) {
		String hql = "from OrderPO o inner join fetch o.user u " + "where u.username = :username";
		return getSession().createQuery(hql).setCacheable(true).setParameter("username", username).getResultList();

	}

	/**
	 * 
	 * @Title: findByOrderStatus
	 * @Description: 按订单状态查找订单
	 * @param status
	 * @return List<OrderPO>
	 * @see hrs.server.DAO.Interface.OrderDAO#findByOrderStatus(hrs.common.util.type.OrderStatus)
	 */
	@Override
	public List<OrderPO> findByOrderStatus(OrderStatus status) {
		String hql = "from OrderPO o where o.status = :status";
		return getSession().createQuery(hql).setCacheable(true).setParameter("status", status).getResultList();
	}

	/**
	 * 
	 * @Title: findByOrderStatusAndTime
	 * @Description: 按订单状态和某一天查询订单
	 * @param status
	 * @param today
	 * @return
	 * @see hrs.server.DAO.Interface.OrderDAO#findByOrderStatusAndTime(hrs.common.util.type.OrderStatus,
	 *      java.util.Date)
	 */
	@Override
	public List<OrderPO> findByOrderStatusAndPlaceTime(OrderStatus status, Date begin, Date end) {
		String hql = "from OrderPO o " + "where o.status = :status " + "and o.placeTime >= :begin "
				+ "and o.placeTime <= :end";
		return getSession().createQuery(hql).setCacheable(true).setParameter("status", status)
				.setParameter("begin", begin).setParameter("end", end).getResultList();

	}

	/**
	 * 
	 * @Title: findByHotelAndTime
	 * @Description: 按酒店和时间查找订单
	 * @param hotelID
	 * @param begin
	 * @param end
	 * @return List<OrderPO>
	 * @see hrs.server.DAO.Interface.OrderDAO#findByHotelAndTime(int,
	 *      java.util.Date, java.util.Date)
	 */
	@Override
	public List<OrderPO> findByHotelAndTime(int hotelID, Date begin, Date end) {
		String hql = "from OrderPO o inner join fetch o.hotel hotel " + "where hotel.id = :hotelID "
				+ "and o.execTime >= :begin " + "and o.expectedCheckoutTime <= :end";
		return getSession().createQuery(hql).setCacheable(true).setParameter("begin", begin).setParameter("end", end)
				.setParameter("hotelID", hotelID).getResultList();

	}

	/**
	 * 
	 * @Title: findByHotelAndStatus
	 * @Description: 按酒店和订单状态查找订单
	 * @param hotelID
	 * @param type
	 * @return List<OrderPO>
	 * @see hrs.server.DAO.Interface.OrderDAO#findByHotelAndStatus(int,
	 *      hrs.common.util.type.OrderStatus)
	 */
	@Override
	public List<OrderPO> findByHotelAndStatus(int hotelID, OrderStatus type) {
		String hql = "from OrderPO o inner join fetch o.hotel hotel " + "where hotel.id = :hotelID "
				+ "and o.status = :type";
		return getSession().createQuery(hql).setCacheable(true).setParameter("hotelID", hotelID)
				.setParameter("type", type).getResultList();

	}

	/**
	 * 
	 * @Title: add
	 * @Description: 添加订单
	 * @param orderpo
	 * @return ResultMessage
	 * @see hrs.server.DAO.Interface.OrderDAO#add(hrs.common.POJO.OrderPO)
	 */
	@Override
	public ResultMessage add(OrderPO orderpo) {
		getSession().save(orderpo);
		return ResultMessage.SUCCESS;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 更新订单
	 * @param orderpo
	 * @return ResultMessage
	 * @see hrs.server.DAO.Interface.OrderDAO#update(hrs.common.POJO.OrderPO)
	 */
	@Override
	public ResultMessage update(OrderPO orderpo) {
		getSession().update(orderpo);
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<OrderPO> findByHotelID(int hotelID) {
		String hql = "from OrderPO o inner join fetch o.hotel hotel " + "where hotel.id = :hotelID ";
		return getSession().createQuery(hql).setCacheable(true).setParameter("hotelID", hotelID).getResultList();
	}

}
