package hrs.server.Service.Impl.HotelService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.POJO.LocationPO;
import hrs.common.VO.LocationVO;
import hrs.server.DAO.Interface.HotelDAO.LocationDAO;
import hrs.server.Service.Interface.HotelService.LocationService;
/**
 * 
* @ClassName: LocationServiceImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午10:02:51
*
 */
@Service
public class LocationServiceImpl implements LocationService{
	@Autowired
	private LocationDAO dao;
	
	/**
	 * 
	 * @Title: findAll
	 * @Description: 查找所有城市
	 * @return  
	 * @see hrs.server.Service.Interface.HotelService.LocationService#findAll()
	 */
	@Transactional
	@Override
	public List<LocationVO> findAll() {
		List<LocationPO> pos = dao.findAll();
		List<LocationVO> vos = new ArrayList<>();
		LocationVO vo = null;
		for(LocationPO po: pos){
			vo = new LocationVO(po);
			vos.add(vo);
		}
		return vos;
	}

}
