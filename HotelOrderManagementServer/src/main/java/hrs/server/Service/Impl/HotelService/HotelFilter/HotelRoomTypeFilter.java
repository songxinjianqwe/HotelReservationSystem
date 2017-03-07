package hrs.server.Service.Impl.HotelService.HotelFilter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.RoomTypeFilterCondition;
/**
 * 
* @ClassName: HotelRoomTypeFilter
* @Description: 按房间类型进行过滤
* @author NewSong
* @date 2016年11月19日 下午10:06:04
*
 */
@Component("RoomTypeFilter")
public class HotelRoomTypeFilter extends HotelFilter {

	@Override
	public void doFilter(Map<HotelVO, List<RoomVO>> hotels) {
		RoomTypeFilterCondition condition = (RoomTypeFilterCondition) super.condition;
		Iterator<HotelVO> hotelIt = hotels.keySet().iterator();
		Iterator<RoomVO> roomIt = null;
		List<RoomVO> rooms = null;
		HotelVO hotel = null;
		RoomVO room = null;
		while (hotelIt.hasNext()) {
			hotel = hotelIt.next();
			rooms = hotels.get(hotel);
			roomIt = rooms.iterator();
			while (roomIt.hasNext()) {
				room = roomIt.next();
				if (room.type != condition.getRoomType()) {
					roomIt.remove();
					if(rooms.size() == 0){
						hotelIt.remove();
					}
				}
			}
		}
	}

}
