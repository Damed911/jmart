package com.DaffaJmartRK.controller;

import org.springframework.web.bind.annotation.*;

import com.DaffaJmartRK.Account;
import com.DaffaJmartRK.Invoice;
import com.DaffaJmartRK.ObjectPoolThread;
import com.DaffaJmartRK.Payment;
import com.DaffaJmartRK.Product;
import com.DaffaJmartRK.Shipment;
import com.DaffaJmartRK.dbjson.JsonAutowired;
import com.DaffaJmartRK.dbjson.JsonTable;

@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
	public static final long DELIVERED_LIMIT_MS = 3000;
	public static final long ON_DELIVERY_LIMIT_MS = 3000;
	public static final long ON_PROGRESS_LIMIT_MS = 3000;
	public static final long WAITING_CONF_LIMIT_MS = 3000;
	
	@JsonAutowired(filepath = "C:/Users/ASUS/Documents/jmart/json/Payment.json", value = Payment.class)
	public static JsonTable<Payment> paymentTable;
	public static ObjectPoolThread<Payment> poolThread;
	@Override
	public JsonTable<Payment> getJsonTable() {
		return paymentTable;
	}
	@PostMapping("/create")
    public Payment create(@RequestParam int buyerId, @RequestParam int productId, @RequestParam int productCount, @RequestParam String shipmentAddress, @RequestParam byte shipmentPlan) {
    	Account account = new AccountController().getById(buyerId);
    	Product product = new ProductController().getById(productId);
    	Shipment shipment = new Shipment(shipmentAddress, 0, shipmentPlan, null);
    	Payment payment = new Payment(buyerId, productId, productCount, shipment);
    	double totalPay = payment.getTotalPay(product);
    	if(account.balance > totalPay) {
    		account.balance -= totalPay;
    		Payment.Record record = new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "Pesan");
    		payment.history.add(record);
    		paymentTable.add(payment);
    		poolThread.add(payment);
    		return payment;
    	}
    	return null;
    }
	
	@PostMapping("/{id}/accept")
	public boolean accept(@RequestParam int id) {
		Payment payment = new PaymentController().getById(id);
		if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION) {
			Payment.Record record = new Payment.Record(Invoice.Status.ON_PROGRESS, "Pesan");
			payment.history.add(record);
			return true;
		}
		return false;
	}
	
	@PostMapping("/{id}/cancel")
	public boolean cancel(@RequestParam int id) {
		Payment payment = new PaymentController().getById(id);
		if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION) {
			Payment.Record record = new Payment.Record(Invoice.Status.CANCELLED, "Pesan");
			payment.history.add(record);
			return true;
		}
		return false;
	}
	
	@PostMapping("/{id}/submit")
	public boolean submit(@RequestParam int id, @RequestParam String receipt) {
		Payment payment = new PaymentController().getById(id);
		if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.ON_PROGRESS && payment.shipment.receipt.isBlank() == false) {
			payment.shipment.receipt = receipt;
			Payment.Record record = new Payment.Record(Invoice.Status.ON_DELIVERY, "Pesan");
			payment.history.add(record);
			return true;
		}
		return false;
	}
	
	private static boolean timekeeper(Payment payment) {
		return false;
	}
}
