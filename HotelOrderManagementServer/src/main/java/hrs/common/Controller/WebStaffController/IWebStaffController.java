package hrs.common.Controller.WebStaffController;

import java.util.List;

import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.Exception.StaffService.StaffExistedException;
import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.VO.HotelVO;
import hrs.common.VO.StaffVO;

public interface IWebStaffController {
	void addHotel(HotelVO hotelvo);
	void updateStaff(StaffVO staffvo);
	void addStaff(StaffVO staffvo) throws StaffExistedException;
	StaffVO findStaffByUsername(String username) throws StaffNotFoundExceptioon;
	List<StaffVO> findStaffByHotelName(String hotelName) throws StaffNotFoundExceptioon;
	HotelVO findHotelByHotelName(String hotelName) throws HotelNotFoundException;
}
