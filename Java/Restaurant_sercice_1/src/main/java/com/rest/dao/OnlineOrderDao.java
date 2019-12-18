package com.rest.dao;

import com.rest.models.OnlineOrder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rest.utils.HibernateUtil;
import org.hibernate.transform.Transformers;
import org.springframework.context.annotation.Bean;
import javax.persistence.*;
import javax.xml.transform.Transformer;
import java.util.ArrayList;
import java.util.List;

public class OnlineOrderDao {

    public OnlineOrder findById(int id)
    {
        return HibernateUtil.getSessionFactory().openSession().get(OnlineOrder.class, id);
    }



    public void save(OnlineOrder order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(order);
        tx1.commit();
        session.close();
    }

    public void update(OnlineOrder order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(order);
        tx1.commit();
        session.close();
    }

    public void delete(OnlineOrder order)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(order);
        tx1.commit();
        session.close();
    }

    public List<OnlineOrder> findAll()
    {
        List<OnlineOrder> orders = (List<OnlineOrder>) HibernateUtil.getSessionFactory().openSession().createQuery("from OnlineOrder").list();
        return orders;
    }
}
