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
        System.out.println(cetak.create());
    }
    public static Product create(){
     Product product = new Product("Playstation 5", 5, false, new PriceTag(12000000), ProductCategory.GAMING);
     return product;
    }
}
