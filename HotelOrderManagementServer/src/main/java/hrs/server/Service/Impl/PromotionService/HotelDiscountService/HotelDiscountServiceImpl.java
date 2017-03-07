package hrs.server.Service.Impl.PromotionService.HotelDiscountService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.Promotion.HotelDiscountService.HotelDiscountNotFoundException;
import hrs.common.POJO.HotelDiscountPO;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.HotelDiscountType;
import hrs.server.DAO.Interface.PromotionDAO.HotelDiscountDAO;
import hrs.server.Service.Interface.PromotionService.HotelDiscountService;
import hrs.server.util.SpringUtils;

/**
 * 
 * @ClassName: HotelDiscountServiceImpl
 * @Description:
 * @author NewSong
 * @date 2016年11月19日 下午9:50:28
 *
 */
@Service
public class HotelDiscountServiceImpl implements HotelDiscountService {
	@Autowired
	private HotelDiscountDAO dao;

	/**
	 * 
	 * @Title: add
	 * @Description: 添加酒店优惠策略
	 * @param vo
	 * @see hrs.server.Service.Interface.PromotionService.HotelDiscountService#add(hrs.common.VO.HotelDiscountVO)
	 */
	@Transactional
	@Override
	public void add(HotelDiscountVO vo) {
		try {
			if (vo.beginTime != null && vo.endTime != null) {
				vo.beginTime = DateHelper.parse(DateHelper.format(vo.beginTime));
				vo.endTime = DateHelper.parse(DateHelper.format(vo.endTime));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dao.add(new HotelDiscountPO(vo));
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 更新酒店优惠策略
	 * @param vo
	 * @see hrs.server.Service.Interface.PromotionService.HotelDiscountService#update(hrs.common.VO.HotelDiscountVO)
	 */
	@Transactional
	@Override
	public void update(HotelDiscountVO vo) {
		dao.update(new HotelDiscountPO(vo));
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除酒店优惠策略
	 * @param id
	 * @see hrs.server.Service.Interface.PromotionService.HotelDiscountService#delete(int)
	 */
	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	/**
	 * 
	 * @Title: findAllByHotelID
	 * @Description: 根据酒店id找到该酒店的所有优惠策略
	 * @param hotelID
	 * @return
	 * @throws HotelDiscountNotFoundException
	 * @see hrs.server.Service.Interface.PromotionService.HotelDiscountService#findAllByHotelID(int)
	 */
	@Transactional
	@Override
	public List<HotelDiscountVO> findAllByHotelID(int hotelID) throws HotelDiscountNotFoundException {
		List<HotelDiscountPO> pos = dao.findAllByHotelID(hotelID);
		if (pos.size() == 0) {
			throw new HotelDiscountNotFoundException();
		} else {
			return transfer(pos);
		}
	}
	
	/**
	 * 
	 * @Title: createAllStrategies
	 * @Description: 创建对应酒店的优惠策略的领域类
	 * @param hotelID
	 * @return
	 * @see hrs.server.Service.Interface.PromotionService.HotelDiscountService#createAllStrategies(int)
	 */
	@Transactional
	@Override
	public List<HotelDiscount> createAllStrategies(int hotelID) {
		List<HotelDiscountVO> vos;
		try {
			vos = findAllByHotelID(hotelID);
		} catch (HotelDiscountNotFoundException e1) {
			return new ArrayList<>();
		}
		List<HotelDiscount> strategies = new ArrayList<>();
		HotelDiscount strategy = null;
		for (HotelDiscountVO vo : vos) {
			strategy = SpringUtils.getBean(vo.type.toString() + "HotelDiscount");
			strategy.setHotelDiscount(vo);
			strategies.add(strategy);
		}
		return strategies;
	}
	
	@Transactional
	@Override
	public List<HotelDiscountVO> findByHotelIDAndType(int hotelID, HotelDiscountType type) {
		List<HotelDiscountPO> pos = dao.findByHotelIDAndType(hotelID, type);
		return transfer(pos);
	}
	
	
	private List<HotelDiscountVO> transfer(List<HotelDiscountPO> pos){
		List<HotelDiscountVO> vos = new ArrayList<>();
		HotelDiscountVO vo = null;
		for (HotelDiscountPO po : pos) {
			vo = new HotelDiscountVO(po);
			vos.add(vo);
		}
		return vos;
	}

}
