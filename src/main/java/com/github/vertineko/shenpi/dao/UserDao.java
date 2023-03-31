package com.github.vertineko.shenpi.dao;

import com.github.vertineko.shenpi.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(String name,String telephone,String account,String password);
    public void deleteUser(String account);
    public User findUserById(int id);
    public User findUserByAccount(String account);
    public User modifyUser(User user);
    public List<User> getAllUser();
}
