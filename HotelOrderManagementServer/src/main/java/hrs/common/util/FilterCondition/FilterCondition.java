package hrs.common.util.FilterCondition;

import java.io.Serializable;

import hrs.common.util.type.FilterType;

public abstract class FilterCondition implements Serializable{
	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -3019869854457349347L;
	private FilterType type;
	public FilterType getType() {
		return type;
	}
	public void setType(FilterType type) {
		this.type = type;
	}
	public FilterCondition(FilterType type) {
		this.type = type;
	}
}
