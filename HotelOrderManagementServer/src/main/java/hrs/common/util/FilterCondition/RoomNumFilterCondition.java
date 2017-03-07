package hrs.common.util.FilterCondition;

import hrs.common.util.type.FilterType;

public class RoomNumFilterCondition extends FilterCondition {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 6964333028308749490L;

	private int roomNum;
	public RoomNumFilterCondition(FilterType type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

}
