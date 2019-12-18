package com.rest.services;
import com.rest.dao.DishDao;
import com.rest.models.Dish;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DishService {
    private DishDao dishDao = new DishDao();

    public DishService() {
    }

    public Dish getDishById (int id)
    {
        return dishDao.getDishById(id);
    }

    public List<Dish> getAllDishes ()
    {
        return dishDao.getAllDishes();
    }


}