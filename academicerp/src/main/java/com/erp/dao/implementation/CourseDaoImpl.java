package com.erp.dao.implementation;

import com.erp.bean.Courses;
import com.erp.dao.CourseDao;
import com.erp.util.Sessionutil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    Session session = Sessionutil.getSession();

    @Override
    public boolean insertCourse(Courses c) {

        Transaction transaction = session.beginTransaction();
        session.save(c);
        transaction.commit();
        session.close();
        return true;


    }

    @Override
    public List<String> extractPrerequisite() {

        String qstring = "SELECT course_code,course_name FROM Courses";
        Query query = session.createQuery(qstring);

        List<String> prerequisites = new ArrayList<>();
        List<Object[]> list = query.list();

        for (Object obj[] : list) {

            //Courses c = (Courses) obj[0];
            //String temp = "Term " + obj[0].toString() + "-" + obj[1].toString() + "-" + (String) obj[2] + "/" + (String) obj[3];
            String temp = (String) obj[0] + "/" + (String) obj[1];
            prerequisites.add(temp);
        }
       // session.close();
        return prerequisites;
    }

    @Override
    public List<Courses> getPreqObj(List<String> pre) {

        List<Courses> preList = new ArrayList<>();

        for(int i =0;i<pre.size();i++)
        {
            String course_name = pre.get(i).split("/")[1];
            System.out.println(course_name);

            String HQL ="FROM Courses WHERE course_name=:course_name";

            Query query = session.createQuery(HQL,Courses.class);

            query.setParameter("course_name",course_name);

            Courses c = (Courses) query.uniqueResult();
            preList.add(c);

        }
        //session.close();
        return preList;
    }
    @Override
    public boolean verifyCourse(String course_name, Integer year) {
        String HQL = "FROM Courses WHERE course_name=:course_name and year=:year";
        Query query = session.createQuery(HQL, Courses.class);
        query.setParameter("course_name", course_name);
        query.setParameter("year", year);
        if(query.getResultList().size() > 0){
           // session.close();
            return false;
        }
        else{
           // session.close();
            return true;
        }

    }
}
