package DaffaJmartRK;
import java.util.ArrayList;

class Filter
{
   public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, int value, boolean less){
       ArrayList<PriceTag> priceTag = new ArrayList<>();
       for(PriceTag filter : list){
           if(less & filter.getAdjustedPrice() < value || !less & filter.getAdjustedPrice() >= value){
               priceTag.add(filter);
           }
       }
       return priceTag;
   }
   public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less){
       for(int i = 0;i < list.size();i++){
           final ProductRating filter = list.get(i);
           if(less & filter.getAverage() < value || !less & filter.getAverage() >= value){
               list.remove(i);
           }
       }
   }
}
