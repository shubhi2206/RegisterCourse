package com.erp.bean;

import javax.persistence.*;

@Entity
public class Course_Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schedule_id;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private String room;

    @Column(nullable = false)
    private String building;

    @ManyToOne
    private Courses course;

    public Course_Schedule(){

    }
    public Course_Schedule(String time, String day, String room, String building, Courses course) {
        this.time = time;
        this.day = day;
        this.room = room;
        this.building = building;
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }
}
