package com.DaffaJmartRK.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.DaffaJmartRK.Algorithm;
import com.DaffaJmartRK.dbjson.JsonTable;
import com.DaffaJmartRK.dbjson.Serializable;

/**
 * Class BasicGetController untuk mendapatkan beberapa paramater basic
 * @author M. Daffa Ajiputra
 * @version Final
 * @param <T>
 */
public interface BasicGetController<T extends Serializable> {
	/**
	 * method untuk mengambil page dari class algorithm
	 * @param page
	 * @param pageSize
	 * @return paginate
	 */
	@GetMapping("/page")
	default @ResponseBody List<T> getPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue="10")int pageSize) {
		return Algorithm.<T>paginate(getJsonTable(), page, pageSize, e -> true);
	}
	/**
	 * Abstract method untuk mengambil JsonTable
	 * @return JsonTable
	 */
	public abstract JsonTable<T> getJsonTable();
	/**
	 * Method untuk mendapatkan informasi user dengan id nya
	 * @param id
	 * @return userId
	 */
	@GetMapping("/{id}")
	default T getById (int id) {
		return Algorithm.<T>find(getJsonTable(), (e) -> e.id == id);
	}
}
