import  models.Dish;
import services.DishService;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        DishService dishService = new DishService();
        //Dish dish = new Dish("Рататуй",320);
        //dishService.saveDish(dish);
        dishService.testProc();

    }
}
