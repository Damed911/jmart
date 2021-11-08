package DaffaJmartRK;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

class Jmart
{
    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize){
    	Predicate<Product> predicate = (temp -> (temp.accountId == accountId));
    	return paginate(list, page, pageSize, predicate);
    }
    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
    	return null;
    }
    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize){
    	Predicate<Product> predicate = (tmp -> (tmp.name.toLowerCase().contains(search.toLowerCase())));
        return paginate(list, page, pageSize, predicate);
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
    private static List<Product> paginate (List<Product> list, int page, int pageSize, 	Predicate<Product> pred){
    	if(pageSize <= 0 || page <= 0) throw new IllegalArgumentException("Invalid Page Size: " + pageSize);
    	
    	int index = (page - 1) * pageSize;
    	if(list == null || list.size() <= index){
    		return Collections.emptyList();
    	}
    	return list.stream().filter(temp -> pred.predicate(temp)).skip(index).limit(pageSize).collect(Collectors.toList());
    	
    }
    public static List<Product> read(String filepath){
    	List<Product> product = new ArrayList<>();
    	try {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(filepath));
		reader.beginArray();
		while(reader.hasNext()) {
			product.add(gson.fromJson(reader, Product.class));
			}
    	}
    	catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	return product;
    }
    
}
