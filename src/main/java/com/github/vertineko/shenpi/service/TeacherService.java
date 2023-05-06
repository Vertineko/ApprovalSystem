package com.github.vertineko.shenpi.service;

import com.github.vertineko.shenpi.dao.TeacherDao;
import com.github.vertineko.shenpi.model.Teacher;
import com.github.vertineko.shenpi.servlet.TeacherLoginServlet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TeacherService {
    private static TeacherService teacherService = new TeacherService();
    private TeacherService(){};
    public static TeacherService getTeacherService(){
        return teacherService;
    }
    public Teacher getTeacher(String account) throws IOException {
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            if(teacherDao.getTeacher(account) != null){
                return teacherDao.getTeacher(account);
            }else {
                return null;
            }
        }
    }

    public boolean TeacherLogin(String account , String password) throws IOException{
        Teacher teacher = getTeacher(account);
        if(teacher != null){
            if(teacher.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public List<Teacher> getSpeecherofClass(int course_id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            if(teacherDao.getSpeecherofClass(course_id) != null){
                return teacherDao.getSpeecherofClass(course_id);
            }
            return null;
        }
    }

    public List<Teacher> getManageofClass(int course_id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            if(teacherDao.getManageofClass(course_id) != null){
                return teacherDao.getManageofClass(course_id);
            }
            return null;
        }
    }

    public Teacher getTeacherById(int id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            if(teacherDao.getTeacherById(id) != null){
                return teacherDao.getTeacherById(id);
            }
            return null;
        }

    }

}
