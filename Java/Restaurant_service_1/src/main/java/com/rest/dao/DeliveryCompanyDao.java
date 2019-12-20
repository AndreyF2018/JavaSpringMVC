package com.rest.dao;

import com.rest.models.DeliveryCompany;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rest.utils.HibernateUtil;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.hibernate.transform.Transformers;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.xml.transform.Transformer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DeliveryCompanyDao {

    @Bean
    public DeliveryCompany findById(int id)
    {
        return HibernateUtil.getSessionFactory().openSession().get(DeliveryCompany.class, id);
    }

    public void save(DeliveryCompany company) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(company);
        tx1.commit();
        session.close();
    }

    public void update(DeliveryCompany company) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(company);
        tx1.commit();
        session.close();
    }


    public void delete(DeliveryCompany company)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(company);

        tx1.commit();
        session.close();
    }

    public List<DeliveryCompany> findAll()
    {
        List<DeliveryCompany> companies = (List<DeliveryCompany>) HibernateUtil.getSessionFactory().openSession().createQuery("from DeliveryCompany").list();
        return companies;
    }

    public DeliveryCompany MinPrice()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        StoredProcedureQuery query = (StoredProcedureQuery) session.createStoredProcedureCall("MinPrice");
        int companyId = (int) query.getSingleResult();
        session.close();
        DeliveryCompany company = new DeliveryCompany();
        company = findById(companyId);
        return company;

    }


}
