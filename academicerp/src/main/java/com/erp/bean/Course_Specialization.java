package com.erp.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course_Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;

    @Column(nullable = false,unique = true)
    private String s_code;

    @Column(nullable = false,unique = true)
    private String s_name;

    private String s_description;

    private String s_year;

    private Integer s_credit_required;

    @OneToMany(mappedBy = "specialization")
    private List<Courses> coursesList = new ArrayList<>();

    public Course_Specialization(){

    }

    public Course_Specialization(String s_code, String s_name, String s_description, String s_year, Integer s_credit_required) {
        this.s_code = s_code;
        this.s_name = s_name;
        this.s_description = s_description;
        this.s_year = s_year;
        this.s_credit_required = s_credit_required;

    }

    public String getS_code() {
        return s_code;
    }

    public void setS_code(String s_code) {
        this.s_code = s_code;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_description() {
        return s_description;
    }

    public void setS_description(String s_description) {
        this.s_description = s_description;
    }

    public String getS_year() {
        return s_year;
    }

    public void setS_year(String s_year) {
        this.s_year = s_year;
    }

    public Integer getS_credit_required() {
        return s_credit_required;
    }

    public void setS_credit_required(Integer s_credit_required) {
        this.s_credit_required = s_credit_required;
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }
}
