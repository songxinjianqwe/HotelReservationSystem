package hrs.server.Initial;

import hrs.common.Controller.HotelController.IHotelController;
import hrs.common.Controller.HotelController.IHotelDiscountController;
import hrs.common.Controller.HotelController.IHotelOrderController;
import hrs.common.Controller.HotelController.IOfflineRecordController;
import hrs.common.Controller.HotelController.IRoomController;
import hrs.common.Controller.LoginController.ILoginController;
import hrs.common.Controller.UserController.IUserController;
import hrs.common.Controller.UserController.IUserHotelController;
import hrs.common.Controller.UserController.IUserOrderController;
import hrs.common.Controller.WebMarketController.IWebCreditController;
import hrs.common.Controller.WebMarketController.IWebDiscountController;
import hrs.common.Controller.WebMarketController.IWebOrderController;
import hrs.common.Controller.WebStaffController.IWebStaffController;
import hrs.common.Controller.WebStaffController.IWebUserController;
import hrs.server.util.SpringUtils;
/**
 * 
* @ClassName: NetInitial
* @Description: 初始化Controller
* @author NewSong
* @date 2016年11月19日 下午9:07:43
*
 */
@SuppressWarnings("all")
public class NetInitial {
	private static ILoginController loginController;
	
	private static IUserController userController;
	private static IUserHotelController userHotelController;
	private static IUserOrderController userOrderController;
	
	private static IHotelController hotelController;
	private static IHotelDiscountController hotelDiscountController;
	private static IHotelOrderController hotelOrderController;
	private static IOfflineRecordController offlineRecordController;
	private static IRoomController roomController;
	
	private static IWebCreditController webCreditController;
	private static IWebDiscountController webDiscountController;
	private static IWebOrderController webOrderController;
	
	private static IWebStaffController webStaffController;
	private static IWebUserController webUserController;
	
	public static void init(){
		//登录模块
		loginController = SpringUtils.getBean("loginController");
		
		//用户模块
		userController = SpringUtils.getBean("userController");
		userOrderController = SpringUtils.getBean("userOrderController");
		userHotelController = SpringUtils.getBean("userHotelController");
		
		//酒店模块
		hotelController = SpringUtils.getBean("hotelController");
		hotelDiscountController = SpringUtils.getBean("hotelDiscountController");
		hotelOrderController = SpringUtils.getBean("hotelOrderController");
		offlineRecordController = SpringUtils.getBean("offlineRecordController");
		roomController = SpringUtils.getBean("roomController");
		
		//网站营销人员模块
		webCreditController = SpringUtils.getBean("webCreditController");
		webDiscountController = SpringUtils.getBean("webDiscountController");
		webOrderController = SpringUtils.getBean("webOrderController");
		
		//网站管理人员模块
		webStaffController = SpringUtils.getBean("webStaffController");
		webUserController = SpringUtils.getBean("webUserController");
		
	}

}
