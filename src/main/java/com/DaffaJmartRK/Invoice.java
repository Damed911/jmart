package com.DaffaJmartRK;

import java.util.Date;

import com.DaffaJmartRK.dbjson.Serializable;

/**
 * Class untuk mengatur invoice pada Jmart
 * @author M. Daffa Ajiputra
 * @version Final
 */
public abstract class Invoice extends Serializable
{
	/**
	 * Instance Variable class Invoice
	 */
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    /**
     * Enum Class Status invoice
     * @author M. Daffa Ajiputra
     * @version Final
     */
    public enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED, DELIVERED;
    }
    /**
     * Enum Class Rating Product
     * @author M. Daffa Ajiputra
     * @version Final
     */
    public enum Rating{
        NONE, BAD, NEUTRAL, GOOD;
    }
    /**
     * Constructor method class Invoice
     * @param buyerId		id pembeli
     * @param productId		id produk
     */
    protected Invoice(int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = -1;
        this.date = new Date();
        this.rating = Rating.NONE;
    }
    /**
     * Abstact class getTotalPay
     * @param product	product object
     * @return nothing
     */
    public abstract double getTotalPay(Product product);
}