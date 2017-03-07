package hrs.common.VO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import hrs.common.POJO.HotelPO;
import hrs.common.util.type.OrderStatus;

public class HotelVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String name;
	public int star;
	public double score;
	public LocationVO location;
	public CommercialCircleVO commercialCircle;
	public String profile;
	public String service;
	public StaffVO staff;
	public String street;
	public int remarkNum;
	public double lowValue;
	public double highValue;
	public boolean hasOrdered;

	public HotelVO() {
		// TODO Auto-generated constructor stub
	}

	public HotelVO(HotelPO po, StaffVO staff) {
		this.id = po.getId();
		this.name = po.getName();
		this.star = po.getStar();
		this.score = po.getScore();
		this.location = (po.getLocation() != null) ? new LocationVO(po.getLocation()) : null;
		this.commercialCircle = (po.getCommercialCircle() != null) ? new CommercialCircleVO(po.getCommercialCircle())
				: null;
		this.profile = po.getProfile();
		this.staff = staff;
		this.service = po.getService();
		this.street = po.getStreet();
		this.remarkNum = po.getRemarkNum();
	}

	public HotelVO(HotelPO po) {
		this.id = po.getId();
		this.name = po.getName();
		this.star = po.getStar();
		this.score = po.getScore();
		this.location = po.getLocation() != null ? new LocationVO(po.getLocation()) : null;
		this.commercialCircle = po.getCommercialCircle() != null ? new CommercialCircleVO(po.getCommercialCircle())
				: null;
		this.staff = po.getStaff() != null ? new StaffVO(po.getStaff()) : null;
		this.profile = po.getProfile();
		this.service = po.getService();
		this.street = po.getStreet();
		this.remarkNum = po.getRemarkNum();
	}

	public HotelVO(String name, int star, double score, LocationVO location, CommercialCircleVO commercialCircle,
			String profile, String service, String street, int remarkNum) {
		super();
		this.name = name;
		this.star = star;
		this.score = score;
		this.location = location;
		this.commercialCircle = commercialCircle;
		this.profile = profile;
		this.service = service;
		this.street = street;
		this.remarkNum = remarkNum;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commercialCircle == null) ? 0 : commercialCircle.hashCode());
		result = prime * result + (hasOrdered ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(highValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		temp = Double.doubleToLongBits(lowValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + remarkNum;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((staff == null) ? 0 : staff.hashCode());
		result = prime * result + star;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		HotelVO other = (HotelVO) obj;
		if (commercialCircle == null) {
			if (other.commercialCircle != null)
				return false;
		} else if (!commercialCircle.equals(other.commercialCircle))
			return false;
		if (hasOrdered != other.hasOrdered)
			return false;
		if (Double.doubleToLongBits(highValue) != Double.doubleToLongBits(other.highValue))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (Double.doubleToLongBits(lowValue) != Double.doubleToLongBits(other.lowValue))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (remarkNum != other.remarkNum)
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (staff == null) {
			if (other.staff != null)
				return false;
		} else if (!staff.equals(other.staff))
			return false;
		if (star != other.star)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HotelVO [id=" + id + ", name=" + name + ", star=" + star + ", score=" + score + ", location=" + location
				+ ", commercialCircle=" + commercialCircle + ", profile=" + profile + ", service=" + service
				+ ", street=" + street + ", remarkNum=" + remarkNum + ", lowValue=" + lowValue + ", highValue="
				+ highValue + "]";
	}

}
