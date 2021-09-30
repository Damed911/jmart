package DaffaJmartRK;

public class Complaint extends Recognizable implements FileParser
{
    public String date;
    public String desc;
    
    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
        this.date = "27-09-2021";
    }
    @Override
    public boolean read(String content){
        return false;
    }
}
