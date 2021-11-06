package DaffaJmartRK;

public class Product extends Serializable
{
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;
    
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed,
    PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration){
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.multiDuration = multiDuration;
    }
    public String toString(){
        return
        "Name: "+this.name+" \n"+
        "Weight: "+this.weight+" \n"+
        "conditionUsed: "+this.conditionUsed+" \n"+
        "priceTag: "+this.priceTag+" \n"+
        "category: "+this.category+" \n"+
        "rating: "+this.rating+" \n"+
        "storeId: "+this.storeId+" \n";
    }
}
