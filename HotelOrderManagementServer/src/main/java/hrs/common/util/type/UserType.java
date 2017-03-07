package hrs.common.util.type;

public enum UserType {
	Normal, Enterprise;
	public static UserType getUserType(String type) {
		switch (type) {
		case "Normal":
			return Normal;
		case "Enterprise":
			return Enterprise;
		default:
			return null;
		}
	}
}
