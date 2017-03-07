package hrs.server.Service.Impl.HotelService.HotelFilter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
/**
 * 
* @ClassName: HotelIfOrderedFilter
* @Description: 按是否用户曾经预定过进行过滤
* @author NewSong
* @date 2016年11月19日 下午10:05:33
*
 */

@Component("IfOrderedFilter")
public class HotelIfOrderedFilter extends HotelFilter{
	
 	@Override
	public void doFilter(Map<HotelVO, List<RoomVO>> hotels) {
 		Iterator<HotelVO> it = hotels.keySet().iterator();
		HotelVO vo = null;
 		while(it.hasNext()){
 			vo = it.next();
 			if(!vo.hasOrdered){
 				it.remove();
 			}
 		}
	}

}
