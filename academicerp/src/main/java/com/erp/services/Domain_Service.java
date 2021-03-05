package com.erp.services;

import com.erp.dao.DomainDao;
import com.erp.dao.implementation.DomainDaoImpl;

import java.util.List;

public class Domain_Service {

    public List<String> getDomainList()
    {
        DomainDao dom = new DomainDaoImpl();
        return (dom.extractDomains());
    }
}
