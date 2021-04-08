package locomanage.alicen.zschokke.json;

import java.util.HashMap;
import java.util.StringJoiner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import locomanage.alicen.zschokke.entities.JSONable;

/**
 * This class uses a combination of self-built and Google Gson methods to convert java objects to and from JSON. 
 * @author Alicen Zschokke
 */
public class JSONUtilities 
{
	/**
	 * Uses the Google Gson library to convert a JSON String to a HashMap
	 * @param json the JSON object String to convert
	 * @return a HashMap containing the values from the JSON object String
	 */
	public static HashMap<String, Object> fromJson(String json)
	{
		return new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>(){}.getType());
	}//end fromJSON()
	
	/**
	 * Converts an Iterable of JSONable Objects to a JSON array
	 */
	@SuppressWarnings("rawtypes")
	public static String listToJson(Iterable list)
	{
		StringJoiner result = new StringJoiner(", ", "[", "]");
		for(Object c : list)
		{
			result = result.add(((JSONable) c).toJSON());
		}
		return result.toString(); 
	}//end listToJSON
	
}//end class JSON Utilities
