package com.DaffaJmartRK.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.DaffaJmartRK.Payment;
import com.DaffaJmartRK.dbjson.JsonTable;

@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{

	@Override
	public JsonTable<Payment> getJsonTable() {
		return null;
	}

}
