package com.rest.controller;

import com.rest.models.Profit;
import com.rest.services.ProfitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class ProfitController {

    @Autowired
    private ProfitsService profitsService;

    @RequestMapping(method = RequestMethod.GET, value = "getprofit")
    @ResponseBody
    public Profit getProfit(int id)
    {
        return profitsService.findById(id);

    }

    @RequestMapping(method = RequestMethod.GET, value = "getallprofits")
    @ResponseBody
    public List<Profit> getAllProfits()
    {
        return profitsService.findAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "getprofitbyorderid")
    @ResponseBody
    public Profit getProfitByOrderId(int id)
    {
        return profitsService.getProfitByOrderId(id);

    }
}
