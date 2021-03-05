package com.erp.dao;

import com.erp.bean.Course_Specialization;

import java.util.List;

public interface SpecializationDao {

    public List<String> extractSpecializations();
    public Course_Specialization getSpecializationObj(String name);
}
