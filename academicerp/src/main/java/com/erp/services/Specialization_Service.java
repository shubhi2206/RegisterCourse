package com.erp.services;

import com.erp.dao.SpecializationDao;
import com.erp.dao.implementation.SpecializationDaoImpl;

import java.util.List;

public class Specialization_Service {

    public  List<String> getSpecialization()
    {
        SpecializationDao sdao = new SpecializationDaoImpl();
        return (sdao.extractSpecializations());
    }
}
