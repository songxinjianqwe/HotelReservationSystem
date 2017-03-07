package hrs.server.Service.Impl.HotelService.HotelFilter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.NameFilterCondition;
/**
 * 
* @ClassName: HotelNameFilter
* @Description: 按酒店名称进行过滤，模糊查询
* @author NewSong
* @date 2016年11月19日 下午10:05:49
*
 */
@Component("NameFilter")
public class HotelNameFilter extends HotelFilter {
	public HotelNameFilter() {

	}

	@Override
	public void doFilter(Map<HotelVO, List<RoomVO>> hotels) {
		NameFilterCondition condition = (NameFilterCondition) super.condition;
		Iterator<HotelVO> it = hotels.keySet().iterator();
		HotelVO vo = null;
		while (it.hasNext()) {
			vo = it.next();
			System.out.println(vo);
			if (!vo.name.matches(".*" + condition.getHotelName() +".*")) {
				it.remove();
			}
		}
	}
}
