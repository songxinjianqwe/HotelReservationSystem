package hrs.server.Service.Impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrs.common.Exception.UserService.UserExistedException;
import hrs.common.Exception.UserService.UserNotFoundException;
import hrs.common.Exception.UserService.UserPasswordErrorException;
import hrs.common.POJO.UserPO;
import hrs.common.VO.EnterpriseVO;
import hrs.common.VO.UserVO;
import hrs.common.util.DesUtil;
import hrs.common.util.ResultMessage;
import hrs.server.DAO.Interface.UserDAO;
import hrs.server.Service.Interface.PromotionService.EnterpriseService;
import hrs.server.Service.Interface.UserService.UserService;
/**
 * 
* @ClassName: UserServiceImpl
* @Description: 
* @author NewSong
* @date 2016年11月19日 下午9:41:06
*
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	@Autowired
	private EnterpriseService enterpriseService;
	private DesUtil util;
	
	/**
	 * 
	 * @Title: findByUsername
	 * @Description: 按用户名查找用户
	 * @param username
	 * @return
	 * @throws UserNotFoundException  
	 * @see hrs.server.Service.Interface.UserService.UserService#findByUsername(java.lang.String)
	 */
	@Transactional
	@Override
	public UserVO findByUsername(String username) throws UserNotFoundException {
		util = DesUtil.getInstance();
		UserPO po = dao.findByUserName(util.encode(username));
		if (po == null) {
			throw new UserNotFoundException();
		} else {
			return new UserVO((po));
		}
	}
	/**
	 * 
	 * @Title: register
	 * @Description: 用户注册
	 * @param uservo
	 * @throws UserExistedException  
	 * @see hrs.server.Service.Interface.UserService.UserService#register(hrs.common.VO.UserVO)
	 */
	@Transactional
	@Override
	public void register(UserVO uservo) throws UserExistedException {
		// 从界面拿到的要加密
		UserPO po = new UserPO(uservo);
		if (dao.add(po) == ResultMessage.EXISTED) {
			throw new UserExistedException();
		} else if(po.getEnterprise() != null){
			enterpriseService.add(new EnterpriseVO(po.getEnterprise()));
		}
	}
	/**
	 * 
	 * @Title: update
	 * @Description: 用户更新
	 * @param uservo  
	 * @see hrs.server.Service.Interface.UserService.UserService#update(hrs.common.VO.UserVO)
	 */
	@Transactional
	@Override
	public void update(UserVO uservo) {
		// 从界面拿到的要加密
		dao.update((new UserPO(uservo)));
	}
	/**
	 * 
	 * @Title: login
	 * @Description: 用户登录
	 * @param username
	 * @param password
	 * @return UserVO
	 * @throws UserNotFoundException
	 * @throws UserPasswordErrorException  
	 * @see hrs.server.Service.Interface.UserService.UserService#login(java.lang.String, java.lang.String)
	 */
	@Transactional
	@Override
	public UserVO login(String username, String password) throws UserNotFoundException, UserPasswordErrorException {
		util = DesUtil.getInstance();
		UserPO po = dao.findByUserName(util.encode(username));
		if (po == null) {
			throw new UserNotFoundException();
		} else if (!po.getPassword().equals(util.encode(password))) {
			throw new UserPasswordErrorException();
		} else {
			return new UserVO((po));
			// 从数据库取出的要解密
		}
	}
	/**
	 * 
	 * @Title: validateCredit
	 * @Description: 验证用户信用值是否大于等于0
	 * @param username
	 * @return  
	 * @see hrs.server.Service.Interface.UserService.UserService#validateCredit(java.lang.String)
	 */
	@Transactional
	@Override
	public boolean validateCredit(String username) {
		try {
			return findByUsername(username).credit >= 0;
		} catch (UserNotFoundException e) {
		}
		return false;
	}

}
