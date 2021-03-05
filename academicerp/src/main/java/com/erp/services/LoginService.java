package com.erp.services;

import com.erp.bean.LoginInfo;
import com.erp.dao.LoginDao;
import com.erp.dao.implementation.LoginDaoImpl;

public class LoginService {

    public boolean verifyUser(LoginInfo login){

        LoginDao loginDao = new LoginDaoImpl();
        return loginDao.userVerify(login);
    }
}
