package com.rest.config;
import com.rest.controller.*;
import com.rest.models.OnlineOrder;
import com.rest.models.OrderedDish;
import com.rest.services.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("com.rest")
@org.springframework.context.annotation.Configuration
public class Configuration {
    public static void main(String[] args) throws Exception {
        OnlineOrderService orderService = new OnlineOrderService();
        OnlineOrder order = new OnlineOrder("Street 1", "Alex", 2, 1);
        orderService.saveOrder(order);

//        OrderedDishService orderedDishService = new OrderedDishService();
//        OrderedDish orderedDish = new OrderedDish(1, 2, 3);
//        orderedDishService.saveOrderedDish(orderedDish);



    }
}
