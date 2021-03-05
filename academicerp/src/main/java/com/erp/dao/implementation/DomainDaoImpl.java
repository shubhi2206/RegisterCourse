package com.erp.dao.implementation;

import com.erp.bean.CDomain;
import com.erp.dao.DomainDao;
import com.erp.util.Sessionutil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DomainDaoImpl implements DomainDao {

    Session session = Sessionutil.getSession();

    @Override
    public List<String> extractDomains()
    {
        String qstring = "SELECT domain_name,batch FROM CDomain";
        Query query = session.createQuery(qstring);


        List<String> domainList = new ArrayList<>();

        List<Object[]> list =query.list();
        for(Object obj[] : list)
        {
            String name = (String) obj[0];
            String batch = (String) obj[1];

            String temp = name+"/"+batch;
            //System.out.println(temp);
            domainList.add(temp);

        }
        session.close();
        return domainList;
    }

    @Override
    public List<CDomain> getDomainObj(List<String> dList) {

        List<CDomain> cDomainList = new ArrayList<>();
        for(int i =0;i<dList.size();i++)
        {
            String domain_name = dList.get(i).split("/")[0];
            String batch = dList.get(i).split("/")[1];

            String HQL ="FROM CDomain WHERE domain_name=:domain_name and batch=:batch";
            Query query = session.createQuery(HQL, CDomain.class);

            query.setParameter("domain_name",domain_name);
            query.setParameter("batch",batch);

            CDomain c = (CDomain) query.uniqueResult();
            cDomainList.add(c);

        }

        return cDomainList;
    }
}
