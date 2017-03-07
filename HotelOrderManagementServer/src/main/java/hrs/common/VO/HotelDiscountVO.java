package hrs.common.VO;

import java.io.Serializable;
import java.util.Date;

import hrs.common.POJO.HotelDiscountPO;
import hrs.common.util.type.HotelDiscountType;

public  class HotelDiscountVO implements Serializable,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public HotelVO hotel;
	public double discount;
	public HotelDiscountType type;
	public EnterpriseVO enterprise;//合作企业
	public int minQty;//满几间房有优惠
	public Date beginTime;//特定期间优惠
	public Date endTime;
	public HotelDiscountVO() {
		// TODO Auto-generated constructor stub
	}
	public HotelDiscountVO(HotelDiscountPO po){
		this.id = po.getId();
		this.hotel = po.getHotel() != null ? new HotelVO(po.getHotel()):null;
		this.discount = po.getDiscount();
		this.type = po.getType();
		this.enterprise = po.getEnterprise() != null ?new EnterpriseVO(po.getEnterprise()):null;
		this.minQty = po.getMinQty();
		this.beginTime = po.getBeginTime();
		this.endTime = po.getEndTime();
	}
	
	public HotelDiscountVO(HotelVO hotel, double discount, HotelDiscountType type, EnterpriseVO enterprise,
			int minQty, Date beginTime, Date endTime) {
		super();
		this.hotel = hotel;
		this.discount = discount;
		this.type = type;
		this.enterprise = enterprise;
		this.minQty = minQty;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beginTime == null) ? 0 : beginTime.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((enterprise == null) ? 0 : enterprise.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + id;
		result = prime * result + minQty;
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
		HotelDiscountVO other = (HotelDiscountVO) obj;
		if (beginTime == null) {
			if (other.beginTime != null)
				return false;
		} else if (!beginTime.equals(other.beginTime))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (enterprise == null) {
			if (other.enterprise != null)
				return false;
		} else if (!enterprise.equals(other.enterprise))
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (id != other.id)
			return false;
		if (minQty != other.minQty)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	public HotelDiscountVO(int id, HotelVO hotel, double discount, HotelDiscountType type, EnterpriseVO enterprise,
			int minQty, Date beginTime, Date endTime) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.discount = discount;
		this.type = type;
		this.enterprise = enterprise;
		this.minQty = minQty;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "HotelDiscountVO [id=" + id + ", hotel=" + hotel + ", discount=" + discount + ", type=" + type
				+ ", enterprise=" + enterprise + ", minQty=" + minQty + ", beginTime=" + beginTime + ", endTime="
				+ endTime + "]";
	}
	
	
		
}
