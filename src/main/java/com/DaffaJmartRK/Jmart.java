package com.DaffaJmartRK;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class Jmart
{
    /*public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize){
    	Predicate<Product> predicate = (temp -> (temp.accountId == accountId));
    	return paginate(list, page, pageSize, predicate);
    }
    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
    	List<Product> filtered = new ArrayList<>();
    	for(Product product : list) {
    		if(product.category.equals(category)) filtered.add(product);
    	}
    	return filtered;
    }
    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize){
    	Predicate<Product> predicate = (tmp -> (tmp.name.toLowerCase().contains(search.toLowerCase())));
        return paginate(list, page, pageSize, predicate);
    }
    public static List<Product> filterByPrice(List<Product> list, double MinPrice, double MaxPrice){
    	List<Product> filtered = new ArrayList<>();
    	for(int i = 0; i < list.size(); i++){
            if(MinPrice <= 0.0){
                if(list.get(i).price <= MaxPrice){
                    filtered.add(list.get(i));
                }
            }
            else if(MaxPrice <= 0.0){
                if(list.get(i).price >= MinPrice){
                    filtered.add(list.get(i));
                }
            }
            else{
                if(list.get(i).price >= MinPrice && list.get(i).price <= MaxPrice){
                    filtered.add(list.get(i));
                }
            }
        }
        return filtered;
    }*/
	public static long DELIVERED_LIMIT_MS = 5000;
	public static long ON_DELIVERY_LIMIT_MS = 5000;
	public static long ON_PROGRESS_LIMIT_MS = 5000;
	public static long WAITING_CONF_LIMIT_MS = 5000;
	
    public static void main(String[] args) {
    	//SpringApplication.run(Jmart.class, args);
    	
    	/*System.out.println("account id:" + new Account(null, null, null, -1).id);
    	System.out.println("account id:" + new Account(null, null, null, -1).id);
    	System.out.println("account id:" + new Account(null, null, null, -1).id);
    	
    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);*/
    	
    	try {
    		/*List<Product> list = read("/Java OOP/Praktikum OOP/jmart/json/randomProductList.json");
    		
    		List<Product> filtered = filterByPrice(list, 0.0, 20000.0);
    		filtered.forEach(product -> System.out.println(product.price));
    		List<Product> filteredByName = filterByName(list, "gtx", 1, 5);
    		filteredByName.forEach(product -> System.out.println(product.name));
    		List<Product> filteredByAccountId = filterByAccountId(list, 1, 0, 5);
    		filteredByAccountId.forEach(product -> System.out.println(product.name));*/
    		
    		JsonTable<Payment> table = new JsonTable<>(Payment.class, "C:/Users/ASUS/Documents/jmart/json/randomPaymentList.json");
    		/*ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
    		paymentPool.start();
    		table.forEach(payment -> paymentPool.add(payment));
    		while(paymentPool.size() != 0);
    			paymentPool.exit();
    		while(paymentPool.isAlive());
    			System.out.println("Thread exited successfully");
    		Gson gson = new Gson();
    		table.forEach(payment ->{
    			String history = gson.toJson(payment.history);
    			System.out.println(history);
    		});*/
    		/*tableAccount.add(new Account("name", "email", "password", 50000.0));
    		tableAccount.writeJson();
    		
    		tableAccount = new JsonTable<>(Account.class, filepath);
    		tableAccount.forEach(account -> System.out.println(account.toString()));*/
    	}
    	catch(Throwable t){
    		t.printStackTrace();
    	}
    	
    }
    public static boolean paymentTimeKeeper(Payment payment) {
    	final ArrayList<Payment.Record> history = payment.history;
    	Date timeNow = Calendar.getInstance().getTime();
        return false;
    }
    /*private static List<Product> paginate (List<Product> list, int page, int pageSize, 	Predicate<Product> pred){
    	if(pageSize < 0 || page < 0) throw new IllegalArgumentException("Invalid Page Size: " + pageSize);
    	return list.stream().filter(tmp -> pred.predicate(tmp)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    	
    }
    public static List<Product> read(String filepath) throws FileNotFoundException, IOException{
    	List<Product> product = new ArrayList<>();
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(filepath));
		reader.beginArray();
		while(reader.hasNext()) {
			product.add(gson.fromJson(reader, Product.class));
			}
    	return product;
    }
    */
}
