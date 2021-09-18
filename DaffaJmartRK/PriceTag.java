package DaffaJmartRK;

public class PriceTag
{
    public static final double COMMISION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;
    
    public PriceTag(double price){
        this.price = price;
        discount = 0.0f;
    }

    public PriceTag(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
    
    public double getAdjustedPrice(){
        return getDiscountedPrice() + getAdminFee();
    }
    
    public double getAdminFee(){
        if(getDiscountedPrice() < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }
        else{
            return (getDiscountedPrice() - (getDiscountedPrice() * COMMISION_MULTIPLIER));
        }
    }
    
    private double getDiscountedPrice(){
        if(discount >= 100.0){
            return 0.0;
        }
        else{
            return (price * (discount/100.0));
        }
    }
}
