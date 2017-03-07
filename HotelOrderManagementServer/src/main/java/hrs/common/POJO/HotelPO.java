package hrs.common.POJO;

import java.io.Serializable;

import hrs.common.VO.HotelVO;

public class HotelPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int star;
	private double score;
	private LocationPO location;
	private CommercialCirclePO commercialCircle;
	private String profile;
	private StaffPO staff;

	private String service;
	private String street;
	private int remarkNum;

	public HotelPO() {
		// TODO Auto-generated constructor stub
	}

	public HotelPO(HotelVO vo) {
		this.id = vo.id;
		this.name = vo.name;
		this.star = vo.star;
		this.score = vo.score;
		this.location = vo.location != null ? new LocationPO(vo.location) : null;
		this.commercialCircle = vo.commercialCircle != null ? new CommercialCirclePO(vo.commercialCircle) : null;
		this.staff = vo.staff != null ? new StaffPO(vo.staff) : null;
		this.profile = vo.profile;
		this.service = vo.service;
		this.street = vo.street;
		this.remarkNum = vo.remarkNum;
	}

	public HotelPO(HotelVO vo, StaffPO staff) {
		this.id = vo.id;
		this.name = vo.name;
		this.star = vo.star;
		this.score = vo.score;
		this.location = vo.location != null ? new LocationPO(vo.location) : null;
		this.commercialCircle = vo.commercialCircle != null ? new CommercialCirclePO(vo.commercialCircle) : null;
		this.staff = staff;
		this.profile = vo.profile;
		this.service = vo.service;
		this.street = vo.street;
		this.remarkNum = vo.remarkNum;
	}

	public HotelPO(String name, int star, double score, LocationPO location, CommercialCirclePO commercialCircle,
			String profile, String service, StaffPO staff, String street, int remarkNum) {
		super();
		this.name = name;
		this.star = star;
		this.score = score;
		this.location = location;
		this.commercialCircle = commercialCircle;
		this.profile = profile;
		this.service = service;
		this.staff = staff;
		this.street = street;
		this.remarkNum = remarkNum;
	}

	public void setStaff(StaffPO staff) {
		this.staff = staff;
	}

	public StaffPO getStaff() {
		return staff;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public LocationPO getLocation() {
		return location;
	}

	public void setLocation(LocationPO location) {
		this.location = location;
	}

	public CommercialCirclePO getCommercialCircle() {
		return commercialCircle;
	}

	public void setCommercialCircle(CommercialCirclePO commercialCircle) {
		this.commercialCircle = commercialCircle;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getRemarkNum() {
		return remarkNum;
	}

	public void setRemarkNum(int remarkNum) {
		this.remarkNum = remarkNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commercialCircle == null) ? 0 : commercialCircle.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + remarkNum;
		long temp;
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
		HotelPO other = (HotelPO) obj;
		if (commercialCircle == null) {
			if (other.commercialCircle != null)
				return false;
		} else if (!commercialCircle.equals(other.commercialCircle))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
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
		return "HotelPO [id=" + id + ", name=" + name + ", star=" + star + ", score=" + score + ", location=" + location
				+ ", commercialCircle=" + commercialCircle + ", profile=" + profile + ", staff=" + staff + ", service="
				+ service + ", street=" + street + ", remarkNum=" + remarkNum + "]";
	}

}
