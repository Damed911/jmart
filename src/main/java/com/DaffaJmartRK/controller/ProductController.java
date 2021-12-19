package com.DaffaJmartRK.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import com.DaffaJmartRK.Account;
import com.DaffaJmartRK.Algorithm;
import com.DaffaJmartRK.Predicate;
import com.DaffaJmartRK.Product;
import com.DaffaJmartRK.ProductCategory;
import com.DaffaJmartRK.dbjson.JsonAutowired;
import com.DaffaJmartRK.dbjson.JsonTable;

/**
 * Class untuk melakukan pengaturan pada tiap produk yang ada pada Jmart
 * @author M. Daffa Ajiputra
 * @version Final
 */
@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{
	/**
	 * instance variable class ProductController
	 */
	@JsonAutowired(filepath = "C:\\Users\\ASUS\\Documents\\jmart\\json\\randomProductList.json", value = Product.class)
	public static JsonTable<Product> productTable;
	public JsonTable<Product> getJsonTable(){
		return productTable;
	}
	/**
     * Method untuk mendapatkan product berdasarkan store
     * @param id		store id
     * @param page		nomor page
     * @param pageSize	ukuran page
     * @return filteredByStore
     */
	@GetMapping("/{id}/store")
	List<Product> getProductByStore(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize){
		return Algorithm.<Product>paginate(getJsonTable(),page,pageSize, p -> (p.accountId == id));
	}
	/**
	 * Method untuk membuat sebuah product baru pada jmart
	 * @param accountId		user account id
	 * @param name			nama product
	 * @param weight		berat product
	 * @param conditionUsed	kondisi product
	 * @param price			harga product
	 * @param discount		discount product
	 * @param category		kategori product
	 * @param shipmentPlans	jenis pengiriman
	 * @return newProduct
	 */
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
	/**
     * Method untuk mendapatkan product berdasarkan paramater tertentu
     * @param page		nomor page
     * @param pageSize	ukuran page
     * @param accountId	user account id
     * @param search	search name
     * @param minPrice	harga minimal
     * @param maxPrice	harga maksimal
     * @param category	kategori
     * @return filteredByParameter
     */
	@GetMapping("/getFiltered")
	List<Product> getProductFiltered(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "0") int accountId, @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int minPrice, @RequestParam(defaultValue = "0") int maxPrice, @RequestParam(defaultValue = "") ProductCategory category){
		Predicate<Product> pred = p -> ((p.accountId == accountId) && (p.name.toLowerCase().contains(search.toLowerCase())) && (p.price >= minPrice && p.price <= maxPrice) && (p.category == category));
        return Algorithm.<Product>paginate(getJsonTable(),page,pageSize, pred);
	}
}
