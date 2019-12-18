package com.rest.config;


import com.rest.controller.*;
import com.rest.services.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("com.rest")
@org.springframework.context.annotation.Configuration
public class Configuration {
    public static void main(String[] args) {
        DishController dishController = new DishController();
        DishService dishService = new DishService();
        DeliveryCompanyService deliveryCompanyService = new DeliveryCompanyService();
        //System.out.println(deliveryCompanyService.MinPrice().getPricePercent());
        //dishService.testProc();
        //dishController.restTest();
        //dishController.getDish(1);
    }

}