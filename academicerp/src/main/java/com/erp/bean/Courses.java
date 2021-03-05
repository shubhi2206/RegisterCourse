package com.erp.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    private String course_code;

    @Column(nullable = false)
    private String course_name;

    private Integer credit;
    private String course_description;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer term;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String faculty;

    //Course Schedule
    @OneToMany(mappedBy = "course")
    private List<Course_Schedule> schedules = new ArrayList<>();

    //Course specialization
    @ManyToOne
    private Course_Specialization specialization ;

    //Course domain
    @ManyToMany
    private List<CDomain> domains = new ArrayList<>();

    //Course pre-requisite (Many to many, self)
    @ManyToMany
    private List<Courses> prerequisites = new ArrayList<>();

    @ManyToMany(mappedBy = "prerequisites")
    private List<Courses> courses_pre = new ArrayList<>();

    public Courses(){

    }

    public Courses(String course_name, Integer credit, String course_description, Integer year, Integer term, Integer capacity, String faculty) {
        this.course_name = course_name;
        this.credit = credit;
        this.course_description = course_description;
        this.year = year;
        this.term = term;
        this.capacity = capacity;
        this.faculty = faculty;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public List<Course_Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Course_Schedule> schedules) {
        this.schedules = schedules;
    }

    public Course_Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Course_Specialization specialization) {
        this.specialization = specialization;
    }

    public List<CDomain> getDomains() {
        return domains;
    }

    public void setDomains(List<CDomain> domains) {
        this.domains = domains;
    }

    public List<Courses> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Courses> prerequisites) {
        this.prerequisites = prerequisites;
    }
}
