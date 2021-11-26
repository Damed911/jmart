package com.DaffaJmartRK;
import java.util.Date;

import com.DaffaJmartRK.dbjson.Serializable;

import java.util.ArrayList;

public abstract class Invoice extends Serializable
{
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public ArrayList<Record> history = new ArrayList<Record>();
    
    public enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED, DELIVERED;
    }
    public enum Rating{
        NONE, BAD, NEUTRAL, GOOD;
    }
    public class Record{
        public Status status;
        public Date date;
        public String message;
    }
    protected Invoice(int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = -1;
        this.date = new Date();
        this.rating = Rating.NONE;
    }
    public abstract double getTotalPay(Product product);
}