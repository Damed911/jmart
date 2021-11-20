package com.DaffaJmartRK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.DaffaJmartRK.dbjson.Serializable;

public class Store extends Serializable
{
    public static String REGEX_PHONE = "^\\d{9, 12}$";
    public static String REGEX_NAME = "^[A,Z](?!.*(\\s)\1).{4,20}$";
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;

    public Store(String name, String address, String phoneNumber, double balance){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    public String toString(){
        return
        "name: "+this.name+" \n"+
        "address: "+this.address+" \n"+
        "phoneNumber: "+this.phoneNumber+" \n";
    }
    public boolean validate(){
       Pattern pattern = Pattern.compile(REGEX_NAME);
       Matcher matcher = pattern.matcher(name);
       Pattern pattern1 = Pattern.compile(REGEX_PHONE);
       Matcher matcher1 = pattern1.matcher(phoneNumber);
       return matcher.find() && matcher1.find();
    }
}
