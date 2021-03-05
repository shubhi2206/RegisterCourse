package com.erp.services;

import com.erp.bean.CDomain;
import com.erp.bean.Course_Schedule;
import com.erp.bean.Course_Specialization;
import com.erp.bean.Courses;
import com.erp.controller.PostCourseRequest;
import com.erp.dao.CourseDao;
import com.erp.dao.DomainDao;
import com.erp.dao.ScheduleDao;
import com.erp.dao.SpecializationDao;
import com.erp.dao.implementation.CourseDaoImpl;
import com.erp.dao.implementation.DomainDaoImpl;
import com.erp.dao.implementation.ScheduleDaoImpl;
import com.erp.dao.implementation.SpecializationDaoImpl;

import java.util.List;
import java.util.Random;

public class CourseService {

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public String generateCode(int term, int year, String s_code){
        String code = "T"+ String.valueOf(term)+"-"+String.valueOf(year)+"-"+ s_code+String.valueOf(getRandomNumberUsingNextInt(400,600));
        return code;
    }

    public boolean postCourse(PostCourseRequest request)
    {

        String special = request.specialization.split("/")[0]; //split specialization
        List<Course_Schedule> schedList = request.scheduleList; //schedule from front end
        Courses c =request.course;//Course details from front end

        CourseDao cdao = new CourseDaoImpl();
        List<Courses> preList = cdao.getPreqObj(request.prerequisites);

        SpecializationDao sdao = new SpecializationDaoImpl();
        Course_Specialization s = sdao.getSpecializationObj(special);

        DomainDao ddao = new DomainDaoImpl();
        List<CDomain> domlist =ddao.getDomainObj(request.domains);

        //Course Code Generation
        String code = generateCode(c.getTerm(), c.getYear(),s.getS_code());
        if(cdao.verifyCourse(c.getCourse_name(),c.getYear()))
        {
            c.setCourse_code(code);
            c.setSpecialization(s);
            c.setDomains(domlist);
            c.setPrerequisites(preList);

            CourseDao cdao1 = new CourseDaoImpl();
            cdao1.insertCourse(c);

            for(Course_Schedule cs :schedList)
            {
                cs.setCourse(c);
            }
            ScheduleDao scdao = new ScheduleDaoImpl();
            scdao.insertSchedule(schedList);
            return true;
        }
        else
            return false;


    }
    public List<String> getPrerequisites()
    {
            CourseDao cdao = new CourseDaoImpl();
            return (cdao.extractPrerequisite());
    }
}
