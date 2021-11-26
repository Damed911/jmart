package com.DaffaJmartRK.controller;
import com.DaffaJmartRK.Account;
import com.DaffaJmartRK.Store;
import com.DaffaJmartRK.dbjson.JsonAutowired;
import com.DaffaJmartRK.dbjson.JsonTable;
import java.security.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	public static final String REGEX_EMAIL = "^[a-zA-Z0-9&*_~]+(\\.[a-zA-Z0-9&*_~]+)*@[a-zA-Z0-9][a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
	@JsonAutowired(filepath = "C:/Users/ASUS/Documents/jmart/json/Account.json", value = Account.class)
	public static JsonTable<Account> accountTable;
	
	public JsonTable<Account> getJsonTable(){
		return accountTable;
	}
	
	@PostMapping("/login")
	public Account login (@RequestParam String email, @RequestParam String password) {
		String generatePassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bytes.length;i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatePassword = sb.toString();
			for(Account account : accountTable) {
				if(account.email == email && generatePassword == password) {
					return account;
				}
			}
		}
		catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/register")
	public Account register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
		String generatePassword = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bytes.length;i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatePassword = sb.toString();
			
			Matcher matchEmail = REGEX_PATTERN_EMAIL.matcher(email);
			Matcher matchPassword = REGEX_PATTERN_PASSWORD.matcher(password);
			if(!name.isBlank() && matchEmail.find() && matchPassword.find()){
				return new Account(name, email, generatePassword, 0);
        	}
		}
		catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/{id}/registerStore")
	public Store registerStore (@RequestParam int id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber) {
		return null;
	}
	@PostMapping("/{id}/topUp")
	public boolean topUp (int id, double balance) {
		for(Account temp : accountTable) {
			if(temp.id == id) temp.balance = balance;
			return true;
			}
		return false;
		}
}