package hrs.server.Service.Impl.HotelService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.Exception.OrderService.OrderNotFoundException;
import hrs.common.POJO.HotelPO;
import hrs.common.VO.HotelVO;
import hrs.common.VO.OrderVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.FilterCondition;
import hrs.common.util.HotelComparator.HotelComparator;
import hrs.common.util.type.OrderRule;
import hrs.server.DAO.Interface.HotelDAO.HotelDAO;
import hrs.server.Service.Impl.HotelService.HotelFilter.HotelFilter;
import hrs.server.Service.Interface.HotelService.HotelService;
import hrs.server.Service.Interface.OrderService.OrderSearchService;
import hrs.server.Service.Interface.RoomService.RoomService;
import hrs.server.util.SpringUtils;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDAO dao;
	@Autowired
	private RoomService roomService;
	@Autowired
	private OrderSearchService orderSearchService;
	
	/**
	 * 
	 * @Title: findByID
	 * @Description: TODO
	 * @param hotelID
	 * @return
	 * @throws HotelNotFoundException  
	 * @see hrs.server.Service.Interface.HotelService.HotelService#findByID(int)
	 */
	@Transactional
	@Override
	public HotelVO findByID(int hotelID) throws HotelNotFoundException {
		HotelPO po = dao.findByID(hotelID);
		if (po == null) {
			throw new HotelNotFoundException();
		} else {
			return new HotelVO(po);
		}
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: TODO
	 * @param hotelvo  
	 * @see hrs.server.Service.Interface.HotelService.HotelService#update(hrs.common.VO.HotelVO)
	 */
	@Transactional
	@Override
	public void update(HotelVO hotelvo) {
		dao.update(new HotelPO(hotelvo));
	}
	/**
	 * 
	 * @Title: add
	 * @Description: TODO
	 * @param hotelvo  
	 * @see hrs.server.Service.Interface.HotelService.HotelService#add(hrs.common.VO.HotelVO)
	 */
	@Transactional
	@Override
	public void add(HotelVO hotelvo) {
		dao.add(new HotelPO(hotelvo));
	}

	/**
	 * @throws OrderNotFoundException
	 * 
	 * @Title: findOrderedHotelAndOrder @Description 查找已预订的酒店和订单列表 @param @param
	 * username @param @return @return Map<HotelVO,List<OrderVO>> @throws
	 */
	@Transactional
	@Override
	public Map<HotelVO, List<OrderVO>> findOrderedHotelAndOrder(String username) throws OrderNotFoundException {
		Map<HotelVO, List<OrderVO>> map = new HashMap<>();
		List<OrderVO> orders = orderSearchService.findByUsername(username);
		List<OrderVO> orderWithCertainHotel = null;
		for (OrderVO order : orders) {
			if (map.containsKey(order.hotel)) {
				map.get(order.hotel).add(order);
			} else {
				orderWithCertainHotel = new ArrayList<>();
				orderWithCertainHotel.add(order);
				map.put(order.hotel, orderWithCertainHotel);
			}
		}
		return map;
	}
	/**
	 * 
	 * @Title: find
	 * @Description: 按照城市、商圈、开始结束时间进行查询 
	 * @param loc
	 * @param circle
	 * @param begin
	 * @param end
	 * @param username
	 * @return
	 * @throws HotelNotFoundException  
	 * @see hrs.server.Service.Interface.HotelService.HotelService#find(int, int, java.util.Date, java.util.Date, java.lang.String)
	 */
	@Transactional
	@Override
	public Map<HotelVO, List<RoomVO>> find(int loc, int circle, Date begin, Date end, String username)
			throws HotelNotFoundException {
		List<HotelPO> pos = dao.find(loc, circle);
		if (pos.size() == 0) {
			throw new HotelNotFoundException();
		}
		Map<HotelVO, List<RoomVO>> map = new HashMap<>();
		HotelVO vo = null;
		List<RoomVO> rooms = null;

		for (HotelPO po : pos) {
			// 获得酒店所对应的房间列表
			rooms = roomService.findAvailableByHotelID(po.getId(), begin, end);
			if (rooms == null) {
				// 如果没有可用房间，那么不将该酒店加入到结果集
				System.out.println("退出当前循环");
				continue;
			}
			System.out.println("DEBUG:" + rooms.size());
			vo = new HotelVO(po);
			// 设置该酒店对应房间的价格区间
			vo.lowValue = Collections.min(rooms).roomValue;
			vo.highValue = Collections.max(rooms).roomValue;
			System.out.println(vo.lowValue);
			System.out.println(vo.highValue);
			// 获得酒店的相关订单类型的集合
			vo.hasOrdered = true;
			try{
				orderSearchService.findByHotelAndUsername(vo.id, username);
			}catch(OrderNotFoundException e){
				e.printStackTrace();
				vo.hasOrdered = false;
			}
			map.put(vo, rooms);
		}
		return map;
	}
	/**
	 * 
	 * @Title: filter
	 * @Description: 过滤
	 * @param data
	 * @param conditions
	 * @return  
	 * @see hrs.server.Service.Interface.HotelService.HotelService#filter(java.util.Map, java.util.List)
	 */
	@Transactional
	@Override
	public Map<HotelVO, List<RoomVO>> filter(Map<HotelVO, List<RoomVO>> data, List<FilterCondition> conditions) {
		Map<HotelVO, List<RoomVO>> res = new HashMap<>();
		res.putAll(data);
		HotelFilter filter = null;
		for (FilterCondition condition : conditions) {
			filter = SpringUtils.getBean(condition.getType().toString() + "Filter");
			filter.setFilterCondition(condition);
			filter.doFilter(res);
		}
		return res;
	}
	/**
	 * 
	 * @Title: order
	 * @Description: 排序
	 * @param data
	 * @param rule
	 * @param isDecrease
	 * @return  
	 * @see hrs.server.Service.Interface.HotelService.HotelService#order(java.util.Map, hrs.common.util.type.OrderRule, boolean)
	 */
	@Transactional
	@Override
	public Map<HotelVO, List<RoomVO>> order(Map<HotelVO, List<RoomVO>> data, OrderRule rule, boolean isDecrease) {
		HotelComparator comp = SpringUtils.getBean(rule.toString()+"Comparator");
		comp.setDecrease(isDecrease);
		Map<HotelVO, List<RoomVO>> res = new TreeMap<>(comp);
		res.putAll(data);
		return res;
	}
	
	
	/**
	 * 
	 * @Title: addRemark
	 * @Description: 添加评价信息
	 * @param hotel
	 * @param score  
	 * @see hrs.server.Service.Interface.HotelService.HotelService#addRemark(hrs.common.VO.HotelVO, int)
	 */
	@Transactional
	@Override
	public void addRemark(HotelVO hotel, int score) {
		hotel.score = (hotel.score * hotel.remarkNum + score) / (hotel.remarkNum + 1);
		hotel.remarkNum++;
		update(hotel);
	}

	/**
	 * 
	 * @Title: findByName
	 * @Description: 按姓名查询Hotel
	 * @param name
	 * @return HotelVO
	 * @throws HotelNotFoundException  
	 * @see hrs.server.Service.Interface.HotelService.HotelService#findByName(java.lang.String)
	 */
	@Transactional
	@Override
	public HotelVO findByName(String name) throws HotelNotFoundException {
		HotelPO po = dao.findByName(name);
		if(po == null){
			throw new HotelNotFoundException();
		}else{
			return new HotelVO(po);
		}
	}
	
}
