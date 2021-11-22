package com.DaffaJmartRK.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.DaffaJmartRK.Coupon;
import com.DaffaJmartRK.Product;
import com.DaffaJmartRK.dbjson.JsonAutowired;
import com.DaffaJmartRK.dbjson.JsonTable;

@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
	
	@JsonAutowired(filepath = "C:/Users/ASUS/Documents/jmart/json/randomProductList.json", value = Coupon.class)
	public static JsonTable<Coupon> couponTable;
	
	public JsonTable<Coupon> getJsonTable(){
		return couponTable;
	}
	
	@GetMapping("/{id}/isUsed")
	boolean isUsed(int id) {
		return false;
	}
	@GetMapping("/{id}/canApply")
	boolean canApply(int id, double price, double discount) {
		return false;
	}
	@GetMapping("/getAvailable")
	List<Coupon> getAvailable(int page, int pageSize){
		return null;
	}
}
