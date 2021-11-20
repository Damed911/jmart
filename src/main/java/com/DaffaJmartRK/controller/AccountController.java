package com.DaffaJmartRK.controller;
import com.DaffaJmartRK.Account;
import com.DaffaJmartRK.Store;
import com.DaffaJmartRK.dbjson.JsonAutowired;
import com.DaffaJmartRK.dbjson.JsonTable;

import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	public static final String REGEX_EMAIL = "^[a-zA-Z0-9&*_~]+(\\.[a-zA-Z0-9&*_~]+)*@[a-zA-Z0-9][a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = null;
	public static final Pattern REGEX_PATTERN_PASSWORD = null;
	@JsonAutowired(filepath = "C:/Users/ASUS/Documents/jmart/json/Account.json", value = Account.class)
	public static JsonTable<Account> accountTable;
	
	public JsonTable<Account> getJsonTable(){
		return accountTable;
	}
	
	@PostMapping("/login")
	public Account login (@RequestParam String email, @RequestParam String password) {
		for(Account account : accountTable) {
			if(account.email == email && account.password == password) {
				return account;
			}
		}
		return null;
	}
	
	@PostMapping("/register")
	public Account register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
		return null;
	}
	
	@PostMapping("/{id}/topUp")
	public Store registerStore (@RequestParam int id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber) {
		return null;
	}
}