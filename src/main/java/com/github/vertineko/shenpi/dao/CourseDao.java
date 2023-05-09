package com.github.vertineko.shenpi.dao;

import java.util.List;
import com.github.vertineko.shenpi.model.Course;
public interface CourseDao {
    public void addCourse(Course course);
    public List<Course> getAllCourse();
    public Course getCourseById(int id);
    public void modify(Course course);
    public void delete(int id);
}
