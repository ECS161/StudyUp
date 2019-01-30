package map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Lookup {
	public static Location lookupPlace(String query) {
		JSONArray results = Util.queryURL(query);
		if (results.isEmpty()) return null;
		
        JSONObject best = results.getJSONObject(0);
        double lat = best.getDouble("lat");
        double lon = best.getDouble("lon");
        return new Location(lat, lon); 
       }
	}
