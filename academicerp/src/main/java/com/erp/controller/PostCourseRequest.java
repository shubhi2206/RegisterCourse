package com.erp.controller;

import com.erp.bean.Course_Schedule;
import com.erp.bean.Courses;

import java.util.List;

public class PostCourseRequest {

    public Courses course ;
    public String specialization;
    public List<String> domains;
    public List<Course_Schedule> scheduleList;
    public List<String> prerequisites;


}

