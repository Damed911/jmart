package com.DaffaJmartRK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.DaffaJmartRK.dbjson.Serializable;

/**
 * Class untuk melakukan pembuatan akun pada Jmart
 * @author M. Daffa Ajiputra
 * @version Final
 */
public class Account extends Serializable
{
		
		public static final String REGEX_EMAIL = "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
	    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
	    public double balance;
	    public String name;
	    public String email;
	    public String password;
	    public Store store;
	    
	    /**
	     * Constructor untuk Account Class
	     * 
	     * @param name     	name of the Account
	     * @param email    	email of the Account
	     * @param password 	password of the Account
	     * @param balance	balance of the Account
	     */
	    public Account(String name, String email, String password, double balance){
	        this.name = name;
	        this.email = email;
	        this.password = password;
	        this.balance = balance;
	    }
	    
	    /**
	     * Method untuk memvalidasi email dan password sudah ada dalam database atau belum
	     * 
	     * @return true		apabila email dan password sudah ada
	     */
	    public boolean validate(){
	        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
	        Pattern patternPass = Pattern.compile(REGEX_PASSWORD);
	        Matcher mEmail = patternEmail.matcher(email);
	        Matcher mPass = patternPass.matcher(password);
	        if(mEmail.find() && mPass.find()){
	            return true;
	        }else{
	            return false;
	        }
	    }
	    
	    /**
	     * Method untuk menyamakan id yang diinputkan dengan account id tertentu
	     * @param acc objek account
	     * @return condition
	     */
	    public boolean idEquals(Account acc) {
	        return (this.id == acc.id);
	    }
	    
	    /**
	     * Method untuk mengubah seluruh variable menjadi string
	     * @return string of all variable
	     */
	    @Override
	    public String toString(){
	        return ("name: " + name + "\nemail: " + email + "\npassword: " + password);
	    }
}
