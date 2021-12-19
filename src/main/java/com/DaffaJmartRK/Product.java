package com.DaffaJmartRK;

import com.DaffaJmartRK.dbjson.Serializable;

/**
 * Class untuk mengatur semua product pada Jmart
 * @author M. Daffa Ajiputra
 * @version Final
 */
public class Product extends Serializable
{
	/**
	 * Instance Variable class Product
	 */
    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;
    
    /**
     * Constructor method class Product
     * @param accountId		id penjual
     * @param name			nama produk
     * @param weight		berat produk
     * @param conditionUsed	kondisi produk
     * @param price			harga produk
     * @param discount		diskon produk
     * @param category		kategori produk
     * @param shipmentPlans	tipe pengiriman
     */
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
    /**
     * Method untuk mengkonversi variable dalam kelas Product menjadi string
     */
    public String toString(){
    	return("Name: " + name + 
        		"\nWeight: " + weight +
        		"\nconditionUsed: " + conditionUsed +
               "\nprice: " + price +
               "\ncategory: " + category +
               "\ndiscount: " + discount +
               "\naccountId: " + accountId);
    }
}
