package com.rest.models;

import javax.persistence.*;

@Entity
@Table(name = "onlineordereddishes")
public class OrderedDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer onlineOrderedDishesId;

    @Column(name = "OnlineOrderId")
    private int onlineOrderId;


    @Column(name = "DishId")
    private int dishId;

    @Column(name = "DeliveryCompanyId")
    private int deliveryCompanyId;

    public OrderedDish() {}

    public OrderedDish(int onlineOrderId, int dishId, int deliveryCompanyId)
    {
        this.setOnlineOrderId(onlineOrderId);
        this.setDishId(dishId);
        this.setDeliveryCompanyId(deliveryCompanyId);
    }

    public Integer getOnlineOrderedDishesId() {
        return onlineOrderedDishesId;
    }


    public int getOnlineOrderId() {
        return onlineOrderId;
    }

    public void setOnlineOrderId(int onlineOrderId) {
        this.onlineOrderId = onlineOrderId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getDeliveryCompanyId() {
        return deliveryCompanyId;
    }

    public void setDeliveryCompanyId(int deliveryCompanyId) {
        this.deliveryCompanyId = deliveryCompanyId;
    }

    @Override
    public String toString() {
        return onlineOrderedDishesId + ". " + onlineOrderId + " " +  dishId + " " + deliveryCompanyId;

    }
}
