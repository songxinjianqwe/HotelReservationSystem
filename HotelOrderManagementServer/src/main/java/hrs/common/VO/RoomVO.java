package hrs.common.VO;

import java.io.Serializable;

import hrs.common.POJO.RoomPO;
import hrs.common.util.type.RoomType;

public class RoomVO implements Serializable,Comparable<RoomVO> ,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  HotelVO hotel;
	public RoomType type;
	public int roomNum;
	public double roomValue;
	public int availableRoomNum;
	
	public RoomVO(RoomPO po){
		this.hotel = po.getHotel() != null ? new HotelVO(po.getHotel()):null;
		this.type = po.getType();
		this.roomNum = po.getRoomNum();
		this.roomValue = po.getRoomValue();
	}
	
	public RoomVO(HotelVO hotel, RoomType type, int roomNum, double roomValue) {
		super();
		this.hotel = hotel;
		this.type = type;
		this.roomNum = roomNum;
		this.roomValue = roomValue;
	}
	
	public RoomVO() {
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availableRoomNum;
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + roomNum;
		long temp;
		temp = Double.doubleToLongBits(roomValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomVO other = (RoomVO) obj;
		if (availableRoomNum != other.availableRoomNum)
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (roomNum != other.roomNum)
			return false;
		if (Double.doubleToLongBits(roomValue) != Double.doubleToLongBits(other.roomValue))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "RoomVO [hotel=" + hotel + ", type=" + type + ", roomNum=" + roomNum + ", roomValue=" + roomValue
				+ ", availableRoomNum=" + availableRoomNum + "]";
	}

	@Override
	public int compareTo(RoomVO o) {
		return (int) (roomValue-o.roomNum);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
