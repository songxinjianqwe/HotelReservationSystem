package hrs.common.POJO;

import java.io.Serializable;
import java.util.Date;

import hrs.common.VO.UserVO;
import hrs.common.util.DesUtil;
import hrs.common.util.type.UserType;

public class UserPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String phone;
	private String name;
	private double credit;
	private Date birthDate;
	private String enterprise;
	private int VIPLevel;
	private UserType type;
	private DesUtil util;
	public UserPO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * VO转PO时要加密
	 * 
	 * @param vo
	 */
	public UserPO(UserVO vo) {
		this.util = DesUtil.getInstance();
		this.id = vo.id;
		this.username = util.encode(vo.username);
		this.password = util.encode(vo.password);
		this.phone = util.encode(vo.phone);
		this.name = util.encode(vo.name);
		this.credit = vo.credit;
		this.birthDate = vo.birthDate;
		this.enterprise = vo.enterprise;
		this.VIPLevel = vo.VIPLevel;
		this.type = vo.type;
	}

	public UserPO(String username, String password, String phone, String name, int credit, int vIPLevel,
			UserType type) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.name = name;
		this.credit = credit;
		this.VIPLevel = vIPLevel;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public int getVIPLevel() {
		return VIPLevel;
	}

	public void setVIPLevel(int vIPLevel) {
		VIPLevel = vIPLevel;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
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
		UserPO other = (UserPO) obj;
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
		return "UserPO [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", name="
				+ name + ", credit=" + credit + ", birthDate=" + birthDate + ", enterprise=" + enterprise
				+ ", VIPLevel=" + VIPLevel + ", type=" + type + "]";
	}

}
