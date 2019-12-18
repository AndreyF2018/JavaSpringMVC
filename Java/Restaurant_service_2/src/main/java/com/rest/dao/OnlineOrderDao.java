package com.rest.dao;

import com.rest.models.DeliveryCompany;
import com.rest.models.Dish;
import com.rest.models.OnlineOrder;
import com.rest.models.OrderedDish;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rest.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

public class OnlineOrderDao {

    DishDao dishDao = new DishDao();
    OrderedDishDao orderedDishesDao = new OrderedDishDao();
    DeliveryCompanyDao deliveryCompanyDao = new DeliveryCompanyDao();
    public OnlineOrder findById(int id)
    {
        return HibernateUtil.getSessionFactory().openSession().get(OnlineOrder.class, id);
    }



    public void save(OnlineOrder order) throws Exception {
        List<Dish> dishes = new ArrayList<Dish>();
        dishes = dishDao.getAllDishes();
        List<Integer> dishesId = new ArrayList<Integer>();

        boolean isCont = false;
        for(Dish item: dishes)
        {
            dishesId.add(item.getId());
            if (dishesId.contains(order.getDishId()))
            {
                isCont = true;
            }
        }
        if (isCont == false)

        {
            throw new Exception("Exception: This dish is not on the menu");
        }
        else
            {
//                DeliveryCompany company = new DeliveryCompany();
//                company = deliveryCompanyDao.getCompanyMinPrice();
//                OrderedDishes orderedDishes = new OrderedDishes(order.getOnlineOrderId(), order.getDishId(), company.getId());
//                orderedDishesDao.save(orderedDishes);
               // orderedDishesDao.add(order.getOnlineOrderId(), order.getDishId());
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx1 = session.beginTransaction();
                System.out.println(order);
                session.save(order);
                tx1.commit();
                DeliveryCompany company = new DeliveryCompany();
                company = deliveryCompanyDao.getCompanyMinPrice();

                OrderedDish orderedDishes = new OrderedDish(order.getOnlineOrderId(), order.getDishId(), company.getId());

                System.out.println(order.getOnlineOrderId());
                System.out.println(order.getDishId());
                System.out.println(company.getId());
//                orderedDishes.setOnlineOrderId(order.getOnlineOrderId());
//                orderedDishes.setDishId(order.getDishId());
//                orderedDishes.setDeliveryCompanyId(company.getId());
                orderedDishesDao.save(orderedDishes);
                session.close();
            }
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

    public float getOrderPrice (int orderId)
    {
        OnlineOrder order = new OnlineOrder();
        order = findById(orderId);
        Dish dish = new Dish();
        dish = dishDao.getDishById(order.getDishId());
        float orderPrice = dish.getDishPrice() * order.getQuantity();
        return  orderPrice;
    }
}
