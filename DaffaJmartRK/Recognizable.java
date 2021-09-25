package DaffaJmartRK;

public class Recognizable
{
    public final int id;
    
    protected Recognizable(int id){
        this.id = id;
    }
    public boolean equals (Object object){
        if(object instanceof Recognizable){
            Recognizable recognize = (Recognizable) object;
            if(this.id == recognize.id){
                return true;
            }
        }
        return false;
    }
    public boolean equals (Recognizable recognizable){
        if(recognizable.id == this.id){
            return true;
        }
        return false;
    }
}
