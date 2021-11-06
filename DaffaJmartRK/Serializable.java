package DaffaJmartRK;

import java.util.HashMap;
import java.util.Map;

public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static Map<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();
    
    protected Serializable(){
        Class<?> GetC = getClass();
        if(mapCounter.get(GetC) == null) mapCounter.put(GetC, 0);
        else{
        	mapCounter.put(GetC, mapCounter.get(GetC) + 1);
        }
        this.id = mapCounter.get(GetC);
    }
    public static <T extends Serializable> int setClosingId(Class<T> clazz, int id) {
    	return mapCounter.put(clazz, id);
    }
    public static <T extends Serializable> int getClosingId(Class<T> clazz) {
    	return mapCounter.get(clazz);
    }
    public boolean equals (Object other){
        if(other instanceof Serializable){
            Serializable recognize = (Serializable) other;
            if(this.id == recognize.id){
                return true;
            }
        }
        return false;
    }
    public boolean equals (Serializable other){
        if(other.id == this.id){
            return true;
        }
        return false;
    }
    @Override
    public int compareTo(Serializable other) {
    	if(this.id == other.id) return 0;
    	if(this.id < other.id) return -1;
    	return 1;
    }
}
