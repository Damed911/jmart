package DaffaJmartRK;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Complaint extends Recognizable implements FileParser
{
    public Date date;
    public String desc;
    
    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
        this.date = new Date();
    }
    @Override
    public boolean read(String content){
        return false;
    }
    public String toString(){
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
        String date = formattedDate.format(this.date);
        return "Complaint{date="+date+", desc='"+this.desc+"'}";
        
    }
}
