package hrs.server.Service.Interface.StaffService;

import java.util.List;

import hrs.common.Exception.StaffService.StaffExistedException;
import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.Exception.StaffService.StaffPasswordErrorException;
import hrs.common.VO.StaffVO;

public interface StaffService {
	StaffVO login(String username, String password) throws StaffNotFoundExceptioon, StaffPasswordErrorException;
	void update(StaffVO staffvo);
	void add(StaffVO staffvo) throws StaffExistedException;
	StaffVO findByUsername(String username) throws StaffNotFoundExceptioon;
	List<StaffVO> findByHotelName(String hotelName) throws StaffNotFoundExceptioon;
	
}
