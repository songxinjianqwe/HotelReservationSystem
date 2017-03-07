package hrs.common.VO;

import java.io.Serializable;

import hrs.common.POJO.EnterprisePO;

public class EnterpriseVO implements Serializable,Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String name;

	public EnterpriseVO() {

	}

	public EnterpriseVO(EnterprisePO po) {
		this.id = po.getId();
		this.name = po.getName();
	}

	public EnterpriseVO(String name) {
		super();
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
		EnterpriseVO other = (EnterpriseVO) obj;
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
		return "EnterpriseVO [id=" + id + ", name=" + name + "]";
	}

}
