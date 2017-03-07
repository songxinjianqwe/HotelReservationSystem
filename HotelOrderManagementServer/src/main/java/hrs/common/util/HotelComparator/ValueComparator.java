package hrs.common.util.HotelComparator;

import org.springframework.stereotype.Component;

import hrs.common.VO.HotelVO;

/**价格比较器
 * 如果是升序，那么每个酒店对应List房间是升序，并将酒店按照所对应的List房间中最低的价格按升序排列
 * 如果是降序，那么每个酒店对应List房间是降序，并将酒店按照所对应的List房间中最高的价格按降序排列
 * 
 * @author NewSong
 *
 */

@Component("ValueComparator")
public class ValueComparator extends HotelComparator {


	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 352360742259852010L;

	@Override
	public int compare(HotelVO o1, HotelVO o2) {
		if (isDecrease) {
			return o1.highValue <= o2.highValue ? 1 : -1;
		} else {
			return o1.lowValue >= o2.lowValue ? 1 : -1;
		}
	}

}