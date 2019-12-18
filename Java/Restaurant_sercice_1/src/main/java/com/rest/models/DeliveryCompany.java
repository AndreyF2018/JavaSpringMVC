package com.rest.models;
import javax.persistence.*;

@Entity
@Table(name = "deliverycompanies")
public class DeliveryCompany
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer DeliveryCompanyId;

    @Column(name = "DeliveryCompanyName")
    private String deliveryCompanyName;


    @Column(name = "PricePercent")
    private int pricePercent;

    public DeliveryCompany()
    {

    }
    public Integer getId()
    {
        return DeliveryCompanyId;
    }


    public String getDeliveryСompanyName()
    {
        return deliveryCompanyName;

    }

    public void setCompanyName(String companyName)
    {
        this.deliveryCompanyName = companyName;
    }

    public int getPricePercent()
    {
        return pricePercent;
    }

    public void setPricePercent(int price)
    {
        this.pricePercent = price;
    }

    @Override
    public String toString()
    {
        return DeliveryCompanyId + ". " + deliveryCompanyName + " " +  pricePercent;
    }

    public DeliveryCompany(String name, int price)
    {

        this.setCompanyName(name);
        this.setPricePercent(price);
    }
}