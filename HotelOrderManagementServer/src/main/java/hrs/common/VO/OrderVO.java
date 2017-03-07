package hrs.common.VO;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import hrs.common.POJO.OrderPO;
import hrs.common.util.type.OrderStatus;
import hrs.common.util.type.RoomType;

public class OrderVO implements Serializable,Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public Date placeTime;
	public Date execTime;
	public Date checkinTime;
	public Date expectedCheckoutTime;
	public Date checkoutTime;
	public Date revokeTime;
	public OrderStatus status;
	public HotelVO hotel;
	public double value;
	public RoomType type;
	public int roomNum = 1;
	public boolean hasChild;
	public UserVO user;
	public int score;
	public String evaluation;
	public int peopleNum;
	
	/**
	 * Double是减的金额，可以叠加
	 * value是打折之后的最终价格
	 */
	public Map<HotelDiscountVO,Double> hotelDiscounts = new HashMap<>();
	public Map<WebDiscountVO,Double> webDiscounts = new HashMap<>();
	
	
	public OrderVO() {
		
	}
	
	public OrderVO(OrderPO po){
		this.id = po.getId();
		this.placeTime = po.getPlaceTime();
		this.execTime = po.getExecTime();
		this.checkinTime = po.getCheckinTime();
		this.checkoutTime = po.getCheckoutTime();
		this.expectedCheckoutTime = po.getExpectedCheckoutTime();
		this.revokeTime = po.getRevokeTime();
		this.status = po.getStatus();
		this.hotel = po.getHotel() != null ? new HotelVO(po.getHotel()):null;
		this.value = po.getValue();
		this.type = po.getType();
		this.roomNum = po.getNum();
		this.hasChild = po.isHasChild();
		this.user = po.getUser() != null ? new UserVO(po.getUser()):null;
		this.score = po.getScore();
		this.evaluation = po.getEvaluation();
		this.peopleNum = po.getPeopleNum();
	}
	
	public OrderVO(Date placeTime, Date execTime, Date checkinTime, Date expectedCheckoutTime,
			Date checkoutTime, Date revokeTime, OrderStatus status, HotelVO hotel, double value, RoomType type,
			int roomNum, boolean hasChild, UserVO user, int score, String evaluation, int peopleNum) {
		super();
		this.placeTime = placeTime;
		this.execTime = execTime;
		this.checkinTime = checkinTime;
		this.expectedCheckoutTime = expectedCheckoutTime;
		this.checkoutTime = checkoutTime;
		this.revokeTime = revokeTime;
		this.status = status;
		this.hotel = hotel;
		this.value = value;
		this.type = type;
		this.roomNum = roomNum;
		this.hasChild = hasChild;
		this.user = user;
		this.score = score;
		this.evaluation = evaluation;
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
		result = prime * result + ((hotelDiscounts == null) ? 0 : hotelDiscounts.hashCode());
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
		result = prime * result + ((webDiscounts == null) ? 0 : webDiscounts.hashCode());
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
		OrderVO other = (OrderVO) obj;
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
		if (hotelDiscounts == null) {
			if (other.hotelDiscounts != null)
				return false;
		} else if (!hotelDiscounts.equals(other.hotelDiscounts))
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
		if (webDiscounts == null) {
			if (other.webDiscounts != null)
				return false;
		} else if (!webDiscounts.equals(other.webDiscounts))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderVO [id=" + id + ", placeTime=" + placeTime + ", execTime=" + execTime + ", checkinTime="
				+ checkinTime + ", expectedCheckoutTime=" + expectedCheckoutTime + ", checkoutTime=" + checkoutTime
				+ ", revokeTime=" + revokeTime + ", status=" + status + ", hotel=" + hotel + ", value=" + value
				+ ", type=" + type + ", roomNum=" + roomNum + ", hasChild=" + hasChild + ", user=" + user + ", score="
				+ score + ", evaluation=" + evaluation + ", peopleNum=" + peopleNum + ", hotelDiscounts="
				+ hotelDiscounts + ", webDiscounts=" + webDiscounts + "]";
	}
	
}
