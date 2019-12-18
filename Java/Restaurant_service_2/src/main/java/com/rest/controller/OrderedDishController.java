package com.rest.controller;

import com.rest.models.OrderedDish;
import com.rest.services.OrderedDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class OrderedDishController {

    @Autowired
    private OrderedDishService orderedDishService;

    @RequestMapping(method = RequestMethod.GET, value = "getorderreddish")
    @ResponseBody
    public OrderedDish getOrderedDish(int id)
    {
        return orderedDishService.findById(id);

    }

    @RequestMapping(method = RequestMethod.GET, value = "getallorderreddishes")
    @ResponseBody
    public List<OrderedDish> getAllOrderedDishes()
    {
        return orderedDishService.findAll();

    }
}
