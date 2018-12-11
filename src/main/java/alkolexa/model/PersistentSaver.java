/**********************************************************************
*
* Project Alkolexa
* @author Anian Weber, weber11@hm.edu
* @version 11.12.2018
*
***********************************************************************/

package alkolexa.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.json.JsonObject;

public class PersistentSaver {
	private static final String URL = "http://alkolexa.awsh-dev.de/";
	
	public static void setFavorite(String favName) {
	
		try {
			favName = URLEncoder.encode(favName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		JsonObject jsonObj = JsonObjectFromUrl.getJsonObjectFromUrl(URL+"?name="+favName);
		String status = jsonObj.get("status").toString().replace("\"","");
		if(!status.equals("success")) {
			System.out.println("coudnt store favourite");
		}
		
		
	}
	
	public static String getFavorite() {
		JsonObject jsonObj = JsonObjectFromUrl.getJsonObjectFromUrl(URL);
		String fav = jsonObj.get("name").toString().replace("\"", "");
		return fav;
	}

}
