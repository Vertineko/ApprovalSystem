package com.github.vertineko.shenpi.dao;

import com.github.vertineko.shenpi.model.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyDao {
    public void addApply(Apply apply);
    public Apply getApply(@Param("course_id")int course_id , @Param("user_id")int user_id);
    public List<Apply> getSelectedApply(int user_id);
    public List<Apply> getApplyofClass_s1();
    //获得第一审批阶段当前老师所管理课程的所有申请
    public List<Apply> getApplyofClass_S2();
    //获得第二审批阶段当前老师所管理课程的所有申请
    public void removeApply(int id);
}
