package hrs.server.Service.Impl.PromotionService.WebDiscountService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.Promotion.WebDiscountService.WebDiscountNotFoundException;
import hrs.common.POJO.WebDiscountPO;
import hrs.common.VO.WebDiscountVO;
import hrs.common.util.DateHelper;
import hrs.server.DAO.Interface.PromotionDAO.WebDiscountDAO;
import hrs.server.Service.Interface.PromotionService.WebDiscountService;
import hrs.server.util.SpringUtils;
/**
 * 
* @ClassName: WebDiscountServiceImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午9:54:43
*
 */
@Service
public class WebDiscountServiceImpl implements WebDiscountService {
	@Autowired
	private WebDiscountDAO dao;
	/**
	 * 
	 * @Title: findAll
	 * @Description: 返回网站的所有优惠策略
	 * @return
	 * @throws WebDiscountNotFoundException  
	 * @see hrs.server.Service.Interface.PromotionService.WebDiscountService#findAll()
	 */
	@Transactional
	@Override
	public List<WebDiscountVO> findAll() throws WebDiscountNotFoundException {
		List<WebDiscountPO> pos = dao.findAll();
		List<WebDiscountVO> vos = null;
		if (pos.size() == 0) {
			throw new WebDiscountNotFoundException();
		} else {
			vos = new ArrayList<>();
			WebDiscountVO vo = null;
			for (WebDiscountPO po : pos) {
				vo = new WebDiscountVO(po);
				vos.add(vo);
			}
		}
		return vos;
	}
	/**
	 * 
	 * @Title: add
	 * @Description: 添加网站优惠策略
	 * @param vo  
	 * @see hrs.server.Service.Interface.PromotionService.WebDiscountService#add(hrs.common.VO.WebDiscountVO)
	 */
	@Transactional
	@Override
	public void add(WebDiscountVO vo) {
		try {
			if (vo.beginTime != null && vo.endTime != null) {
				vo.beginTime = DateHelper.parse(DateHelper.format(vo.beginTime));
				vo.endTime = DateHelper.parse(DateHelper.format(vo.endTime));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dao.add(new WebDiscountPO(vo));
	}
	/**
	 * 
	 * @Title: update
	 * @Description: 更新网站优惠策略
	 * @param vo  
	 * @see hrs.server.Service.Interface.PromotionService.WebDiscountService#update(hrs.common.VO.WebDiscountVO)
	 */
	@Transactional
	@Override
	public void update(WebDiscountVO vo) {
		dao.update(new WebDiscountPO(vo));
	}
	/**
	 *
	 * @Title: delete
	 * @Description: 删除网站优惠策略
	 * @param id  
	 * @see hrs.server.Service.Interface.PromotionService.WebDiscountService#delete(int)
	 */
	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);
	}
	/**
	 * 
	 * @Title: createAllStrategies
	 * @Description: 创建网站优惠策略的领域类
	 * @return  
	 * @see hrs.server.Service.Interface.PromotionService.WebDiscountService#createAllStrategies()
	 */
	@Transactional
	@Override
	public List<WebDiscount> createAllStrategies() {
		List<WebDiscountVO> vos;
		try {
			vos = findAll();
		} catch (WebDiscountNotFoundException e1) {
			return new ArrayList<>();
		}
		List<WebDiscount> strategies = new ArrayList<>();
		WebDiscount strategy = null;
		for (WebDiscountVO vo : vos) {
			strategy = SpringUtils.getBean(vo.type.toString()+"WebDiscount");
			strategy.setWebDiscountVO(vo);
			strategies.add(strategy);
		}
		return strategies;
	}
}
