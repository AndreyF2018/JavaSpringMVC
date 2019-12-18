package com.rest.controller;

import com.rest.models.DeliveryCompany;
import com.rest.services.DeliveryCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DeliveryCompanyController {

    @Autowired
    private DeliveryCompanyService companyService;

    @RequestMapping(method = RequestMethod.GET, value = "getcompany")
    @ResponseBody
    public DeliveryCompany getCompany(int id)
    {
        return companyService.findById(id);

    }

    @RequestMapping(method = RequestMethod.GET, value = "getallcompanies")
    @ResponseBody
    public List<DeliveryCompany> getAllCompanies()
    {
        return companyService.findAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "getcompanyminprice")
    @ResponseBody
    public DeliveryCompany getCompanyMinPrice()
    {
        return companyService.MinPrice();
    }
}
