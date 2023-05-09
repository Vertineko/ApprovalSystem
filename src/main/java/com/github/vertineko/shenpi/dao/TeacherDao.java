package com.github.vertineko.shenpi.dao;

import com.github.vertineko.shenpi.model.Teacher;

import java.util.List;

public interface TeacherDao {
    public Teacher getTeacher(String account);
    public List<Teacher> getSpeecherofClass(int course_id);
    public List<Teacher> getManageofClass(int course_id);
    public Teacher getTeacherById(int id);
    public List<Teacher> getAllTeacher();
    public void deleteTeacher(int id);
    public void updateTeacher(Teacher teacher);
    public void addTeacher(Teacher teacher);
}
