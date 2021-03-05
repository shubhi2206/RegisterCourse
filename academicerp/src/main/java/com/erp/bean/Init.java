package com.erp.bean;

import com.erp.util.Sessionutil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Init {
    public static void main(String[] args)
    {
        LoginInfo l = new LoginInfo();
        l.setEmail("admin@iiitb.org");
        l.setPassword("admin123");
        Course_Specialization spec1 = new Course_Specialization();
        spec1.setS_code("TSCD");
        spec1.setS_name("Theory & System for computing and data");
        spec1.setS_year("2020");
        spec1.setS_credit_required(20);

        Course_Specialization spec2 = new Course_Specialization();
        spec2.setS_code("AIML");
        spec2.setS_name("Artificial Intelligence and ML");
        spec2.setS_year("2020");
        spec2.setS_credit_required(20);

        Course_Specialization spec3 = new Course_Specialization();
        spec3.setS_code("NC");
        spec3.setS_name("Network and Communication");
        spec3.setS_year("2020");
        spec3.setS_credit_required(20);

        Course_Specialization spec4 = new Course_Specialization();
        spec4.setS_code("VLSI");
        spec4.setS_name("VLSI System");
        spec4.setS_year("2020");
        spec4.setS_credit_required(20);

        CDomain dom1 = new CDomain();
        dom1.setDomain_name("MTech CSE");
        dom1.setBatch("2020");
        dom1.setDom_capacity(250);

        CDomain dom2 = new CDomain();
        dom2.setDomain_name("MTech CSE");
        dom2.setBatch("2019");
        dom2.setDom_capacity(250);

        CDomain dom3 = new CDomain();
        dom3.setDomain_name("IMTech CSE");
        dom3.setBatch("2020");
        dom3.setDom_capacity(250);

        CDomain dom4 = new CDomain();
        dom4.setDomain_name("IMTech CSE");
        dom4.setBatch("2019");
        dom4.setDom_capacity(250);

        Session session = Sessionutil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(dom1);
        session.save(dom2);
        session.save(dom3);
        session.save(dom4);

        session.save(spec1);
        session.save(spec2);
        session.save(spec3);
        session.save(spec4);

        session.save(l);
        transaction.commit();
        session.close();

    }
}
