package hrs.common.VO;

import java.io.Serializable;

import hrs.common.POJO.LocationPO;

public class LocationVO implements Serializable,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String name;
	public LocationVO() {
		// TODO Auto-generated constructor stub
	}
	
	public LocationVO(LocationPO po){
		this.id = po.getId();
		this.name = po.getName();
	}
	
	public LocationVO(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		LocationVO other = (LocationVO) obj;
		if (id != other.id)
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
		return "LocationVO [id=" + id + ", name=" + name + "]";
	}
	
}
