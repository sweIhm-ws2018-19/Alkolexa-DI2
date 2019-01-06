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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.json.JsonObject;

public class PersistentSaver {
	private static final String URL = "http://alkolexa.awsh-dev.de/";
	private static final Logger logger = Logger.getLogger(API.class.getName());
	
	// Constructor
	private PersistentSaver() {

	}

	/**
	 * Method to Set a Fav. Cocktail.
	 * @param favName name of the Cocktail.
	 */
	public static void setFavorite(String favName) {
		try {
			favName = URLEncoder.encode(favName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.log(Level.WARNING, "Exception");
		}

		JsonObject jsonObj = JsonObjectFromUrl.getJsonObjectFromUrl(URL + "?name=" + favName);
		String status = jsonObj.get("status").toString().replace("\"", "");
		if (!status.equals("success")) {
			System.out.println("coudn't store favourite");
		}

	}

	/**
	 * Method to get a Fav. cocktail
	 * @return will return a String
	 */
	public static String getFavorite() {
		JsonObject jsonObj = JsonObjectFromUrl.getJsonObjectFromUrl(URL);

		return jsonObj.get("name").toString().replace("\"", "");
	}

}
