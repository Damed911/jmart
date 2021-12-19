package com.DaffaJmartRK.controller;
import com.DaffaJmartRK.Account;
import com.DaffaJmartRK.Algorithm;
import com.DaffaJmartRK.Store;
import com.DaffaJmartRK.dbjson.JsonAutowired;
import com.DaffaJmartRK.dbjson.JsonTable;
import java.security.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;


/**
 * Model Class AccountController
 * @author ASUS
 * @version Final
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	/**
	 * Instance variable untuk AccountController
	 */
	public static @JsonAutowired(value=Account.class, filepath="C:\\Users\\ASUS\\Documents\\jmart\\json\\Account.json") JsonTable<Account> accountTable;
	public static final String REGEX_EMAIL = "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
	public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

	/**
	 * Method untuk mendapatkan account table
	 */
	public JsonTable<Account> getJsonTable(){
        return accountTable;
    }

	/**
	 * Method mapping untuk user agar bisa login
	 * @param email		user email
	 * @param password	user password
	 * @return account
	 */
	@PostMapping("/login")
	public Account login (@RequestParam String email, @RequestParam String password) {
		for(Account account : accountTable) {
			try{
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] bytes = md.digest();
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < bytes.length; i++){
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                if(account.email.equals(email) && account.password.equals(sb.toString())){ //Compare hash in string with equals
                    return account;
                }
            } catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }
		}
		return null;
	}

	/**
	 * Method mapping agar user dapat register ke program jmart
	 * @param name		nama user
	 * @param email		email user
	 * @param password	password user
	 * @return	newAccount
	 */
	@PostMapping("/register")
	Account register
	(
		  @RequestParam String name,
		  @RequestParam String email,
		  @RequestParam String password
	)
	{
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
				getJsonTable().add(new Account(name, email, generatePassword, 0));
				return new Account(name, email, generatePassword, 0);
        	}
		}
		catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return null;
	}

    /**
     * Method controller untuk user dapat membuat store baru
     * @param id			id user
     * @param name			nama user
     * @param address		alamat user
     * @param phoneNumber	nomor telepon user
     * @return newStore
     */
	@PostMapping("/{id}/registerStore")
    Store registerStore(@PathVariable int id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber){
		for (Account temp : accountTable){
            if(temp.id == id && (temp.store == null)){
                temp.store = new Store(name, address, phoneNumber, 0);
                return temp.store;
            }
        }
        return null;
    }

    /**
     * Method controller agar user dapat topUp ke Jmart
     * @param id		id user
     * @param balance	balance user
     * @return
     */
	@PostMapping("/{id}/topUp")
    boolean topUp(@RequestParam int id, @RequestParam double balance){
		for(Account temp : accountTable) {
			if(temp.id == id) {
				temp.balance += balance;
				return true;
			}
		}
		return false;
	}
 }