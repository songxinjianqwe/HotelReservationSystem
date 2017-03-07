package hrs.common.util.type;

/*
	单人房（Single）----供一人住的客房。可能有一张床或不止一张床。 
	双人房（Double）----供二人住的客房。可能有一张床或不止一张床。 
	大床间 King Size & Queen Size Room
	标准间 Standard
	套间 Suite
	豪华间 Deluxe Room
	商务标间 Business Room
	行政标间 Executive Room
*/
public enum RoomType {
	Single, Double, KingSize, Standard, Deluxe, Business, Executive;
	public static RoomType getRoomType(String type) {
		switch (type) {
		case "单人房":
			return Single;
		case "双人房":
			return Double;
		case "大床间":
			return KingSize;
		case "标准房":
			return Standard;
		case "豪华房":
			return Deluxe;
		case "商务标间":
			return Business;
		case "行政标间":
			return Executive;
		default:
			return null;
		}
	}
	
	public static String toRoomName(RoomType type) {
		switch (type) {
		case Single:
			return "单人房";
		case Double:
			return "双人房";
		case KingSize:
			return "大床间";
		case Standard:
			return "标准房";
		case Deluxe:
			return "豪华房";
		case Business:
			return "商务标间";
		case Executive:
			return "行政标间";
		default:
			return null;
		}
	}
}
