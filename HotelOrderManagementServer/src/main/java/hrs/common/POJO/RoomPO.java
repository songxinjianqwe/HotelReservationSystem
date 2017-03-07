package hrs.common.POJO;

import java.io.Serializable;

import hrs.common.VO.RoomVO;
import hrs.common.util.type.RoomType;

public class RoomPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HotelPO hotel;
	private RoomType type;
	private int roomNum;
	private double roomValue;
	
	public RoomPO(RoomVO vo){
		this.type  = vo.type;
		this.roomNum = vo.roomNum;
		this.roomValue  = vo.roomValue;
		this.hotel = vo.hotel != null ? new HotelPO(vo.hotel):null;
	}
	
	public RoomPO(HotelPO hotel, RoomType type, int roomNum, double roomValue) {
		super();
		this.hotel = hotel;
		this.type = type;
		this.roomNum = roomNum;
		this.roomValue = roomValue;
	}

	public RoomPO() {
		// TODO Auto-generated constructor stub
	}

	public HotelPO getHotel() {
		return hotel;
	}

	public void setHotel(HotelPO hotel) {
		this.hotel = hotel;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public double getRoomValue() {
		return roomValue;
	}

	public void setRoomValue(double roomValue) {
		this.roomValue = roomValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		RoomPO other = (RoomPO) obj;
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
		return "RoomPO [hotel=" + hotel + ", type=" + type + ", roomNum=" + roomNum + ", roomValue=" + roomValue + "]";
	}

}
