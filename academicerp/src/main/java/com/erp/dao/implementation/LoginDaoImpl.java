package com.erp.dao.implementation;

import com.erp.bean.LoginInfo;
import com.erp.dao.LoginDao;
import com.erp.util.Sessionutil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginDaoImpl implements LoginDao {

    @Override
    public boolean userVerify(LoginInfo login) {

        String email = login.getEmail();
        String password = login.getPassword();
        LoginInfo dbLoginInfo;


        Session session = Sessionutil.getSession();

        String HQL ="FROM LoginInfo WHERE email=:email and password=:password";

        Query query = session.createQuery(HQL, LoginInfo.class);

        query.setParameter("email",email);
        query.setParameter("password",password);

        dbLoginInfo = (LoginInfo) query.uniqueResult();

       // dbLoginInfo = (LoginInfo) session.get(LoginInfo.class, "admin@iiitb.org");
       // transaction.commit();
        session.close();

        if (email.equals(dbLoginInfo.getEmail()) && password.equals(dbLoginInfo.getPassword())) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Login UnSuccessful");
            return false;
        }

    }
}