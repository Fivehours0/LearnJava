package service;

import bean.UserAddress;

import java.util.List;

/**
 * 用户服务，提供服务的接口
 * @author lfy
 *
 */
public interface UserService {
	
	/**
	 * 按照用户id返回所有的收货地址
	 * @param userId
	 * @return
	 */
	public List<UserAddress> getUserAddressList(String userId);

}
