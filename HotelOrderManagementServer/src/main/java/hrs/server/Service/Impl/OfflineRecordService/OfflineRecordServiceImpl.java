package hrs.server.Service.Impl.OfflineRecordService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.OfflineRecordService.OfflineRecordNotFoundException;
import hrs.common.POJO.OfflineRecordPO;
import hrs.common.POJO.OrderPO;
import hrs.common.VO.OfflineRecordVO;
import hrs.common.VO.OrderVO;
import hrs.server.DAO.Interface.OfflineRecordDAO;
import hrs.server.Service.Interface.OfflineRecordService.OfflineRecordService;
/**
 * 
* @ClassName: OfflineRecordServiceImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:02:14
*
 */
@Service
public class OfflineRecordServiceImpl implements OfflineRecordService {
	@Autowired
	private OfflineRecordDAO dao;
	
	/**
	 * 
	 * @Title: findByID
	 * @Description: 按id查找线下订单
	 * @param id
	 * @return
	 * @throws OfflineRecordNotFoundException  
	 * @see hrs.server.Service.Interface.OfflineRecordService.OfflineRecordService#findByID(int)
	 */
	@Transactional	
	@Override
	public OfflineRecordVO findByID(int id) throws OfflineRecordNotFoundException {
		OfflineRecordPO po = dao.findByID(id);
		if(po == null){
			throw new OfflineRecordNotFoundException();
		}else{
			return new OfflineRecordVO(po);
		}
	}
	
	/**
	 * 
	 * @Title: checkin
	 * @Description: 入住/添加线下入住记录  vo要求已经设置了入住时间
	 * @param vo  
	 * @see hrs.server.Service.Interface.OfflineRecordService.OfflineRecordService#checkin(hrs.common.VO.OfflineRecordVO)
	 */
	@Transactional
	@Override
	public void checkin(OfflineRecordVO vo) {
		dao.add(new OfflineRecordPO(vo));
	}
	
	/**
	 * 
	 * @Title: checkout
	 * @Description: 退房，更新该订单的退房时间
	 * @param vo  
	 * @see hrs.server.Service.Interface.OfflineRecordService.OfflineRecordService#checkout(hrs.common.VO.OfflineRecordVO)
	 */
	@Transactional
	@Override
	public void checkout(OfflineRecordVO vo) {
		vo.checkoutTime = new Date();
		dao.update(new OfflineRecordPO(vo));
	}
	
	@Transactional
	@Override
	public List<OfflineRecordVO> findByHotelID(int hotelID) throws OfflineRecordNotFoundException {
		List<OfflineRecordPO> pos = dao.findByHotelID(hotelID);
		if(pos.size() == 0){
			throw new OfflineRecordNotFoundException();
		}else{
			return tranfer(pos);
		}
	}
	
	private List<OfflineRecordVO> tranfer(List<OfflineRecordPO> pos){
		List<OfflineRecordVO> vos = new ArrayList<>();
		OfflineRecordVO vo = null;
		for(OfflineRecordPO po : pos){
			vo = new OfflineRecordVO(po);
			vos.add(vo);
		}
		return vos;
	}

}
