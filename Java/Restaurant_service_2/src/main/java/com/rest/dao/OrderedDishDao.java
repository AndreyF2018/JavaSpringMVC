package com.rest.dao;

import com.rest.models.OrderedDish;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rest.utils.HibernateUtil;
import org.hibernate.transform.Transformers;
import org.springframework.context.annotation.Bean;
import javax.persistence.*;
import javax.xml.transform.Transformer;
import java.util.ArrayList;
import java.util.List;

public class OrderedDishDao {

    public OrderedDish findById(int id)
    {
        return HibernateUtil.getSessionFactory().openSession().get(OrderedDish.class, id);
    }



    public void save(OrderedDish orderedDish)  {

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            System.out.println(orderedDish);
            session.save(orderedDish);
            tx1.commit();
            session.close();

    }

    public void update(OrderedDish orderedDish) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(orderedDish);
        tx1.commit();
        session.close();
    }

    public void delete(OrderedDish orderedDish)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(orderedDish);
        tx1.commit();
        session.close();
    }

    public List<OrderedDish> findAll()
    {
        List<OrderedDish> orderedDishes = (List<OrderedDish>) HibernateUtil.getSessionFactory().openSession().createQuery("from OrderedDish").list();
        return orderedDishes;
    }

}
