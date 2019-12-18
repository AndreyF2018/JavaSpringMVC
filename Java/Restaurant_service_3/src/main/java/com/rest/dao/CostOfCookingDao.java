package com.rest.dao;

import com.rest.models.CostOfCooking;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rest.utils.HibernateUtil;
import org.hibernate.transform.Transformers;
import org.springframework.context.annotation.Bean;
import javax.persistence.*;
import javax.xml.transform.Transformer;
import java.util.ArrayList;
import java.util.List;

public class CostOfCookingDao {

    public CostOfCooking findById(int id)
    {
        return HibernateUtil.getSessionFactory().openSession().get(CostOfCooking.class, id);
    }



    public void save(CostOfCooking cost) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(cost);
        tx1.commit();
        session.close();
    }

    public void update(CostOfCooking cost) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(cost);
        tx1.commit();
        session.close();
    }

    public void delete(CostOfCooking cost)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(cost);
        tx1.commit();
        session.close();
    }

    public List<CostOfCooking> findAll()
    {
        List<CostOfCooking> costs = (List<CostOfCooking>) HibernateUtil.getSessionFactory().openSession().createQuery("from CostOfCooking").list();
        return costs;
    }

    public CostOfCooking getCookingCostByDishId (int dishId)
    {
        List<CostOfCooking> costs = new ArrayList<CostOfCooking>();
        costs = findAll();
        CostOfCooking cost = new CostOfCooking();
        for (CostOfCooking item: costs)
        {
            if (item.getDishId() == dishId)
            {
                cost = item;
            }
        }
        return cost;
    }
}
