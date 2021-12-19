package com.DaffaJmartRK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.DaffaJmartRK.dbjson.Serializable;

/**
 * Class untuk mengatur segala hal berkaitan dengan store pada Jmart
 * @author M. Daffa Ajiputra
 * @version Final
 */
public class Store extends Serializable
{
	/**
	 * Instance Variable class Store
	 */
    public static String REGEX_PHONE = "^\\d{9, 12}$";
    public static String REGEX_NAME = "^[A,Z](?!.*(\\s)\1).{4,20}$";
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;
    /**
     * Constructor Method class store
     * @param name			nama toko
     * @param address		alamat toko
     * @param phoneNumber	telepon toko
     * @param balance		saldo toko
     */
    public Store(String name, String address, String phoneNumber, double balance){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    /**
     *Method untuk mengkonversi variable dalam kelas Store menjadi string
     */
    public String toString(){
        return
        "name: "+this.name+" \n"+
        "address: "+this.address+" \n"+
        "phoneNumber: "+this.phoneNumber+" \n";
    }
    /**
     * Method untuk memvalidasi data store
     * @return condition
     */
    public boolean validate(){
       Pattern pattern = Pattern.compile(REGEX_NAME);
       Matcher matcher = pattern.matcher(name);
       Pattern pattern1 = Pattern.compile(REGEX_PHONE);
       Matcher matcher1 = pattern1.matcher(phoneNumber);
       return matcher.find() && matcher1.find();
    }
}
