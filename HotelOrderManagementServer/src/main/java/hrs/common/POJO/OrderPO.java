package hrs.common.POJO;

import java.io.Serializable;
import java.util.Date;

import hrs.common.VO.OrderVO;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RoomType;

public class OrderPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date placeTime;
	private Date execTime;	
	private Date checkinTime;
	private Date expectedCheckoutTime;
	private Date checkoutTime;
	private Date revokeTime;
	private OrderStatus status;
	private HotelPO hotel;
	private double value;
	private RoomType type;
	private int roomNum = 1;
	private boolean hasChild;
	private UserPO user;
	private int score;
	private String evaluation;
	private int peopleNum;

	public OrderPO() {
		// TODO Auto-generated constructor stub
	}

	public OrderPO(OrderVO vo){
		this.id = vo.id;
		this.placeTime = vo.placeTime;
		this.execTime = vo.execTime;
		this.checkinTime = vo.checkinTime;
		this.expectedCheckoutTime = vo.expectedCheckoutTime;
		this.checkoutTime = vo.checkoutTime;
		this.revokeTime  = vo.revokeTime;
		this.status = vo.status;
		this.hotel = vo.hotel != null ? new HotelPO(vo.hotel):null;
		this.value = vo.value;
		this.type = vo.type;
		this.roomNum = vo.roomNum;
		this.hasChild = vo.hasChild;
		this.user = vo.user != null ? new UserPO(vo.user):null;
		this.score  = vo.score;
		this.evaluation = vo.evaluation;
		this.peopleNum = vo.peopleNum;
	}
	

	public OrderPO(Date placeTime, Date execTime, Date expectedCheckoutTime,
			OrderStatus status, HotelPO hotel, double value, RoomType type, int num,
			boolean hasChild, UserPO user) {
		super();
		this.placeTime = placeTime;
		this.execTime = execTime;
		this.expectedCheckoutTime = expectedCheckoutTime;
		this.status = status;
		this.hotel = hotel;
		this.value = value;
		this.type = type;
		this.roomNum = num;
		this.hasChild = hasChild;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPlaceTime() {
		return placeTime;
	}

	public void setPlaceTime(Date placeTime) {
		this.placeTime = placeTime;
	}

	public Date getExecTime() {
		return execTime;
	}

	public void setExecTime(Date execTime) {
		this.execTime = execTime;
	}

	public Date getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
	}

	public Date getExpectedCheckoutTime() {
		return expectedCheckoutTime;
	}

	public void setExpectedCheckoutTime(Date expectedCheckoutTime) {
		this.expectedCheckoutTime = expectedCheckoutTime;
	}

	public Date getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public Date getRevokeTime() {
		return revokeTime;
	}

	public void setRevokeTime(Date revokeTime) {
		this.revokeTime = revokeTime;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public HotelPO getHotel() {
		return hotel;
	}

	public void setHotel(HotelPO hotel) {
		this.hotel = hotel;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public int getNum() {
		return roomNum;
	}

	public void setNum(int num) {
		this.roomNum = num;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public UserPO getUser() {
		return user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public int getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkinTime == null) ? 0 : checkinTime.hashCode());
		result = prime * result + ((checkoutTime == null) ? 0 : checkoutTime.hashCode());
		result = prime * result + ((evaluation == null) ? 0 : evaluation.hashCode());
		result = prime * result + ((execTime == null) ? 0 : execTime.hashCode());
		result = prime * result + ((expectedCheckoutTime == null) ? 0 : expectedCheckoutTime.hashCode());
		result = prime * result + (hasChild ? 1231 : 1237);
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + id;
		result = prime * result + peopleNum;
		result = prime * result + ((placeTime == null) ? 0 : placeTime.hashCode());
		result = prime * result + ((revokeTime == null) ? 0 : revokeTime.hashCode());
		result = prime * result + roomNum;
		result = prime * result + score;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		OrderPO other = (OrderPO) obj;
		if (checkinTime == null) {
			if (other.checkinTime != null)
				return false;
		} else if (!checkinTime.equals(other.checkinTime))
			return false;
		if (checkoutTime == null) {
			if (other.checkoutTime != null)
				return false;
		} else if (!checkoutTime.equals(other.checkoutTime))
			return false;
		if (evaluation == null) {
			if (other.evaluation != null)
				return false;
		} else if (!evaluation.equals(other.evaluation))
			return false;
		if (execTime == null) {
			if (other.execTime != null)
				return false;
		} else if (!execTime.equals(other.execTime))
			return false;
		if (expectedCheckoutTime == null) {
			if (other.expectedCheckoutTime != null)
				return false;
		} else if (!expectedCheckoutTime.equals(other.expectedCheckoutTime))
			return false;
		if (hasChild != other.hasChild)
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (id != other.id)
			return false;
		if (peopleNum != other.peopleNum)
			return false;
		if (placeTime == null) {
			if (other.placeTime != null)
				return false;
		} else if (!placeTime.equals(other.placeTime))
			return false;
		if (revokeTime == null) {
			if (other.revokeTime != null)
				return false;
		} else if (!revokeTime.equals(other.revokeTime))
			return false;
		if (roomNum != other.roomNum)
			return false;
		if (score != other.score)
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderPO [id=" + id + ", placeTime=" + placeTime + ", execTime=" + execTime + ", checkinTime="
				+ checkinTime + ", expectedCheckoutTime=" + expectedCheckoutTime + ", checkoutTime=" + checkoutTime
				+ ", revokeTime=" + revokeTime + ", status=" + status + ", hotel=" + hotel + ", value=" + value
				+ ", type=" + type + ", roomNum=" + roomNum + ", hasChild=" + hasChild + ", user=" + user + ", score="
				+ score + ", evaluation=" + evaluation + ", peopleNum=" + peopleNum + "]";
	}
	
}
