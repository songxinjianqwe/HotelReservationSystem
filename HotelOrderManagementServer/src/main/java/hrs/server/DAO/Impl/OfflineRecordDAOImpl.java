package hrs.server.DAO.Impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.OfflineRecordPO;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.OfflineRecordDAO;
/**
 * 
* @ClassName: OfflineRecordDAOImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:17:52
*
 */
@Repository
public class OfflineRecordDAOImpl implements OfflineRecordDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * 
	 * @Title: findByID
	 * @Description: 按id查找线下记录
	 * @param id
	 * @return  
	 * @see hrs.server.DAO.Interface.OfflineRecordDAO#findByID(int)
	 */
	@Override
	public OfflineRecordPO findByID(int id) {
		return getSession().get(OfflineRecordPO.class,id);
	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: 添加线下入住记录
	 * @param offlinerecordpo
	 * @return  
	 * @see hrs.server.DAO.Interface.OfflineRecordDAO#add(hrs.common.POJO.OfflineRecordPO)
	 */
	@Override
	public ResultMessage add(OfflineRecordPO offlinerecordpo) {
		getSession().save(offlinerecordpo);
		return ResultMessage.SUCCESS;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 更新线下入住记录
	 * @param offlinerecordpo
	 * @return  
	 * @see hrs.server.DAO.Interface.OfflineRecordDAO#update(hrs.common.POJO.OfflineRecordPO)
	 */
	@Override
	public ResultMessage update(OfflineRecordPO offlinerecordpo) {
		getSession().update(offlinerecordpo);
		return ResultMessage.SUCCESS;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OfflineRecordPO> findByHotelID(int hotelID) {
		String hql = "from OfflineRecordPO offlineRecord inner join fetch offlineRecord.hotel h "
				+ "where h.id = :hotelID";
		
		return getSession().createQuery(hql).setParameter("hotelID", hotelID).getResultList();
	}
	

}
