package com.rest.controller;

import com.rest.models.OnlineOrder;
import com.rest.services.OnlineOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class OnlineOrderController {

    @Autowired
    private OnlineOrderService orderService;

    @RequestMapping(method = RequestMethod.GET, value = "getorder")
    @ResponseBody
    public OnlineOrder getOrder(int id)
    {
        return orderService.findById(id);

    }

    @RequestMapping(method = RequestMethod.GET, value = "getallorders")
    @ResponseBody
    public List<OnlineOrder> getAllOrders()
    {
        return orderService.findAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "getorderprice")
    @ResponseBody
    public float getOrderPrice(int id)
    {
        return orderService.getOrderPrice(id);

    }

    @RequestMapping(method = RequestMethod.POST, value = "postorder")
    public void postOrderPrice(@RequestBody OnlineOrder order) throws Exception {
        orderService.saveOrder(order);

    }





}
