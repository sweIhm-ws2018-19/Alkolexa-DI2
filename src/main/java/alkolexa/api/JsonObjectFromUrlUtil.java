/**********************************************************************
*
* Project Alkolexa
* @author Thorsten Horn //Not a Team Member of skillproject-di-2
* 
* External Used Handler for get the Json from a Requestet URL - Unmodiefied (despied this comment block)
*
***********************************************************************/

/**
 * Beispiel für die Nutzung von JsonObject
 * 
 * basierend auf
 * Quelle: Thorsten Horn, RESTful Web Services mit JAX-RS 2.1 und Jersey 2.26,
 * https://www.torsten-horn.de/techdocs/jee-rest.htm, 8.10.2018
 */
package main.java.alkolexa.api;

/**
 * Example for reading a JsonObject from a webservice uri
 * 
 * based on
 * Source: https://www.torsten-horn.de/techdocs/jee-rest.htm#JsonRestClientMitHttpURLConnection
 * 
 * @author Thorsten Horn
 *
 */
import javax.json.*;
import java.io.*;
import java.net.*;

public class JsonObjectFromUrlUtil {
	public static JsonObject getJsonObjectFromUrl(String url) {
		try {
			HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
			// set request method (could also be POST or PUT, depending on the webservice to
			// be used)
			conn.setRequestMethod("GET");
			// remember: for PUT, POST you need to set conn.setDoOutput(true);
			conn.setRequestProperty("Accept", "application/json");

			/*
			 * This example does not require any json objects to be sent in the request,
			 * however, for an API that requires json objects to PUT or POSTed, you can
			 * generate the json easily by
			 * 
			 * JsonObject objectToBeSent = Json.createObjectBuilder().add("some name",
			 * "some value").build();
			 * 
			 * and you can send it via
			 * 
			 * try (JsonWriter jsonWriter = Json.createWriter(conn.getOutputStream())){
			 * jsonWriter.writeObject(objectToBeSent); }
			 */

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException(
						"Exception occured while accessing url " + url + ": " + conn.getResponseMessage());
			}
			try (JsonReader jsonRdr = Json.createReader((InputStream) conn.getContent())) {
				return jsonRdr.readObject();
			}
		} catch (IOException ex) {
			throw new RuntimeException("Exception occured while accessing url: " + url, ex);
		}
	}
}
