package hrs.server.Service.Impl.StaffService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.StaffService.StaffExistedException;
import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.Exception.StaffService.StaffPasswordErrorException;
import hrs.common.POJO.StaffPO;
import hrs.common.VO.StaffVO;
import hrs.common.util.DesUtil;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.StaffDAO;
import hrs.server.Service.Interface.StaffService.StaffService;
/**
 * 
* @ClassName: StaffServiceImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午9:45:51
*
 */
@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDAO dao;
	private DesUtil util;
	/**
	 * 
	 * @Title: login
	 * @Description: 职员登录
	 * @param username
	 * @param password
	 * @return StaffVO
	 * @throws StaffNotFoundExceptioon
	 * @throws StaffPasswordErrorException  
	 * @see hrs.server.Service.Interface.StaffService.StaffService#login(java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public StaffVO login(String username, String password) throws StaffNotFoundExceptioon, StaffPasswordErrorException {
		util = DesUtil.getInstance();
		StaffPO po = dao.findByUsername(util.encode(username));
		if (po == null) {
			throw new StaffNotFoundExceptioon();
		} else if (!po.getPassword().equals(util.encode(password))) {
			throw new StaffPasswordErrorException();
		} else {
			return new StaffVO(po);
		}
	}
	/**
	 * 
	 * @Title: update
	 * @Description: 更新职员
	 * @param staffvo  
	 * @see hrs.server.Service.Interface.StaffService.StaffService#update(hrs.common.VO.StaffVO)
	 */
	@Transactional
	@Override
	public void update(StaffVO staffvo) {
		dao.update(new StaffPO(staffvo));
	}
	/**
	 * 
	 * @Title: add
	 * @Description: 添加职员
	 * @param staffvo
	 * @throws StaffExistedException  
	 * @see hrs.server.Service.Interface.StaffService.StaffService#add(hrs.common.VO.StaffVO)
	 */
	@Transactional
	@Override
	public void add(StaffVO staffvo) throws StaffExistedException {
		if (dao.add(new StaffPO(staffvo)) == ResultMessage.EXISTED) {
			throw new StaffExistedException();
		}
	}
	/**
	 * 
	 * @Title: findByUsername
	 * @Description: 按用户名查找职员
	 * @param username
	 * @return
	 * @throws StaffNotFoundExceptioon  
	 * @see hrs.server.Service.Interface.StaffService.StaffService#findByUsername(java.lang.String)
	 */
	@Transactional
	@Override
	public StaffVO findByUsername(String username) throws StaffNotFoundExceptioon {
		util = DesUtil.getInstance();
		StaffPO po = dao.findByUsername(util.encode(username));
		if (po == null) {
			throw new StaffNotFoundExceptioon();
		} else {
			return new StaffVO(po);
		}
	}
	/**
	 * 
	 * @Title: findByHotelName
	 * @Description: 按酒店名查询酒店工作人员，仅限于酒店工作人员，模糊查询
	 * @param hotelName
	 * @return
	 * @throws StaffNotFoundExceptioon  
	 * @see hrs.server.Service.Interface.StaffService.StaffService#findByHotelName(java.lang.String)
	 */
	@Transactional
	@Override
	public List<StaffVO> findByHotelName(String hotelName) throws StaffNotFoundExceptioon {
		List<StaffPO> pos = dao.findByHotelName(hotelName);
		List<StaffVO> vos = null;
		if(pos.size() == 0){
			throw new StaffNotFoundExceptioon();
		}else{
			vos = new ArrayList<>();
			StaffVO vo = null;
			for(StaffPO po :pos){
				vo = new StaffVO(po);
				vos.add(vo);
			}
		}
		return vos;
	}

}
