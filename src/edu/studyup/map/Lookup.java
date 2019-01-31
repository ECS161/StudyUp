package edu.studyup.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.studyup.entity.Location;

public class Lookup {
	public static Location lookupPlace(String query) {
		JSONArray results = queryURL(query);
		if (results.isEmpty()) return null;
		// For now, simply return the location for the top result
		JSONObject best = results.getJSONObject(0);
        return getLocation(best);
	}

	private static Location getLocation(JSONObject location) {
        double lat = location.getDouble("lat");
        double lon = location.getDouble("lon");
        double[] bounds = new double[4];
        JSONArray boundingBox = location.getJSONArray("boundingbox");
        // Convert Nominatim API format (minLon, maxLon, minLat, maxLat) to OpenLayers format (minLat, minLon, maxLat, maxLon)
        bounds[0] = boundingBox.getDouble(2);
        bounds[1] = boundingBox.getDouble(0);
        bounds[2] = boundingBox.getDouble(3);
        bounds[3] = boundingBox.getDouble(1);
        return new Location(lat, lon, bounds);
	}
	
	private static JSONArray queryURL(String query) {
		JSONArray results = new JSONArray();
		try {
			String urlString = "https://nominatim.openstreetmap.org/search?q=" + URLEncoder.encode(query, "UTF-8") + "&format=json";
			URL url = new URL(urlString);
			try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
		        StringBuilder sb = new StringBuilder();
		        int cp;
		        while ((cp = in.read()) != -1) {
		            sb.append((char) cp);
		        }
		        in.close();
		        String content = sb.toString();
		        results = new JSONArray(content);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException | MalformedURLException e) {
			e.printStackTrace();
		}
		return results;
	}
}
