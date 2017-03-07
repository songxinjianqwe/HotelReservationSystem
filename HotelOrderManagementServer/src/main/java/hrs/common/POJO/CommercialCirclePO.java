package hrs.common.POJO;

import java.io.Serializable;

import hrs.common.VO.CommercialCircleVO;

public class CommercialCirclePO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private LocationPO location;
	private String name;

	public CommercialCirclePO(int id, LocationPO loc, String name) {
		super();
		this.id = id;
		this.location = loc;
		this.name = name;
	}
	
	public CommercialCirclePO(CommercialCircleVO vo){
		this.id = vo.id;
		this.location = vo.location != null ? new LocationPO(vo.location):null;
		this.name = vo.name;
	}
	
	public CommercialCirclePO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocationPO getLocation() {
		return location;
	}

	public void setLocation(LocationPO location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		CommercialCirclePO other = (CommercialCirclePO) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "CommercialCirclePO [id=" + id + ", location=" + location + ", name=" + name + "]";
	}
	
	
}
