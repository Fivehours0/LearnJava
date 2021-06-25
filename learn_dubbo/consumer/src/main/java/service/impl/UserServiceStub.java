package service.impl;

import java.util.List;

import org.springframework.util.StringUtils;

import bean.UserAddress;
import service.UserService;

/**
 * 本地存根
 */
public class UserServiceStub implements UserService {
	
	private final UserService userService;

	/**
	 * 传入的是userService远程的代理对象
	 * @param userService
	 */
	public UserServiceStub(UserService userService) {
		super();
		this.userService = userService;
	}


	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		// 此代码在客户端执行, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
		// 预先验证参数是否合法(if (userId.equals("")) return null) 这样子
		// TODO Auto-generated method stub
		System.out.println("UserServiceStub.....");
		if(!StringUtils.isEmpty(userId)) {
			return userService.getUserAddressList(userId);
		}
		return null;
	}

}