package hrs.common.POJO;

import java.io.Serializable;
import java.util.Date;

import hrs.common.VO.CreditRecordVO;
import hrs.common.util.type.CreditRecordType;

public class CreditRecordPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private OrderPO order;
	private UserPO user;
	private CreditRecordType type;
	private double variation;
	private double currCredit;
	private Date date;
	
	public CreditRecordPO() {
		// TODO Auto-generated constructor stub
	}
	
	public CreditRecordPO(CreditRecordVO vo){
		this.id = vo.id;
		this.order = vo.order  != null ? new OrderPO(vo.order):null;
		this.user = vo.user != null ? new UserPO(vo.user):null;
		this.type = vo.type;
		this.variation = vo.variation;
		this.currCredit = vo.currCredit;
		this.date = vo.date;
	}
	
	public CreditRecordPO( OrderPO order,UserPO user, CreditRecordType type, int variation, int currCredit) {
		super();
		this.order = order;
		this.user = user;
		this.type = type;
		this.variation = variation;
		this.currCredit = currCredit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderPO getOrder() {
		return order;
	}

	public void setOrder(OrderPO order) {
		this.order = order;
	}

	public UserPO getUser() {
		return user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

	public CreditRecordType getType() {
		return type;
	}

	public void setType(CreditRecordType type) {
		this.type = type;
	}

	

	public double getVariation() {
		return variation;
	}

	public void setVariation(double variation) {
		this.variation = variation;
	}

	public double getCurrCredit() {
		return currCredit;
	}

	public void setCurrCredit(double currCredit) {
		this.currCredit = currCredit;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(currCredit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		temp = Double.doubleToLongBits(variation);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditRecordPO other = (CreditRecordPO) obj;
		if (Double.doubleToLongBits(currCredit) != Double.doubleToLongBits(other.currCredit))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (type != other.type)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (Double.doubleToLongBits(variation) != Double.doubleToLongBits(other.variation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreditRecordPO [id=" + id + ", order=" + order + ", user=" + user + ", type=" + type + ", variation="
				+ variation + ", currCredit=" + currCredit + "]";
	}
	
	
}
