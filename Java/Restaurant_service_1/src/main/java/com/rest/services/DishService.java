package com.rest.services;

import com.rest.dao.DishDao;
import com.rest.models.Dish;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DishService
{
    private DishDao dishDao = new DishDao();
    public DishService()
    {
    }

    public Dish findById(int id)
    {
        return dishDao.findById(id);
    }


    public void saveDish(Dish dish)
    {
        dishDao.save(dish);
    }

    public void deleteDish(Dish dish)
    {
        dishDao.delete(dish);
    }

    public void updateDish(Dish dish)
    {
        dishDao.update(dish);
    }

    public List<Dish> findAll()
    {
        return dishDao.findAll();
    }

    public float getDishPrice(int dishId) { return dishDao.getDishPrice(dishId);}

    //public void testProc() {  dishDao.testProc(); }


}
