package com.erp.dao.implementation;

import com.erp.bean.Course_Specialization;
import com.erp.dao.SpecializationDao;
import com.erp.util.Sessionutil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class SpecializationDaoImpl implements SpecializationDao {

    Session session = Sessionutil.getSession();

    @Override
   public List<String> extractSpecializations()
    {
        String qstring = "SELECT s_code,s_year FROM Course_Specialization";
        Query query = session.createQuery(qstring);


        List<String> specializationList = new ArrayList<>();

        List<Object[]> list =query.list();
        for(Object obj[] : list)
        {
            String code = (String) obj[0];
            String year = (String) obj[1];

            String temp = code+"/"+year;
            specializationList.add(temp);

        }
        session.close();
        return specializationList;
    }

    @Override
    public Course_Specialization getSpecializationObj(String s_code) {

        String HQL ="FROM Course_Specialization WHERE s_code=:s_code";
        Query query = session.createQuery(HQL,Course_Specialization.class);

        query.setParameter("s_code",s_code);

        Course_Specialization c = (Course_Specialization) query.uniqueResult();
        return c;
    }
}
