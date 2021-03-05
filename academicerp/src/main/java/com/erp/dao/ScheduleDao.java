package com.erp.dao;

import com.erp.bean.Course_Schedule;

import java.util.List;

public interface ScheduleDao {

    public boolean insertSchedule(List<Course_Schedule> slist);
}
