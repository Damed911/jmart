package DaffaJmartRK;
import java.io.*;
import java.util.Vector;
import java.util.Collections;
import java.lang.reflect.Array;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JsonTable<T> extends Vector<T>{
	public final String filepath;
	private static final Gson gson = new Gson();
	
	public JsonTable(Class<T> clazz, String filepath) throws IOException{
		this.filepath = filepath;
		try {
			@SuppressWarnings("unchecked")
			Class<T[]> array = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
			T[] loaded = readJson(array, filepath);
			if(loaded != null)
	          {
	             Collections.addAll(this, loaded);
	          }
		}
		catch (FileNotFoundException e)
        {
            File f = new File(filepath);
            File f1 =  f.getParentFile();
            if(f1 != null)
            {
                f1.mkdirs();
            }
            f.createNewFile();
        }
    }
	public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException{
		JsonReader reader = new JsonReader(new FileReader(filepath));
		return gson.fromJson(reader, clazz);
	}
	public static void writeJson(Object object, String filepath) throws IOException{
		FileWriter writer = new FileWriter(filepath);
		String text = gson.toJson(object);
		writer.write(text);
		writer.close();
	}
	public void writeJson() throws IOException{
		writeJson(this, this.filepath);
	}
}
