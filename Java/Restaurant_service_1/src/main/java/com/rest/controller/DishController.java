package com.rest.controller;

import com.rest.models.Dish;
import com.rest.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DishController
{
    @Autowired
    private DishService dishService;

    @RequestMapping(method = RequestMethod.GET, value = "getdish")
    @ResponseBody
    public Dish getDish(int id)
    {
        return dishService.findById(id);

    }


    @RequestMapping(method =  RequestMethod.GET, value = "getalldishes")
    @ResponseBody
    public List<Dish> getAllDishes()
    {
        return dishService.findAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "getdishprice")
    @ResponseBody
    public float getDishPrice(int id)
    {
        return dishService.getDishPrice(id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "adddish")
    public void postDish(@RequestBody Dish dish)
    {
        dishService.saveDish(dish);


    }


}
