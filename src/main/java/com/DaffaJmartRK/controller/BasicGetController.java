package com.DaffaJmartRK.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.DaffaJmartRK.Algorithm;
import com.DaffaJmartRK.dbjson.JsonTable;
import com.DaffaJmartRK.dbjson.Serializable;


public interface BasicGetController<T extends Serializable> {
	@GetMapping("/page")
	public @ResponseBody default List<T> getPage(int page, int pageSize) {
		return Algorithm.<T>paginate(getJsonTable(), page, pageSize, e -> true);
	}
	public abstract JsonTable<T> getJsonTable();
	@GetMapping("/{id}")
	public @ResponseBody default T getById (int id) {
		return Algorithm.<T>find(getJsonTable(), (e) -> e.id == id);
	}
}
