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
		
	}
	public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException{
		final JsonReader reader = new JsonReader(new FileReader(filepath));
		return gson.fromJson(reader, clazz);
	}
	public void writeJson() throws IOException{
		writeJson(this, this.filepath);
	}
	public static void writeJson(Object object, String filepath) throws IOException{
		try {
		final FileWriter writer = new FileWriter(filepath, true);
		writer.write(gson.toJson(object));
		writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
