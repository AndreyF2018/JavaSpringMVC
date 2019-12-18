package com.rest.models;
import javax.persistence.*;

@Entity
@Table(name = "onlineorders")
public class OnlineOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OnlineOrderId;

    @Column(name = "Adress")
    private String adress;


    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "DishId")
    private int dishId;

    @Column(name = "Quantity")
    private int quantity;

    public OnlineOrder()
    {

    }

    public OnlineOrder (String adress, String customerName, int dishId, int quantity)
    {
        this.setAdress(adress);
        this.setCustomerName(customerName);
        this.setDishId(dishId);
        this.setQuantity(quantity);
    }


    public Integer getOnlineOrderId() {
        return OnlineOrderId;
    }

    public String getAdress() {
        return adress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getDishId() {
        return dishId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return OnlineOrderId + ". " + adress + " " +  customerName + " " + dishId + " " + quantity;

    }
}
