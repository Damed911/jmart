package DaffaJmartRK;

public class Jmart
{
    public static void main (String[] args){
        Jmart cetak = new Jmart();
    }
    public static Product createProduct(){
        Product product = new Product("Playstation 5", 8, false, new PriceTag(8000000), ProductCategory.GAMING);
        return product;
    }
    public static Coupon createCoupun(){
        return null;
    }
    public static ShipmentDuration createShipmentDuration(){
        return null;
    }
}
