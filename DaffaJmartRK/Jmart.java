package DaffaJmartRK;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.print.attribute.standard.Chromaticity;
import com.google.gson.*;

class Jmart
{
    public static List<Product> read(String filepath) throws FileNotFoundException{
		filepath = "/Java OOP/Praktikum OOP/jmart/json/randomProductList.json";
		Gson gson = new Gson();
		List<Product> product = new ArrayList<>();
		product = (List<Product>) gson.fromJson(filepath, Product.class);
		return product;
		
    }
    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
    	return null;
    }
    public static List<Product> filterByPrice(List<Product> list, double MinPrice, double MaxPrice){
    	return null;
    }
    public static void main(String[] args) {
    	/*System.out.println("account id:" + new Account(null, null, null, -1).id);
    	System.out.println("account id:" + new Account(null, null, null, -1).id);
    	System.out.println("account id:" + new Account(null, null, null, -1).id);
    	
    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
    	System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);*/
    	
    	try {
    		List<Product> list = read("/Java OOP/Praktikum OOP/jmart/json/randomProductList.json");
    		List<Product> filtered = filterByPrice(list, 0.0, 20000.0);
    		filtered.forEach(product -> System.out.println(product.price));
    	}
    	catch(Throwable t){
    		t.printStackTrace();
    	}
    }
}
