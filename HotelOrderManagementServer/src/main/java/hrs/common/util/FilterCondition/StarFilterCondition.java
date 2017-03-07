package hrs.common.util.FilterCondition;

import hrs.common.util.type.FilterType;

public class StarFilterCondition extends FilterCondition {
	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 6079837928699161288L;
	private int star;

	public StarFilterCondition(FilterType type) {
		super(type);
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
}
