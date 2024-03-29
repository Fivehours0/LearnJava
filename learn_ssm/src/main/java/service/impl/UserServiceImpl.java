package service.impl;

import dao.UserDao;
import domain.User;
import org.springframework.stereotype.Service;
import service.UserServiceSSM;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceSSM {

    @Resource
    private UserDao userDao;

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public List<User> selectUsers() {
        return userDao.selectUsers();
    }
}
