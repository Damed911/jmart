package com.DaffaJmartRK.controller;

import org.springframework.web.bind.annotation.*;

import com.DaffaJmartRK.ObjectPoolThread;
import com.DaffaJmartRK.Payment;
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
	@PostMapping("/{id}/accept")
	public @ResponseBody boolean accept(@RequestParam int id) {
		return false;
	}
	@PostMapping("/create")
	public @ResponseBody boolean create (@RequestParam int buyerId, @RequestParam int productId, @RequestParam int productCount, @RequestParam String shipmentAddress, @RequestParam byte shipmentPlan) {
		return false;
	}
	@PostMapping("/{id}/cancel")
	public @ResponseBody boolean cancel (int id) {
		return false;
	}
	@PostMapping("/{id}/submit")
	public @ResponseBody boolean submit (int id, String receipt) {
		return false;
	}
	private static boolean timeKeeper(Payment payment) {
		return false;
	}
}
