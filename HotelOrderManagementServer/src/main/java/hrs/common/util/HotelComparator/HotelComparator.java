package hrs.common.util.HotelComparator;

import java.io.Serializable;
import java.util.Comparator;

import hrs.common.VO.HotelVO;
/**
 * 
* @ClassName: HotelComparator
* @Description: 酒店比较器的共同基类
* @author NewSong
* @date 2016年11月19日 下午10:06:44
*
 */
public abstract class HotelComparator implements Comparator<HotelVO>,Serializable {
	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -3413713230819383873L;
	/**
	 * 升序or降序
	 */
	protected boolean isDecrease;

	public void setDecrease(boolean isDecrease) {
		this.isDecrease = isDecrease;
}
}
