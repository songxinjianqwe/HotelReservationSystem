package hrs.server.Service.Impl.HotelService.HotelFilter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.ScoreFilterCondition;
/**
 * 
* @ClassName: HotelScoreFilter
* @Description: 按酒店评分区间进行过滤
* @author NewSong
* @date 2016年11月19日 下午10:06:17
*
 */
@Component("ScoreFilter")
public class HotelScoreFilter extends HotelFilter {

	@Override
	public void doFilter(Map<HotelVO, List<RoomVO>> hotels) {
		ScoreFilterCondition condition = (ScoreFilterCondition) super.condition;
		Iterator<HotelVO> it = hotels.keySet().iterator();
		HotelVO vo = null;
		while (it.hasNext()) {
			vo = it.next();
			if (vo.score < condition.getLow() || vo.score > condition.getHigh()) {
				it.remove();
			}
		}
	}
}
