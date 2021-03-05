package com.erp.dao;

import com.erp.bean.CDomain;

import java.util.List;

public interface DomainDao {

    public List<String> extractDomains();
    public List<CDomain> getDomainObj(List<String> dlist);
}
