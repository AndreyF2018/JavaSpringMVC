package com.rest.services;

import com.rest.dao.OnlineOrderDao;
import com.rest.models.OnlineOrder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OnlineOrderService {

    private OnlineOrderDao orderDao = new OnlineOrderDao();
    public OnlineOrderService()
    {
    }

    public OnlineOrder findById(int id)
    {
        return orderDao.findById(id);
    }


    public void saveOrder(OnlineOrder order) throws Exception {
        orderDao.save(order);
    }

    public void deleteOrder(OnlineOrder order) { orderDao.delete(order); }

    public void updateOrder(OnlineOrder order) { orderDao.update(order); }

    public List<OnlineOrder> findAll()
    {
        return orderDao.findAll();
    }

    public float getOrderPrice (int orderId) { return orderDao.getOrderPrice(orderId); }
}
