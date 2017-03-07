package hrs.common.util.FilterCondition;

import hrs.common.util.type.FilterType;

public class ScoreFilterCondition extends FilterCondition {
	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -7471163564035572054L;

	private double low;

	private double high;

	public ScoreFilterCondition(FilterType type) {
		super(type);
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}
}
