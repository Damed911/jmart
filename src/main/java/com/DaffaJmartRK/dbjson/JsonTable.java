package com.DaffaJmartRK.dbjson;
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
		catch (FileNotFoundException e){}
    }
	public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException{
		JsonReader reader = new JsonReader(new FileReader(filepath));
		return gson.fromJson(reader, clazz);
	}
	public static void writeJson(Object object, String filepath) throws IOException{
		File file = new File(filepath);
		if(!file.exists()) {
			File parent = file.getParentFile();
			if(parent != null) {
				parent.mkdirs();
			}
			file.createNewFile();
		}
		final FileWriter writer = new FileWriter(filepath);
		writer.write(gson.toJson(object));
		writer.close();
	}
	public void writeJson() throws IOException{
		writeJson(this, this.filepath);
	}
}
