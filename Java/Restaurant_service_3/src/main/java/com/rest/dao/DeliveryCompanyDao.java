package com.rest.dao;

import com.rest.models.DeliveryCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliveryCompanyDao {

//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//    @Autowired
//    private RestTemplate restTemplate;

    public DeliveryCompany getCompanyById (int id)
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DeliveryCompany> response = restTemplate.exchange(
                "http://localhost:8888/getcompany?id=" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<DeliveryCompany>(){});
        DeliveryCompany company = response.getBody();
        return company;

    }

    public List<DeliveryCompany> getAllCompanies ()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DeliveryCompany[]> response =  restTemplate.getForEntity("http://localhost:8888/getallcompanies",
                DeliveryCompany[].class);
        DeliveryCompany[] companiesArray = response.getBody();
        List <DeliveryCompany> companies = new ArrayList<DeliveryCompany>();
        companies = Arrays.asList(companiesArray);
        //System.out.println(companies.get(0).toString());
        return companies;

    }
}
