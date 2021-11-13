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
    }
    public static void main(String[] args) {
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
    		String filepath = "C:/Java OOP/Praktikum OOP/jmart/json/Account.json";
    		
    		JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
    		tableAccount.add(new Account("name", "email", "password", 50000.0));
    		tableAccount.writeJson();
    		
    		tableAccount = new JsonTable<>(Account.class, filepath);
    		tableAccount.forEach(account -> System.out.println(account.toString()));
    	}
    	catch(Throwable t){
    		t.printStackTrace();
    	}
    }
    private static List<Product> paginate (List<Product> list, int page, int pageSize, 	Predicate<Product> pred){
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
    
}
