package hrs.server.DAO.Impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.StaffPO;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.StaffDAO;
/**
 * 
* @ClassName: StaffDAOImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:12:23
*
 */
@Repository
public class StaffDAOImpl implements StaffDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: 更新职员信息
	 * @param staffpo
	 * @return ResultMessage
	 * @see hrs.server.DAO.Interface.StaffDAO#update(hrs.common.POJO.StaffPO)
	 */
	@Override	
	public ResultMessage update(StaffPO staffpo) {
		getSession().update(staffpo);
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: 添加职员
	 * @param staffpo
	 * @return  
	 * @see hrs.server.DAO.Interface.StaffDAO#add(hrs.common.POJO.StaffPO)
	 */
	@Override
	public ResultMessage add(StaffPO staffpo) {
		if(findByUsername(staffpo.getUsername()) != null){
			return ResultMessage.EXISTED;
		}else{
			getSession().save(staffpo);
			return ResultMessage.SUCCESS;
		}
	}
	
	/**
	 * 
	 * @Title: findByUsername
	 * @Description: 按用户名查找职员
	 * @param username
	 * @return StaffPO
	 * @see hrs.server.DAO.Interface.StaffDAO#findByUsername(java.lang.String)
	 */
	@Override
	public StaffPO findByUsername(String username) {
		String hql = "from StaffPO staff where staff.username = :username";
		StaffPO po = null;
		try{
			po = (StaffPO) getSession().createQuery(hql).setParameter("username", username).getSingleResult();
		}catch(NoResultException e){}
		return po;
	}
	
	/**
	 * 
	 * @Title: findByHotelName
	 * @Description: 按酒店名查找酒店工作人员
	 * @param hotelName
	 * @return  
	 * @see hrs.server.DAO.Interface.StaffDAO#findByHotelName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StaffPO> findByHotelName(String hotelName) {
		String hql = "from StaffPO staff inner join fetch staff.hotel hotel where hotel.name like :hotelName";
		return getSession().createQuery(hql)
				.setParameter("hotelName", "%"+hotelName+"%")
				.getResultList();
	}

}
