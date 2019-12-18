package com.rest.dao;

import com.rest.models.Dish;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.rest.utils.HibernateUtil;
import org.hibernate.transform.Transformers;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import javax.persistence.*;
import javax.xml.transform.Transformer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DishDao {

    public Dish getDishById (int id)
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Dish> response = restTemplate.exchange(
                "http://localhost:8888/getdish?id=" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Dish>(){});
        Dish dish = response.getBody();
        return dish;

    }

    public List<Dish> getAllDishes ()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Dish[]> response =  restTemplate.getForEntity("http://localhost:8888/getalldishes",
                Dish[].class);
        Dish[] dishesArray = response.getBody();
        List <Dish> dishes = new ArrayList<Dish>();
        dishes = Arrays.asList(dishesArray);
        System.out.println(dishes.get(1).toString());
        return dishes;

    }

}
