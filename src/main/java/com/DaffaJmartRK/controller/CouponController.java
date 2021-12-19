package com.DaffaJmartRK.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.DaffaJmartRK.Algorithm;
import com.DaffaJmartRK.Coupon;
import com.DaffaJmartRK.Predicate;
import com.DaffaJmartRK.dbjson.JsonAutowired;
import com.DaffaJmartRK.dbjson.JsonTable;

/**
 * Class untuk melakukan pengaturan pada tiap kupon yang dimiliki user ketika digunakan
 * @author M. Daffa Ajiputra
 * @version Final
 *
 */
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
	/**
	 * Instance variable untuk class coupon controller
	 */
	@JsonAutowired(filepath = "C:/Users/ASUS/Documents/jmart/json/coupon.json", value = Coupon.class)
	public static JsonTable<Coupon> couponTable;
	/**
     * Method untuk mendapatkan couponTable
     */
	public JsonTable<Coupon> getJsonTable(){
		return couponTable;
	}
	/**
     * Method untuk menentukan apakah coupon sudah digunakan atau belum
     * @param id	coupon id
     * @return condition
     */
	@GetMapping("/{id}/isUsed")
	boolean isUsed(@RequestParam int id) {
		for(Coupon coupon : couponTable) {
			if(coupon.id == id)
				return coupon.isUsed();
		}
		return false;
	}
	/**
 	 * Method untuk menentukan apakah coupon dapat digunakan atau tidak
 	 * @param id		coupon id
 	 * @param price		product price
 	 * @param discount	discount price
 	 * @return condition
 	 */
	@GetMapping("/{id}/canApply")
	boolean canApply(@PathVariable int id, @PathVariable double price, @PathVariable double discount) {
		for(Coupon coupon : couponTable){
            if(coupon.id == id){
                return coupon.canApply(price, discount);
            }
        }
     return false;
	}
	/**
     * Method untuk memvalidasi apakah coupon ada atau tidak
     * @param page		page number
     * @param pageSize	ukuran page
     * @return coupon list
     */
	@GetMapping("/getAvailable")
	List<Coupon> getAvailable(int page, int pageSize){
		Predicate<Coupon> pred = coupon -> !coupon.isUsed();
        return Algorithm.paginate(couponTable, page, pageSize, pred);
	}
}
