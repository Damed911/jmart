package DaffaJmartRK;

public class ProductRating
{
    private long total;
    private long count;

    public ProductRating(){
        total =  0;
        count = 0;
    }

    public void insert(int rating){
        this.total = total + rating;
        this.count++;
    }
    
    public double getAverage(){
        double average = total/count;
        if(count < 1){
            return 0.0;
        }
        return average;
    }
    
    public long getCount(){
        return count;
    }
    
    public long getTotal(){
        return total;
    }
}
