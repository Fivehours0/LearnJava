package service.impl;

import java.util.Arrays;
import java.util.List;

import bean.UserAddress;
import service.UserService;

public class UserServiceImpl implements UserService {

	/**
	 * 实现了服务接口，根据用户的id，返回用户的信息，这里模拟数据库的操作，直接返回了两条数据
	 * @param userId
	 * @return
	 */
	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("UserServiceImpl.....old...");
		// TODO Auto-generated method stub
		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
		/*try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return Arrays.asList(address1,address2);
	}

}
