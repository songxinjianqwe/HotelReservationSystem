package hrs.server.DAO.Impl.PromotionDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hrs.common.POJO.WebDiscountPO;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.PromotionDAO.WebDiscountDAO;

@Repository
public class WebDiscountDAOImpl implements WebDiscountDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public ResultMessage add(WebDiscountPO webdiscountpo) {
		getSession().save(webdiscountpo);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage update(WebDiscountPO webdiscountpo) {
		getSession().update(webdiscountpo);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(int id) {
		WebDiscountPO po = new WebDiscountPO();
		po.setId(id);
		getSession().delete(po);
		return ResultMessage.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WebDiscountPO> findAll() {
		String hql = "from WebDiscountPO";
		return getSession().createQuery(hql).getResultList();
	}

}
