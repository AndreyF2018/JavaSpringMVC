package com.rest.models;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
@Entity
public class DishList
{
    public List<Dish> dishes;

    public DishList()
    {
        dishes = new ArrayList<>();
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
