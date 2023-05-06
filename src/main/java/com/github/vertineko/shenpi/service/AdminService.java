package com.github.vertineko.shenpi.service;

import com.github.vertineko.shenpi.dao.AdminDao;
import com.github.vertineko.shenpi.model.Admin;
import com.github.vertineko.shenpi.model.Apply;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AdminService {
    private static AdminService adminService = new AdminService();
    private AdminService(){};
    public static AdminService getAdminService(){
        return adminService;
    }
    public boolean adminLogin(String username , String password) throws IOException{
        Admin admin = getAdmin(username);
        if(admin != null){
            if(admin.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public Admin getAdmin(String username) throws IOException {
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
            if(adminDao.getAdmin(username) != null){
                return adminDao.getAdmin(username);
            }else {
                return null;
            }
        }
    }
}
