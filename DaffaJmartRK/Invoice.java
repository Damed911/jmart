package DaffaJmartRK;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

abstract class Invoice extends Recognizable implements FileParser
{
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history = new ArrayList<Record>();
    
    public enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED;
    }
    public enum Rating{
        NONE, BAD, NEUTRAL, GOOD;
    }
    public class Record{
        public Status status;
        public Date date;
        public String message;
    }
    protected Invoice(int id, int buyerId, int productId){
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }
    @Override
    public boolean read(String content){
        return false;
    }
    public abstract double getTotalPay();
}