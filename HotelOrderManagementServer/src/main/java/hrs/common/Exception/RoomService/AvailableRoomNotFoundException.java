package hrs.common.Exception.RoomService;

/**
 * 当public List<RoomVO> findAvailableByHotelID(int hotelID, Date begin, Date end)
 * 方法没有记录时抛出此异常
 * @author NewSong
 *
 */
public class AvailableRoomNotFoundException extends Exception{

	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 2057335133852165439L;

}
