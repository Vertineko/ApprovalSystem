package com.github.vertineko.shenpi.service;

import com.github.vertineko.shenpi.dao.UserDao;
import com.github.vertineko.shenpi.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserService {
    private static UserService userservice = new UserService();
    private UserService(){}
    public static UserService getUserService(){
        return userservice;
    }
    public boolean loginService(String username , String password) throws IOException {
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            if(userDao.findUserByAccount(username) != null){
                return userDao.findUserByAccount(username).getPassword().equals(password);
            }else {
                return false;
            }
        }


    }
    public void regiseterService(String name,String telephone,String account,String password) throws IOException{
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = new User(1,name,telephone,account,password);
            userDao.addUser(user);
        }
    }
    public User findUserByAccount(String account) throws IOException{
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            if(userDao.findUserByAccount(account) != null){
                return userDao.findUserByAccount(account);
            }else {
                return null;
            }
        }
    }


}
