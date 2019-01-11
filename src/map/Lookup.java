package map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class Lookup {
	public static String lookupPlace(String query) {
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
		if (results.isEmpty()) return null;
		
        JSONObject best = results.getJSONObject(0);
        double lat = best.getDouble("lat");
        double lon = best.getDouble("lon");
        return lat + "\t" + lon;
	}
}
