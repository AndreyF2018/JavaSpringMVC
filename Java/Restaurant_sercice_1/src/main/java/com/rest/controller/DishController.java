package com.rest.controller;

import com.rest.models.Dish;
import com.rest.models.DishList;
import com.rest.services.DishService;
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




//    @RequestMapping(method = RequestMethod.PUT, value = "putdish")
//    @ResponseBody
//    public Dish putDish()
//    {
//        return dishService.findDish(2);
//

//    }//    @RequestMapping(method = RequestMethod.GET, value = "putdish")
//    @ResponseBody
//    public Dish getputDish()
//    {
//        return putDish();
//
//    }

    //Работает:
    public float restTest()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Float> response = restTemplate.exchange(
                "http://localhost:8888/getdishprice?id=1",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Float>(){});
        Float dish = response.getBody();
        System.out.println(dish);
        return dish;
}
//Работает:
    public Dish restTestMas() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Dish[]> response =  restTemplate.getForEntity("http://localhost:8888/getalldishes",
                Dish[].class);
        Dish[] dishes = response.getBody();
        System.out.println(dishes[0].toString());
        return dishes[0];
    }


//    public DishList restTestList()
//    {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<DishList> response = restTemplate.getForEntity("http://localhost:8888/getalldish", DishList.class);
//        DishList dishes = response.getBody();
//        System.out.println(dishes.getDishes().get(0).toString());
//        return dishes;
//    }

//    @RequestMapping(method = {RequestMethod.POST},  value = "resttestpost")
//    @ResponseBody
//    public List<Dish> restTestPost()
//    {
//        List<Dish> newDishes = new ArrayList<>();
//        newDishes.add(new Dish("Клафути", 200));
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.postForObject(
//                "http://localhost:8888/resttestpost",
//                newDishes,
//                Dish.class);
//        return newDishes;
//    }


//    @RequestMapping(method = {RequestMethod.GET},  value = "testproc")
//    @ResponseBody
//    public Dish testProc()
//    {
//        return dishService.testProc();
//    }




}
