package com.github.vertineko.shenpi.service;

import com.github.vertineko.shenpi.dao.ApplyDao;
import com.github.vertineko.shenpi.model.Apply;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ApplyService {
    private static ApplyService applyService = new ApplyService();
    private ApplyService(){};
    public static ApplyService getApplyService(){
        return applyService;
    }
    public void addApply(Apply apply) throws IOException {
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(apply != null){
                applyDao.addApply(apply);
            }
        }
    }

    public Apply getApply(int course_id , int user_id) throws IOException {
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.getApply(course_id,user_id) != null){
                Apply apply = applyDao.getApply(course_id,user_id);
                return apply;
            }else {
                return null;
            }
        }
    }

    public List<Apply> getSelectedApply(int user_id) throws IOException{
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.getSelectedApply(user_id) != null){
                return applyDao.getSelectedApply(user_id);
            }else {
                return null;
            }
        }
    }

    public List<Apply> getApplyofClass_s1() throws IOException{
        InputStream config = Resources.getResourceAsStream("com/github/vertineko/shenpi/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            ApplyDao applyDao = sqlSession.getMapper(ApplyDao.class);
            if(applyDao.getApplyofClass_s1() != null){
                return applyDao.getApplyofClass_s1();
            }
            return null;
        }
    }
}
