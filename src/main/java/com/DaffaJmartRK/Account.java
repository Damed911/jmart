package com.DaffaJmartRK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable
{
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&*_~]+(\\.[a-zA-Z0-9&*_~]+)*@[a-zA-Z0-9][a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public double balance;
    public String name;
    public String email;
    public String password;
    public Store store;
    
    public Account(String name, String email, String password, double balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    public String toString(){
        return
        "name: "+this.name+"\n"+
        "email: "+this.email+"\n"+
        "password: "+this.password;
    }
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(this.email);
        Pattern pattern1 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher1 = pattern.matcher(this.password);
        if(matcher.find() && matcher1.find() == true){
            return true;
        }
        return false;
    }
}
