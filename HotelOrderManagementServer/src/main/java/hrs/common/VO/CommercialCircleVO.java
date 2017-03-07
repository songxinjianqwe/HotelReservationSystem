package hrs.common.VO;

import java.io.Serializable;

import hrs.common.POJO.CommercialCirclePO;

public class CommercialCircleVO implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public LocationVO location;
	public String name;

	public CommercialCircleVO() {
	}
	
	public CommercialCircleVO(CommercialCirclePO po){
		this.id = po.getId();
		this.location = po.getLocation() != null? new LocationVO(po.getLocation()):null;
		this.name = po.getName();
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
		CommercialCircleVO other = (CommercialCircleVO) obj;
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
		return "CommercialCircleVO [id=" + id + ", location=" + location + ", name=" + name + "]";
	}
	
}
