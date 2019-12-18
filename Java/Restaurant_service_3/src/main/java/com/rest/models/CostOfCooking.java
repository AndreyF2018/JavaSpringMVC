package com.rest.models;

import javax.persistence.*;

@Entity
@Table(name = "сostofcooking")
public class CostOfCooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costOfCookingId;

    @Column(name = "DishId")
    private int dishId;


    @Column(name = "Cost")
    private float cost;

    public Integer getCostOfCookingId() {
        return costOfCookingId;
    }

    public CostOfCooking () {}

    public CostOfCooking(int dishId, float cost)
    {
        this.setDishId(dishId);
        this.setCost(cost);
    }


    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString()
    {
        return costOfCookingId + ". " + dishId + " " +  costOfCookingId;
    }
}
