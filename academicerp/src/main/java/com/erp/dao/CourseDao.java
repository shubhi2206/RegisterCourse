package com.erp.dao;

import com.erp.bean.Courses;

import java.util.List;

public interface CourseDao {

    public boolean insertCourse(Courses c);
    public List<String> extractPrerequisite();
    public List<Courses> getPreqObj(List<String> pre);
    public boolean verifyCourse(String name,Integer year);

}
