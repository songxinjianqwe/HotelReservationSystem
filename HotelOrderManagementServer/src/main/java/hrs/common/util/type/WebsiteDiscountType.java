package hrs.common.util.type;

public enum WebsiteDiscountType {
	SpecialPeriod,SpecialCommercialCircle,VIP;
	public static WebsiteDiscountType getWebsiteDiscountType(String type){
		switch(type){
		case "SpecialPeriod":
			return SpecialPeriod;
		case "SpecialCommercialCircle":
			return SpecialCommercialCircle;
		case "VIP":
			return VIP;
		default:
			return null;
		}
	}
	public static String toDiscountName(WebsiteDiscountType type){
		switch(type){
		case SpecialPeriod:
			return "特定期间优惠";
		case SpecialCommercialCircle:
			return "特定商圈优惠";
		case VIP:
			return "会员等级优惠";
		default:
			return null;
		}
	}
}
