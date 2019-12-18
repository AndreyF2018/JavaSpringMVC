package com.rest.dao;

import com.rest.models.OrderedDish;
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

public class OrderedDishDao {

    public OrderedDish getOrderedDishById (int id)
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OrderedDish> response = restTemplate.exchange(
                "http://localhost:8080/getorderreddish?id=" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<OrderedDish>(){});
        OrderedDish orderedDish = response.getBody();
        return orderedDish;

    }

    public List<OrderedDish> getAllOrderedDishes ()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OrderedDish[]> response =  restTemplate.getForEntity("http://localhost:8080/getallorderreddishes",
                OrderedDish[].class);
        OrderedDish[] orderedDishArray = response.getBody();
        List <OrderedDish> orderedDishes = new ArrayList<OrderedDish>();
        orderedDishes = Arrays.asList(orderedDishArray);
        return orderedDishes;

    }

    public float getOrderPrice (int orderId)
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Float> response = restTemplate.exchange(
                "http://localhost:8080/getorderprice?id=" + orderId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Float>(){});
        Float orerPrice = response.getBody();
        return orerPrice;

    }
}
