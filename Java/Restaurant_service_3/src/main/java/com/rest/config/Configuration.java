package com.rest.config;
import com.rest.dao.OrderedDishDao;
import com.rest.models.Profit;
import com.rest.services.ProfitsService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("com.rest")
@org.springframework.context.annotation.Configuration
public class Configuration {
    public static void main(String[] args) throws Exception {
        //DishService dishService = new DishService();
        //dishService.getAllDishes();

//        Profit profit = new Profit(1);
//        ProfitsService profitsService = new ProfitsService();
//        profitsService.saveProfit(profit);

        /*
        {"orderId" : 1
        }
         */

//        OrderedDishDao orderedDishDao= new OrderedDishDao();
//        orderedDishDao.getAllOrderedDishes();


    }
}
