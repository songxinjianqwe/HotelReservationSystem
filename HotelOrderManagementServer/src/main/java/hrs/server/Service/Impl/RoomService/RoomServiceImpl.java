package hrs.server.Service.Impl.RoomService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.RoomService.RoomNotFoundException;
import hrs.common.POJO.RoomPO;
import hrs.common.VO.RoomVO;
import hrs.common.util.DateHelper;
import hrs.common.util.type.RoomType;
import hrs.server.DAO.Interface.RoomDAO;
import hrs.server.Service.Interface.RoomService.RoomService;
/**
 * 
* @ClassName: RoomServiceImpl
* @Description: TODO
* @author NewSong
* @date 2016年11月19日 下午9:47:41
*
 */
@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomDAO dao;

	/**
	 * 
	 * @Title: findAvailableByHotelID
	 * @Description: 查找当前酒店的各个房间类型，以及每种房间的可用数量
	 * @param hotelID
	 * @param begin
	 * @param end
	 * @return  
	 * @see hrs.server.Service.Interface.RoomService.RoomService#findAvailableByHotelID(int, java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public List<RoomVO> findAvailableByHotelID(int hotelID, Date begin, Date end) {
		List<RoomPO> pos = dao.findByHotelID(hotelID);
		if(pos.size() == 0){
			return null;
		}
		List<RoomVO> vos = new ArrayList<>();
		RoomVO vo = null;
		int availableRoomNum = 0;
		for (RoomPO po : pos) {
			availableRoomNum = findAvailableRoomNum(hotelID, po.getType(), begin, end);
//			System.out.println("DEBUG:availableRoomNum:"+availableRoomNum);
			if (availableRoomNum <= 0) {
				continue;
			} else {
				vo = new RoomVO(po);
				vo.availableRoomNum = availableRoomNum;
				//设置房间的可用房间数量
				vos.add(vo);
			}
		}
		if (vos.size() == 0) {
			return null;
		}
		return vos;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 更新酒店信息
	 * @param roomvo  
	 * @see hrs.server.Service.Interface.RoomService.RoomService#update(hrs.common.VO.RoomVO)
	 */
	@Transactional
	@Override
	public void update(RoomVO roomvo) {
		dao.update(new RoomPO(roomvo));
	}
	
	/**
	 * 添加酒店
	 * @Title: add
	 * @Description: TODO
	 * @param roomvo  
	 * @see hrs.server.Service.Interface.RoomService.RoomService#add(hrs.common.VO.RoomVO)
	 */
	@Transactional
	@Override
	public void add(RoomVO roomvo) {
		dao.add(new RoomPO(roomvo));
	}

	/**
	 * 
	 * @Title: findNotAddedRoomType
	 * @Description: 找到该酒店没有添加过的房间类型
	 * @param hotelID
	 * @return  
	 * @see hrs.server.Service.Interface.RoomService.RoomService#findNotAddedRoomType(int)
	 */
	@Transactional
	@Override
	public List<RoomType> findNotAddedRoomType(int hotelID) {
		List<RoomType> list = new ArrayList<>();
		RoomType[] types = RoomType.values();
		for (int i = 0; i != types.length; i++) {
			list.add(types[i]);
		}
		List<RoomPO> pos = dao.findByHotelID(hotelID);
		for (RoomPO po : pos) {
			list.remove(po.getType());
		}
		return list;
	}

	/**
	 * 
	 * @Title: findAvailableRoomNum
	 * @Description: 找到在begin和end时间段中该类型该酒店的可用房间的最小数量 注意begin开始那天计入，end那天不计入
	 * @param hotelID
	 * @param type
	 * @param begin
	 * @param end
	 * @return  
	 * @see hrs.server.Service.Interface.RoomService.RoomService#findAvailableRoomNum(int, hrs.common.util.type.RoomType, java.util.Date, java.util.Date)
	 */
	@Transactional
	@Override
	public int findAvailableRoomNum(int hotelID, RoomType type, Date begin, Date end) {
		begin = DateHelper.setHMSZero(begin);
		end = DateHelper.setHMSZero(end);
		return dao.findAvailableRoomNum(hotelID, type, begin, end);
	}

	/**
	 * 
	 * @Title: findByHotelID
	 * @Description: 根据酒店id查询所有房间信息
	 * @param hotelID
	 * @return
	 * @throws RoomNotFoundException  
	 * @see hrs.server.Service.Interface.RoomService.RoomService#findByHotelID(int)
	 */
	@Transactional
	@Override
	public List<RoomVO> findByHotelID(int hotelID) throws RoomNotFoundException {
		List<RoomPO> pos = dao.findByHotelID(hotelID);
		if (pos.size() == 0) {
			throw new RoomNotFoundException();
		} else {
			return transfer(pos);
		}
	}
	/**
	 * 
	 * @Title: findByHotelAndType
	 * @Description: 根据酒店id和房间类型来查询房间信息
	 * @param hotelID
	 * @param type
	 * @return
	 * @throws RoomNotFoundException  
	 * @see hrs.server.Service.Interface.RoomService.RoomService#findByHotelAndType(int, hrs.common.util.type.RoomType)
	 */
	@Transactional
	@Override
	public RoomVO findByHotelAndType(int hotelID, RoomType type) throws RoomNotFoundException {
		RoomPO po = dao.findByHotelAndType(hotelID, type);
		if (po == null) {
			throw new RoomNotFoundException();
		} else {
			return new RoomVO(po);
		}
	}
	
	/**
	 * 
	 * @Title: transfer
	 * @Description: 将一个PO的List转为VO的List 
	 * @param List<RoomPO>
	 * @param    
	 * @return List<RoomVO>   
	 * @throws
	 */
	private List<RoomVO> transfer(List<RoomPO> pos) {
		List<RoomVO> vos = new ArrayList<>();
		RoomVO vo = null;
		for (RoomPO po : pos) {
			vo = new RoomVO(po);
			vos.add(vo);
		}
		return vos;
	}
}
