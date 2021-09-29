package service;

import domain.User;

import java.util.List;

public interface UserServiceSSM {
    int insertUser(User user);
    List<User> selectUsers();
}
