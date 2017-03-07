package hrs.common.VO;

import java.io.Serializable;
import java.util.Date;

import hrs.common.POJO.WebDiscountPO;
import hrs.common.util.type.WebsiteDiscountType;

public class WebDiscountVO implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public double discount;
	public WebsiteDiscountType type;
	public LocationVO location;
	public CommercialCircleVO commercialCircle;
	public Date beginTime;
	public Date endTime;
	public int VIPlevel;

	public WebDiscountVO() {
		// TODO Auto-generated constructor stub
	}

	public WebDiscountVO(WebDiscountPO po) {
		this.id = po.getId();
		this.discount = po.getDiscount();
		this.type = po.getType();
		this.location = po.getLocation() != null ? new LocationVO(po.getLocation()) : null;
		this.commercialCircle = po.getCommercialCircle() != null ? new CommercialCircleVO(po.getCommercialCircle())
				: null;
		this.beginTime = po.getBeginTime();
		this.endTime = po.getEndTime();
		this.VIPlevel = po.getVIPlevel();
	}

	public WebDiscountVO(double discount, WebsiteDiscountType type, LocationVO location,
			CommercialCircleVO commercialCircle, Date beginTime, Date endTime, int vIPlevel) {
		super();
		this.discount = discount;
		this.type = type;
		this.location = location;
		this.commercialCircle = commercialCircle;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.VIPlevel = vIPlevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + VIPlevel;
		result = prime * result + ((beginTime == null) ? 0 : beginTime.hashCode());
		result = prime * result + ((commercialCircle == null) ? 0 : commercialCircle.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		WebDiscountVO other = (WebDiscountVO) obj;
		if (VIPlevel != other.VIPlevel)
			return false;
		if (beginTime == null) {
			if (other.beginTime != null)
				return false;
		} else if (!beginTime.equals(other.beginTime))
			return false;
		if (commercialCircle == null) {
			if (other.commercialCircle != null)
				return false;
		} else if (!commercialCircle.equals(other.commercialCircle))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WebDiscountVO [id=" + id + ", discount=" + discount + ", type=" + type + ", location=" + location
				+ ", commercialCircle=" + commercialCircle + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", VIPlevel=" + VIPlevel + "]";
	}

}
