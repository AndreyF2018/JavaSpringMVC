package com.rest.dao;

import com.rest.models.Dish;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rest.utils.HibernateUtil;
import org.hibernate.transform.Transformers;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.xml.transform.Transformer;
import java.util.ArrayList;
import java.util.List;

@NamedStoredProcedureQuery(
        name="test",
        procedureName="test",
        resultClasses = { Dish.class }
)
public class DishDao
{
@Bean
    public Dish findById(int id)
    {
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

    public List<Dish> findAll()
    {
        List<Dish> dishes = (List<Dish>) HibernateUtil.getSessionFactory().openSession().createQuery("from Dish").list();
        return dishes;
    }

    public float getDishPrice (int dishId)
    {
        Dish dish = new Dish();
        dish = findById(dishId);
        return dish.getDishPrice();
    }

//    public static EntityManager getEntityManager() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myhibernate");
//        return emf.createEntityManager();
//    }

//    public void testProc()
//    {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        //Transaction tx1 = session.beginTransaction();
//        List<Dish> dishes = new ArrayList<Dish>();
//        session.beginTransaction();
//        //dishes = session.createStoredProcedureCall("test").getResultList();
//
//
//        //List<Dish> dishes = (List<Dish>) HibernateUtil.getSessionFactory().getCurrentSession().createStoredProcedureCall("test").getResultList();
//        //StoredProcedureQuery query = (StoredProcedureQuery) session.createStoredProcedureCall("test");
//
//
//       EntityManager entityManager = getEntityManager();
//       StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("test");
//        System.out.println(query.getResultList().get(0));
//        //String s = query.getResultList().toString();
//        //System.out.println(dishes.get(0).getDiishTitle());
//       // return (Dish)query.
//        //Dish dish = new Dish(query.get().get(0).toString(),(float)query.getResultList().get(1));
//
//
//
//    }

}

