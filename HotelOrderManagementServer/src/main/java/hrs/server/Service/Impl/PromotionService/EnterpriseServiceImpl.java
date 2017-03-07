package hrs.server.Service.Impl.PromotionService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.PromotionService.EnterpriseNotFoundException;
import hrs.common.POJO.EnterprisePO;
import hrs.common.VO.EnterpriseVO;
import hrs.common.VO.HotelDiscountVO;
import hrs.common.util.type.HotelDiscountType;
import hrs.server.DAO.Interface.PromotionDAO.EnterpriseDAO;
import hrs.server.Service.Interface.PromotionService.EnterpriseService;
import hrs.server.Service.Interface.PromotionService.HotelDiscountService;
/**
 * 
* @ClassName: EnterpriseServiceImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午9:50:04
*
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {
	@Autowired
	private HotelDiscountService hotelDiscountService;
	@Autowired
	private EnterpriseDAO dao;
	
	/**
	 * 
	 * @Title: getAllEnterprises
	 * @Description:返回所有企业
	 * @return
	 * @throws EnterpriseNotFoundException  
	 * @see hrs.server.Service.Interface.PromotionService.EnterpriseService#getAllEnterprises()
	 */
	@Transactional
	@Override
	public List<EnterpriseVO> findNotAddedEnterpriseByHotelID(int hotelID) throws EnterpriseNotFoundException {
		List<EnterprisePO> pos = dao.findAll();
		List<EnterpriseVO> vos = null;
		if(pos.size() == 0){
			throw new EnterpriseNotFoundException();
		}else{
			EnterpriseVO vo = null;
			vos = new ArrayList<>();
			for(EnterprisePO po:pos){
				vo = new EnterpriseVO(po);
				vos.add(vo);
			}
		}
		List<EnterpriseVO> addedEnteprise = getEnterpriseFromHotelDiscount(hotelDiscountService.findByHotelIDAndType(hotelID, HotelDiscountType.Enterprise));
		vos.removeAll(addedEnteprise);
		return vos;
	}
	/**
	 * 
	 * @Title: add
	 * @Description: 添加企业
	 * @param vo  
	 * @see hrs.server.Service.Interface.PromotionService.EnterpriseService#add(hrs.common.VO.EnterpriseVO)
	 */
	@Transactional
	@Override
	public void add(EnterpriseVO vo) {
		dao.add(new EnterprisePO(vo));
	}
	
	private List<EnterpriseVO> getEnterpriseFromHotelDiscount(List<HotelDiscountVO> list){
		List<EnterpriseVO> enterprises = new ArrayList<>();
		for(HotelDiscountVO vo:list){
			enterprises.add(vo.enterprise);
		}
		return enterprises;
	}
}
