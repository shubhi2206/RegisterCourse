package com.erp.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Sessionutil {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration con = new Configuration();
            con.configure();

            ourSessionFactory = con.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
}
