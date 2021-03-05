package com.erp.dao;

import com.erp.bean.LoginInfo;

public interface LoginDao {

    boolean userVerify(LoginInfo login);
}
