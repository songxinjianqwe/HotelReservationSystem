package hrs.common.util.FilterCondition;

import hrs.common.util.type.FilterType;

public class NameFilterCondition extends FilterCondition {
	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 4094212130198438205L;
	private String hotelName;
	public NameFilterCondition(FilterType type) {
		super(type);
	}


	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
}
