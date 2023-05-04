package com.github.vertineko.shenpi.service;

import com.github.vertineko.shenpi.dao.CourseDao;
import com.github.vertineko.shenpi.model.Course;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CourseService {
    private static CourseService courseService = new CourseService();
    private CourseService(){}
    public static CourseService getCourseService(){
        return courseService;
    }
    public List<Course> getAllCourse() throws IOException {
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
            if(courseDao.getAllCourse() != null){
                return courseDao.getAllCourse();
            }else{
                return null;
            }
        }
    }
    public Course getCourseById(int id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
            if(courseDao.getCourseById(id) != null){
                return courseDao.getCourseById(id);
            }else{
                return null;
            }
        }
    }
}
