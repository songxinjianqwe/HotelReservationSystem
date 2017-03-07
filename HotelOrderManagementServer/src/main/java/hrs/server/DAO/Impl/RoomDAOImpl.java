package hrs.server.DAO.Impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.AvailableRoomPO;
import hrs.common.POJO.RoomPO;
import hrs.common.util.ResultMessage;
import hrs.common.util.type.RoomType;
import hrs.server.DAO.Interface.RoomDAO;
/**
 * 
* @ClassName: RoomDAOImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:13:58
*
 */
@Repository
public class RoomDAOImpl implements RoomDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * 
	 * @Title: update
	 * @Description: 更新房间信息
	 * @param roompo
	 * @return  ResultMessage
	 * @see hrs.server.DAO.Interface.RoomDAO#update(hrs.common.POJO.RoomPO)
	 */
	@Override
	public ResultMessage update(RoomPO roompo) {
		getSession().merge(roompo);
		return ResultMessage.SUCCESS;
	}
	/**
	 * 
	 * @Title: add
	 * @Description: 添加房间信息
	 * @param roompo
	 * @return  ResultMessage
	 * @see hrs.server.DAO.Interface.RoomDAO#add(hrs.common.POJO.RoomPO)
	 */
	@Override
	public ResultMessage add(RoomPO roompo) {
		getSession().save(roompo);
		return ResultMessage.SUCCESS;
	}	
	
	/**
	 * 
	 * @Title: findByHotelID
	 * @Description: 按酒店id查询房间列表
	 * @param hotelID
	 * @return  List<RoomPO>
	 * @see hrs.server.DAO.Interface.RoomDAO#findByHotelID(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomPO> findByHotelID(int hotelID) {
		String hql = "from RoomPO room inner join fetch room.hotel hotel where hotel.id = ? order by room.roomValue";
		return getSession().createQuery(hql)
				.setCacheable(true)
				.setParameter(0, hotelID)
				.getResultList();

	}

	/**
	 * 
	 * @Title: findAvailableRoomNum
	 * @Description:包含begin那天，不包含end那天
	 * @param hotelID
	 * @param type
	 * @param begin
	 * @param end
	 * @return int
	 * @see hrs.server.DAO.Interface.RoomDAO#findAvailableRoomNum(int,
	 *      hrs.common.util.type.RoomType, java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int findAvailableRoomNum(int hotelID, RoomType type, Date begin, Date end) {
		String hql = "from AvailableRoomPO ar inner join fetch ar.hotel hotel where hotel.id = :hotelID and ar.type = :type and ar.roomDate >= :begin and ar.roomDate < :end";
		List<AvailableRoomPO> list = null;
		list = getSession().createQuery(hql)
				.setCacheable(true)
				.setParameter("hotelID", hotelID).setParameter("type", type)
				.setParameter("begin", begin).setParameter("end", end).getResultList();
		if (list.size() == 0) {
			return findByHotelAndType(hotelID, type).getRoomNum();
		} else {
			return Collections.min(list).getAvailableRoomNum();
		}
	}
	/**
	 * 
	 * @Title: findByHotelAndType
	 * @Description: 按酒店和房间类型查询房间
	 * @param hotelID
	 * @param type
	 * @return  RoomPO
	 * @see hrs.server.DAO.Interface.RoomDAO#findByHotelAndType(int, hrs.common.util.type.RoomType)
	 */
	@Override
	public RoomPO findByHotelAndType(int hotelID, RoomType type) {
		String hql = "from RoomPO room inner join fetch room.hotel hotel where hotel.id = :hotelID and room.type = :type";
		RoomPO po = null;
		try {
			po = (RoomPO) getSession().createQuery(hql)
					.setCacheable(true)
					.setParameter("hotelID", hotelID).setParameter("type", type)
					.getSingleResult();
		} catch (NoResultException e) {
			
		}
		return po;
	}
}
