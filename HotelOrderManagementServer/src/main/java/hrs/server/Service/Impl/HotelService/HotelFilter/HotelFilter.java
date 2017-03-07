package hrs.server.Service.Impl.HotelService.HotelFilter;

import java.util.List;
import java.util.Map;

import hrs.common.VO.HotelVO;
import hrs.common.VO.RoomVO;
import hrs.common.util.FilterCondition.FilterCondition;
/**
 * 
* @ClassName: HotelFilter
* @Description: 过滤器的共同父类
* @author NewSong
* @date 2016年11月19日 下午10:05:13
*
 */
public abstract class HotelFilter {
	/**
	 * 过滤条件
	 */
	protected FilterCondition condition;
	
	public abstract void doFilter(Map<HotelVO, List<RoomVO>> hotels);

	public void setFilterCondition(FilterCondition condition) {
		this.condition = condition;
	}

}
