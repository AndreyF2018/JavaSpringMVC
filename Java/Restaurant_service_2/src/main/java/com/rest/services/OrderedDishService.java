package com.rest.services;

import com.rest.dao.OrderedDishDao;
import com.rest.models.OrderedDish;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderedDishService {

    private OrderedDishDao orderedDishDao = new OrderedDishDao();

    public OrderedDishService()
    {
    }

    public OrderedDish findById(int id)
    {
        return orderedDishDao.findById(id);
    }


    public void saveOrderedDish(OrderedDish orderedDish) { orderedDishDao.save(orderedDish);
    }

    public void deleteOrderedDish(OrderedDish orderedDish) { orderedDishDao.delete(orderedDish); }

    public void updateOrderedDish(OrderedDish orderedDish) { orderedDishDao.update(orderedDish); }

    public List<OrderedDish> findAll()
    {
        return orderedDishDao.findAll();
    }
}
