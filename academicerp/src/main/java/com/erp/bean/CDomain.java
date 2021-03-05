package com.erp.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer domain_id;

    @Column(nullable = false)
    private String domain_name;

    @Column(nullable = false)
    private String batch;

    private Integer dom_capacity;

    @ManyToMany(mappedBy = "domains")
    private List<Courses> courseList = new ArrayList<>();

    public CDomain(){

    }

    public CDomain(String domain_name, String batch, Integer dom_capacity) {
        this.domain_name = domain_name;
        this.batch = batch;
        this.dom_capacity = dom_capacity;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Integer getDom_capacity() {
        return dom_capacity;
    }

    public void setDom_capacity(Integer dom_capacity) {
        this.dom_capacity = dom_capacity;
    }

    public List<Courses> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Courses> courseList) {
        this.courseList = courseList;
    }
}
