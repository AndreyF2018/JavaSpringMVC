package com.rest.controller;


import com.rest.models.CostOfCooking;
import com.rest.services.CostOfCookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class CostOfCookingController {

    @Autowired
    private CostOfCookingService costOfCookingService;

    @RequestMapping(method = RequestMethod.GET, value = "getcookingcost")
    @ResponseBody
    public CostOfCooking getCookingCost(int id)
    {
        return costOfCookingService.findById(id);

    }

    @RequestMapping(method = RequestMethod.GET, value = "getallcookingcosts")
    @ResponseBody
    public List<CostOfCooking> getAllCookingCosts()
    {
        return costOfCookingService.findAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "getcookingcostbydishid")
    @ResponseBody
    public CostOfCooking getCookingCostByDishId(int id)
    {
        return costOfCookingService.getCookingCostByDishId(id);

    }
}
