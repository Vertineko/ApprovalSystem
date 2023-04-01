package com.github.vertineko.shenpi.dao;

import com.github.vertineko.shenpi.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public void deleteUser(String account);
    public User findUserById(int id);
    public User findUserByAccount(String account);
    public User modifyUser(User user);
    public List<User> getAllUser();
}
