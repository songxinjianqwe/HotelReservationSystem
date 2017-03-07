package hrs.common.util.type;

public enum OrderStatus {
	Unexecuted, Executed, UserRevoked, Abnormal,RevokedHalfValue,RevokedFullValue;
	public static OrderStatus getOrderStatus(String status) {
		switch (status) {
		case "Unexecuted":
			return Unexecuted;
		case "Executed":
			return Executed;
		case "UserRevoked":
			return UserRevoked;
		case "Abnormal":
			return Abnormal;
		case "RevokedHalfValue":
			return RevokedHalfValue;
		case "RevokedFullValue":
			return RevokedFullValue;
		default:
			return null;
		}
	}
}
