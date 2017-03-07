package hrs.common.VO;

import java.io.Serializable;
import java.util.Date;

import hrs.common.POJO.UserPO;
import hrs.common.util.DesUtil;
import hrs.common.util.type.UserType;

public class UserVO implements Serializable ,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String username;
	public String password;
	public String phone;
	public String name;
	public double credit;
	public Date birthDate;
	public String enterprise;
	public int VIPLevel;
	public UserType type;
	private DesUtil util;
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * PO转VO时要解密
	 * @param po
	 */
	public UserVO(UserPO po){
		this.util = DesUtil.getInstance();
		this.id = po.getId();
		this.username = util.decode(po.getUsername());
		this.password = util.decode(po.getPassword());
		this.phone = util.decode(po.getPhone());
		this.name = util.decode(po.getName());
		this.credit = po.getCredit();
		this.birthDate = po.getBirthDate();
		this.enterprise = po.getEnterprise();
		this.VIPLevel = po.getVIPLevel();
		this.type = po.getType();
	}
	
	public UserVO(String username, String password,String phone,String name) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.name = name;
	}

	public UserVO(String username, String password, String phone, String name, int credit, int vIPLevel,
			UserType type,String enterprise) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.name = name;
		this.credit = credit;
		this.VIPLevel = vIPLevel;
		this.type = type;
		this.enterprise = enterprise;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + VIPLevel;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(credit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((enterprise == null) ? 0 : enterprise.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserVO other = (UserVO) obj;
		if (VIPLevel != other.VIPLevel)
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (Double.doubleToLongBits(credit) != Double.doubleToLongBits(other.credit))
			return false;
		if (enterprise == null) {
			if (other.enterprise != null)
				return false;
		} else if (!enterprise.equals(other.enterprise))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (type != other.type)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", name="
				+ name + ", credit=" + credit + ", birthDate=" + birthDate + ", enterprise=" + enterprise
				+ ", VIPLevel=" + VIPLevel + ", type=" + type + "]";
	}
	

}
