package com.erp.dao.implementation;

import com.erp.bean.Course_Schedule;
import com.erp.dao.ScheduleDao;
import com.erp.util.Sessionutil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {

    Session session = Sessionutil.getSession();
    @Override
    public boolean insertSchedule(List<Course_Schedule> slist) {

        Transaction transaction = session.beginTransaction();

        for(Course_Schedule sc :slist)
        {
            session.save(sc);
        }
        transaction.commit();
        session.close();
        return true;
    }
}
