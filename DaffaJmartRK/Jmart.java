package DaffaJmartRK;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Jmart
{
    public static void main (String[] args){
        Jmart cetak = new Jmart();
        System.out.println(Shipment.Duration.REGULER.getEstimatedArrival(new Date()));
        Store store = new Store(1, "Muhammad Daffa Ajiputra", "Pasar Minggu", "087874898275");
        System.out.println(store.validate());
        
    }
    /*public static Product createProduct(){
        Product product = new Product("Playstation 5", 8, false, new PriceTag(8000000), ProductCategory.GAMING);
        return product;
    }
    public static Coupon createCoupun(){
        Coupon coupon = new Coupon("WIB", 10, Coupon.Type.DISCOUNT, 10, 25.00);
        return coupon;
    }
    public static ShipmentDuration createShipmentDuration(){
        return null;
    }*/
}
