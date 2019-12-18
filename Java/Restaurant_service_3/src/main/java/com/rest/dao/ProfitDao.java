package com.rest.dao;

import com.rest.models.CostOfCooking;
import com.rest.models.DeliveryCompany;
import com.rest.models.OrderedDish;
import com.rest.models.Profit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rest.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProfitDao {

    OrderedDishDao orderedDishDao = new OrderedDishDao();
    DeliveryCompanyDao deliveryCompanyDao = new DeliveryCompanyDao();
    CostOfCookingDao costOfCookingDao = new CostOfCookingDao();

    public Profit findById(int id)
    {
        return HibernateUtil.getSessionFactory().openSession().get(Profit.class, id);
    }



    public void save(Profit profit) throws Exception {
        if (profit.getOrderId() == 0)
        {
            throw new Exception("Missing order id");
        }
        else {
            if (profit.getOredrCost() == 0.0f || profit.getPercentDeliveries() == 0 || profit.getNetProfit() == 0.0f) {
                System.out.println("11111111111");
                OrderedDish orderedDish = new OrderedDish();
                List<OrderedDish> orderedDishes = new ArrayList<OrderedDish>();
                orderedDishes = orderedDishDao.getAllOrderedDishes();
                System.out.println(orderedDishes.get(0));
                System.out.println(profit.getOrderId());
                for (OrderedDish item : orderedDishes) {
                    if (profit.getOrderId() == item.getOnlineOrderId()) {
                        System.out.println("222222222");
                        System.out.println("OrderCost = " + orderedDishDao.getOrderPrice(profit.getOrderId()));
                        profit.setOredrCost(orderedDishDao.getOrderPrice(profit.getOrderId()));
                        DeliveryCompany company = new DeliveryCompany();
                        company = deliveryCompanyDao.getCompanyById(item.getDeliveryCompanyId());
                        CostOfCooking costOfCooking = new CostOfCooking();
                        costOfCooking = costOfCookingDao.getCookingCostByDishId(item.getDishId());
                        System.out.println("compPrice = " + company.getPricePercent());
                        profit.setPercentDeliveries(company.getPricePercent());
                        float netProfit = (profit.getOredrCost() - costOfCooking.getCost()) * (1 - (profit.getPercentDeliveries() / 100));
                        System.out.println("netProfit = " + netProfit);
                        profit.setNetProfit(netProfit);
                    }
                }
            }
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(profit);
            tx1.commit();
            session.close();
        }
    }

    public void update(Profit profit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(profit);
        tx1.commit();
        session.close();
    }

    public void delete(Profit profit)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(profit);
        tx1.commit();
        session.close();
    }

    public List<Profit> findAll()
    {
        List<Profit> profits = (List<Profit>) HibernateUtil.getSessionFactory().openSession().createQuery("from Profit").list();
        return profits;
    }

    public Profit getProfitByOrderId (int orderId)
    {
        List<Profit> profits = new ArrayList<Profit>();
        profits = findAll();
        Profit profit = new Profit();
        for (Profit item: profits)
        {
            if (item.getOrderId() == orderId)
            {
                profit = item;
            }
        }
        return profit;
    }
}
