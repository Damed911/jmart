package com.DaffaJmartRK.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import com.DaffaJmartRK.Account;
import com.DaffaJmartRK.Product;
import com.DaffaJmartRK.ProductCategory;
import com.DaffaJmartRK.dbjson.JsonAutowired;
import com.DaffaJmartRK.dbjson.JsonTable;

@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{
	
	@JsonAutowired(filepath = "C:/Users/ASUS/Documents/jmart/json/randomProductList.json", value = Product.class)
	public static JsonTable<Product> productTable;
	public JsonTable<Product> getJsonTable(){
		return productTable;
	}
	
	@GetMapping("/{id}/store")
	List<Product> getProductByStore(int id, int page, int pageSize){
		return null;
	}
	@PostMapping("/create")
	Product create(@RequestParam int accountId, @RequestParam String name, @RequestParam int weight, @RequestParam boolean conditionUsed, @RequestParam double price, 
			@RequestParam double discount, @RequestParam ProductCategory category, @RequestParam byte shipmentPlans) {
		Account temp = new AccountController().getById(accountId);
		if(temp != null && temp.store != null) {
			Product temporary = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
			productTable.add(temporary);
			return temporary;
		}
		return null;
	}
	@GetMapping("/getFiltered")
	List<Product> getProductFiltered(int page, int pageSize, int accountId, String search, int minPrice, int maxPrice, ProductCategory category){
		return null;
	}
}
