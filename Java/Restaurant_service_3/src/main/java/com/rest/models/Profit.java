package com.rest.models;

import javax.persistence.*;

@Entity
@Table(name = "profit")
public class Profit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profitId;

    @Column(name = "OrderId")
    private int orderId;


    @Column(name = "OredrCost")
    private float oredrCost;

    @Column(name = "PercentDeliveries")
    private int percentDeliveries;

    @Column(name = "NetProfit")
    private float netProfit;

    public Profit(int orderId) {
        this.setOrderId(orderId);
    }

    public Profit(int orderId, float oredrCost, int percentDeliveries, float netProfit)
    {
        this.setOrderId(orderId);
        this.setOredrCost(oredrCost);
        this.setPercentDeliveries(percentDeliveries);
        this.setNetProfit(netProfit);
    }

    public Profit() {}


    public Integer getProfitId() {
        return profitId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getOredrCost() {
        return oredrCost;
    }

    public void setOredrCost(float oredrCost) {
        this.oredrCost = oredrCost;
    }

    public int getPercentDeliveries() {
        return percentDeliveries;
    }

    public void setPercentDeliveries(int percentDeliveries) {
        this.percentDeliveries = percentDeliveries;
    }

    public float getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(float netProfit) {
        this.netProfit = netProfit;
    }

    @Override
    public String toString()
    {
        return profitId + ". " + orderId + " " +  oredrCost + " " + percentDeliveries + " " + netProfit;
    }
}
