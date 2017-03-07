package hrs.common.POJO;

import java.io.Serializable;
import java.util.Date;

import hrs.common.util.type.RoomType;

public class AvailableRoomPO implements Serializable,Comparable<AvailableRoomPO>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HotelPO hotel;
	private RoomType type;
	private int availableRoomNum;
	private Date roomDate;
	
	
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
	public int getAvailableRoomNum() {
		return availableRoomNum;
	}
	public void setAvailableRoomNum(int availableRoomNum) {
		this.availableRoomNum = availableRoomNum;
	}
	public Date getRoomDate() {
		return roomDate;
	}
	public void setRoomDate(Date roomDate) {
		this.roomDate = roomDate;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((roomDate == null) ? 0 : roomDate.hashCode());
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
		AvailableRoomPO other = (AvailableRoomPO) obj;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (roomDate == null) {
			if (other.roomDate != null)
				return false;
		} else if (!roomDate.equals(other.roomDate))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AvailableRoomPO [hotel=" + hotel + ", type=" + type + ", availableRoomNum=" + availableRoomNum
				+ ", roomDate=" + roomDate + "]";
	}
	@Override
	public int compareTo(AvailableRoomPO o) {
		return availableRoomNum-o.availableRoomNum;
	}
	
	
}
