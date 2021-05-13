package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    int insertUser(User user);
    List<User> selectUsers();
}
