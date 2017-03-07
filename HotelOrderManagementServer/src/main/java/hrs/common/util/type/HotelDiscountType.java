package hrs.common.util.type;

public enum HotelDiscountType {
	Birthday, LargeQty, Enterprise, SpecialPeriod;
	public static HotelDiscountType getHotelDiscountType(String type) {
		switch (type) {
		case "Birthday":
			return Birthday;
		case "LargeQty":
			return LargeQty;
		case "Enterprise":
			return Enterprise;
		case "SpecialPeriod":
			return SpecialPeriod;
		default:
			return null;
		}
	}
	public static String toDiscountName(HotelDiscountType type){
		switch (type) {
		case Birthday:
			return "生日优惠";
		case LargeQty:
			return "订房数量优惠";
		case Enterprise:
			return "合作企业优惠";
		case SpecialPeriod:
			return "特定期间优惠";
		default:
			return null;
		}
	}
}
