package hrs.common.Exception.RoomService;

/**
 * 当public List<RoomVO> findByHotelID(int hotelID)
 * 方法返回空时抛出此异常
 * @author NewSong
 *
 */
public class RoomNotFoundException extends Exception{

	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -6089543477025846190L;

}
