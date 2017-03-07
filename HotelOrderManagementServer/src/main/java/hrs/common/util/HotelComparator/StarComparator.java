package hrs.common.util.HotelComparator;

import org.springframework.stereotype.Component;

import hrs.common.VO.HotelVO;
/**
 * 
* @ClassName: StarComparator
* @Description: 星级比较器
* @author NewSong
* @date 2016年11月19日 下午10:07:19
*
 */
@Component("StarComparator")
public class StarComparator extends HotelComparator {

	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -4933039628707891648L;

	@Override
	public int compare(HotelVO o1, HotelVO o2) {
		/**
		 * 在TreeMap中是根据传入的比较器来判断key是否唯一的
		 * 但是如果想存在重复元素不被取代掉，就需要自己加一点判断，key重复以原顺序输出
		 */
		if(o1.star == o2.star){
			return 1;
		}
		if (super.isDecrease) {
			return o2.star - o1.star;
		} else {
			return o1.star - o2.star;
		}
	}

}