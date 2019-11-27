package dao;

import models.Dish;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.management.Query;
import javax.persistence.StoredProcedureQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
public class DishDao
{
    public Dish findDishById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Dish.class, id);
    }

    public void save(Dish dish) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(dish);
        tx1.commit();
        session.close();
    }

    public void update(Dish dish) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(dish);
        tx1.commit();
        session.close();
    }

    public void delete(Dish dish)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(dish);
        tx1.commit();
        session.close();
    }

    public void testProc()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        StoredProcedureQuery query = (StoredProcedureQuery) session.createStoredProcedureCall("test");
        System.out.println(query.getResultList());



    }

//    public List<Dish> findAll()
//    {
//        List<Dish> dishes = (List<Dish>) HibernateUtil.getSessionFactory().openSession().createQuery("from Dish").list();
//        return dishes;
//    }
}

