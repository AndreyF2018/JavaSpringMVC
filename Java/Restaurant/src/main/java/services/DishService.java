package services;

import dao.DishDao;
import models.Dish;
import java.util.List;
import javax.persistence.EntityManager;
public class DishService
{
    private DishDao dishDao = new DishDao();
    public DishService()
    {
    }

    public Dish findDish(int id)
    {
        return dishDao.findDishById(id);
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

    public void testProc()
    {
        dishDao.testProc();
    }

//    public List<Dish> findAllDishes()
//    {
//        return usersDao.findAll();
//    }

}
