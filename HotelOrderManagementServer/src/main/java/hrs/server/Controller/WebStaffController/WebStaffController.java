package hrs.server.Controller.WebStaffController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hrs.common.Controller.WebStaffController.IWebStaffController;
import hrs.common.Exception.HotelService.HotelNotFoundException;
import hrs.common.Exception.StaffService.StaffExistedException;
import hrs.common.Exception.StaffService.StaffNotFoundExceptioon;
import hrs.common.VO.HotelVO;
import hrs.common.VO.StaffVO;
import hrs.server.Service.Interface.HotelService.HotelService;
import hrs.server.Service.Interface.StaffService.StaffService;
@Controller
public class WebStaffController implements IWebStaffController{
	@Autowired
	private StaffService staffService;
	@Autowired
	private HotelService hotelService;
	
	
	@Override
	public void addHotel(HotelVO hotelvo) {
		hotelService.add(hotelvo);
	}

	@Override
	public void updateStaff(StaffVO staffvo) {
		staffService.update(staffvo);
	}

	@Override
	public void addStaff(StaffVO staffvo) throws StaffExistedException {
		staffService.add(staffvo);
	}

	@Override
	public StaffVO findStaffByUsername(String username) throws StaffNotFoundExceptioon {
		return staffService.findByUsername(username);
	}

	@Override
	public List<StaffVO> findStaffByHotelName(String hotelName) throws StaffNotFoundExceptioon {
		return staffService.findByHotelName(hotelName);
	}

	@Override
	public HotelVO findHotelByHotelName(String hotelName) throws HotelNotFoundException {
		return hotelService.findByName(hotelName);
	}
	
}
