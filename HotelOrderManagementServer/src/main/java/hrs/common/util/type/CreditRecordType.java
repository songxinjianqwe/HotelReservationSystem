package hrs.common.util.type;

public enum CreditRecordType {
	Execute, Overtime, Recharge,Revoke;
	public static CreditRecordType getCreditRecordType(String type) {
		switch (type) {
		case "Execute":
			return Execute;
		case "Overtime":
			return Overtime;
		case "Recharge":
			return Recharge;
		case "Revoke":
			return Revoke;
		default:
			return null;
		}
	}
}
