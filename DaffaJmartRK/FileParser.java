package DaffaJmartRK;

public abstract interface FileParser
{
    public boolean read(String content);
    default Object write(){
       return null; 
    }
    public static Object newInstance(String content){
        return null;
    }
}
