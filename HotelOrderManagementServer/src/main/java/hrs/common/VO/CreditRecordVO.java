package hrs.common.VO;

import java.io.Serializable;
import java.util.Date;

import hrs.common.POJO.CreditRecordPO;
import hrs.common.util.type.CreditRecordType;

public class CreditRecordVO implements Serializable,Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public OrderVO order;
	public UserVO user;
	public CreditRecordType type;
	public double variation;
	public double currCredit;
	public Date date;
	
	public CreditRecordVO() {
		// TODO Auto-generated constructor stub
	}
	
	public CreditRecordVO(CreditRecordPO po){
		this.id = po.getId();
		this.order = po.getOrder() != null ? new OrderVO(po.getOrder()):null;
		this.user = po.getUser() != null ? new UserVO(po.getUser()):null;
		this.type = po.getType();
		this.variation = po.getVariation();
		this.currCredit = po.getCurrCredit();
		this.date = po.getDate();
	}
	
	
	public CreditRecordVO(OrderVO order, UserVO user, CreditRecordType type, double variation) {
		super();
		this.order = order;
		this.user = user;
		this.type = type;
		this.variation = variation;
	}

	@Override
	public String toString() {
		return "CreditRecordVO [id=" + id + ", order=" + order + ", user=" + user + ", type=" + type + ", variation="
				+ variation + ", currCredit=" + currCredit + ", date=" + date + "]";
	}

	
	

	
}
