package hrs.common.POJO;

import java.io.Serializable;

import hrs.common.VO.StaffVO;
import hrs.common.util.DesUtil;
import hrs.common.util.type.StaffType;

public class StaffPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String name;
	private StaffType type;
	private HotelPO hotel;
	private DesUtil util;
	
	public StaffPO() {
		// TODO Auto-generated constructor stub
	}
	
	public StaffPO(StaffVO vo){
		this.util = DesUtil.getInstance();
		this.id = vo.id;
		this.username = util.encode(vo.username);
		this.password = util.encode(vo.password);
		this.name = util.encode(vo.name);
		this.type = vo.type;
		this.hotel = vo.hotel != null ? new HotelPO(vo.hotel,this):null;
	}
	
	public StaffPO(String username, String password, String name, StaffType type, HotelPO hotel) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.type = type;
		this.hotel = hotel;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StaffType getType() {
		return type;
	}

	public void setType(StaffType type) {
		this.type = type;
	}

	public HotelPO getHotel() {
		return hotel;
	}

	public void setHotel(HotelPO hotel) {
		this.hotel = hotel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		StaffPO other = (StaffPO) obj;
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
		if (type != other.type)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}

