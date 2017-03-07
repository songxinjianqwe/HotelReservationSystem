package hrs.server.Service.Impl.HotelService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.CommercialCirclePO;
import hrs.common.VO.CommercialCircleVO;
import hrs.server.DAO.Interface.HotelDAO.CommCircleDAO;
import hrs.server.Service.Interface.HotelService.CommCircleService;
/**
 * 
* @ClassName: CommCircleServiceImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:03:09
*
 */
@Service
public class CommCircleServiceImpl implements CommCircleService {
	@Autowired
	private CommCircleDAO dao;
	
	/**
	 * 
	 * @Title: findByLoc
	 * @Description: 按城市id查找对应的商圈列表
	 * @param locID
	 * @return  
	 * @see hrs.server.Service.Interface.HotelService.CommCircleService#findByLoc(int)
	 */
	@Transactional
	@Override
	public List<CommercialCircleVO> findByLoc(int locID) {
		List<CommercialCirclePO> pos = dao.findByLoc(locID);
		List<CommercialCircleVO> vos = new ArrayList<>();
		CommercialCircleVO vo = null;
		for(CommercialCirclePO po:pos){
			vo = new CommercialCircleVO(po);
			vos.add(vo);
		}
		return vos;
	}
	

}
