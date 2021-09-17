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
        Jmart cetak = new Jmart();
        System.out.println(cetak.getPromo());
        System.out.println(cetak.getCustomer());
        System.out.println(cetak.getDiscountPercentage(1000, 500));
        System.out.println(cetak.getDiscountPrice(1000, 10.0f));
        System.out.println(cetak.getOriginalPrice(900, 10.0f));
        System.out.println(cetak.getCommissionMultiplier());
        System.out.println(cetak.getAdjustedPrice(1000));
        System.out.println(cetak.getAdminFee(1000));
    }
    public static int getPromo(){
        return 0;
    }
    public static String getCustomer(){
        String exit = "oop";
        return exit;
    }
    public static float getDiscountPercentage(int before,int after){
        float discount;
        discount = 100 * ((float) (before - after)/(float)before);
        if(before < after){
            return 0.0f;
        }
        return discount;
    }
    public int getDiscountPrice(int price,float discountPercentage){
        if(discountPercentage > 100.0){
            discountPercentage = 100.0f;
        }
        float hargaBarang = (int) ((price * (100.0f - discountPercentage)/ 100.0f));
        return (int)hargaBarang;
    }
    public int getOriginalPrice(int discountedPrice,float discountPercentage){
        float hargaAwal = (int) ((discountedPrice * 100.0f) / (100.0f - discountPercentage));
        return (int)hargaAwal;
    }
    public float getCommissionMultiplier(){
        return (float)0.05;
    }
    public int getAdjustedPrice(int price){
        float commision = getCommissionMultiplier();
        price = (price + (int) (commision * (float) price));
        return price;
    }
    public int getAdminFee(int price){
        float admin = getCommissionMultiplier();
        float fee = admin * (int) price;
        return (int) fee;
    }
}
