package com.DaffaJmartRK;

import java.util.ArrayList;
import java.util.Date;

/**
 * Model Class Payment
 * @author ASUS
 * @version Final
 */
public class Payment extends Invoice
{
    public ArrayList<Record> history = new ArrayList<Record>();
	public Shipment shipment;
    public int productCount;
    
    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    public static class Record{
    	public final Date date;
    	public String message;
    	public Status status;
    	
    	public Record(Status status, String message) {
    		this.status = status;
    		this.message = message;
    		this.date = new Date();
    	}
    }
    @Override
    public double getTotalPay(Product product){
        return 0.0;
    }
}
