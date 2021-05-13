package service;

import domain.User;

import java.util.List;

public interface UserService {
    int insertUser(User user);
    List<User> selectUsers();
}
