package com.DaffaJmartRK;

import com.DaffaJmartRK.dbjson.Serializable;

public class Product extends Serializable
{
    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;
    
    
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans){
        this.accountId = accountId;
    	this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }
    public String toString(){
        return
        "Name: "+this.name+" \n"+
        "Weight: "+this.weight+" \n"+
        "conditionUsed: "+this.conditionUsed+" \n"+
        //"priceTag: "+this.priceTag+" \n"+
        "category: "+this.category+" \n";
        //"rating: "+this.rating+" \n"+
        //"storeId: "+this.storeId+" \n";
    }
}
