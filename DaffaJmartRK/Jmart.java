package DaffaJmartRK;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{
    public static void main (String[] args){
        
    }
    public static int getPromo(){
        return 0;
    }
    public static String getCustomer(){
        String exit = "oop";
        return exit;
    }
    public float getDiscountPercentage(int before,int after){
        return 0;
    }
    public int getDiscountPrice(int price,float discountPercentage){
        if(discountPercentage > 100.0){
            discountPercentage = 100;
        }
        float hargaBarang = price - (price*(discountPercentage/100));
        return price;
    }
    public int getOriginialPrice(int discountedPrice,float discountPercentage){
        return 0;
    }
    public float getCommissionMultiplier(){
        return (float)0.05;
    }
    public int getAdjustedPrice(int price){
        return 0;
    }
    public int getAdminFee(int price){
        return 0;
    }
}
