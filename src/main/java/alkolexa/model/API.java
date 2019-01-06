package alkolexa.model;

/**********************************************************************
*
* Project Alkolexa
* @author Anian Weber, weber.anian@hm.edu
* @version 11.12.2018
* 
* This Class Handels the API connection for the Alexa Skill "Alkolexa"
*
***********************************************************************/
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class API {

	private static JsonObject aktuellerCocktail = null;
	private static final Logger logger = Logger.getLogger(API.class.getName());

	/**
	 * Method to Search for a Cocktail
	 * @param searchCocktail name of the Cocktail
	 * @return will return a JsonObject containing all Information on the Searchresult
	 */
	public static JsonObject searchForCocktail(String searchCocktail) {
		String url = "";
		if (searchCocktail.length() == 0) {
			return null;
		}
		try {
			url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s="
					+ URLEncoder.encode(searchCocktail, "UTF-8");
			System.out.println("Request: " + url);
		} catch (UnsupportedEncodingException e) {
			logger.log(Level.WARNING, "Exception");
		}

		JsonObject jsonObj = JsonObjectFromUrl.getJsonObjectFromUrl(url);
		JsonObject firstFoundCocktail = (JsonObject) jsonObj.get("drinks").asJsonArray().get(0);
		System.out.println("Raw response: " + jsonObj);
		return firstFoundCocktail;
	}

	
	/**
	 * Method to get a random Cocktail from the API.
	 * @return will return a JSON-Object
	 */
	public static JsonObject randomCocktail() {
		String url = "";
		url = "https://www.thecocktaildb.com/api/json/v1/1/random.php";
		System.out.println("Request: " + url);

		JsonObject jsonObj = JsonObjectFromUrl.getJsonObjectFromUrl(url);
		JsonObject firstFoundCocktail = (JsonObject) jsonObj.get("drinks").asJsonArray().get(0);
		aktuellerCocktail = firstFoundCocktail;
		return firstFoundCocktail;
	}

	/**
	 * Method to get the Cocktailname
	 * @param cocktailJson Cocktail by JSON-OBJ
	 * @return will return the Name as a String
	 */
	public static String getCocktailName(JsonObject cocktailJson) {
		if(cocktailJson == null) {
			return null;
		}
		String name = cocktailJson.getString("strDrink");
		aktuellerCocktail = cocktailJson;
		return name;
	}

	/**
	 * All instruction to that it takes to make a Cocktail
	 * @param cocktailJson Json-Obj of the Cocktail
	 * @return will return a String
	 */
	public static String getCocktailInstructions(JsonObject cocktailJson) {
		String instructions = cocktailJson.getString("strInstructions");
		return instructions;
	}

	/**
	 * Method to get random instruction
	 * @return return a String with this instruction
	 */
	public static String getRandomCocktailInstructions() {
		if (aktuellerCocktail != null) {
			String instructions = aktuellerCocktail.getString("strInstructions");
			return instructions;
		}
		
		return null;
	}

	/**
	 * All Ingredients of a Cocktail from the API
	 * @param cocktailJson name of the Cocktail
	 * @return will return an Arraylist<String> containing all Ing. of the Cocktail
	 */
	public static ArrayList<String> getCocktailIngredients(JsonObject cocktailJson) {
		ArrayList<String> ingredients = new ArrayList<>();
		int currentIngredientCount = 1;
		while (!cocktailJson.getString("strIngredient" + currentIngredientCount).isEmpty()) {
			ingredients.add(cocktailJson.getString("strIngredient" + currentIngredientCount));// System.out.println(ingredients.get(currentIngredientCount-1));
			currentIngredientCount++;
		}
		return ingredients;
	}

	/**
	 * Method to get all Measures to do to prepare a Cocktail
	 * @param cocktailJson name of the Cocktail
	 * @return Will return an Arraylist<String> containing all Measures 
	 */
	public static ArrayList<String> getCocktailMeasures(JsonObject cocktailJson) {
		ArrayList<String> measures = new ArrayList<>();
		int currentMeasuresCount = 1;
		while (!cocktailJson.getString("strMeasure" + currentMeasuresCount).isEmpty()) {

			measures.add(cocktailJson.getString("strMeasure" + currentMeasuresCount));// System.out.println(ingredients.get(currentIngredientCount-1));
			// System.out.println(measures.get(currentMeasuresCount-1));
			currentMeasuresCount++;
		}
		return measures;
	}


	public static void main(String[] args) {
		getCocktailCategorys();
		System.out.println(getCocktailName(getRandomCocktailFromCategory("Cocktail")));
	}

	/**
	 * Method to get a Cocktail by its category. 
	 * @return will return an Arraylist<String>
	 */
	public static ArrayList<String> getCocktailCategorys() {
		ArrayList<String> categorys = new ArrayList<>();
		JsonObject jsonObject = JsonObjectFromUrl
				.getJsonObjectFromUrl("https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list");

		JsonArray drinks = jsonObject.get("drinks").asJsonArray();
		for (int i = 0; i < drinks.size(); i++) {
			String catName = drinks.get(i).asJsonObject().get("strCategory").toString().replace("\"", "");
			catName = catName.toLowerCase();
			categorys.add(catName);
		}
		return categorys;
	}

	/**
	 * Method to get a Random Cocktail from its category.
	 * @param categoryName name of the category 
	 * @return will return a Json-Obj
	 */
	public static JsonObject getRandomCocktailFromCategory(String categoryName) {
		// @TODO Implement properly
	
		if (getCocktailCategorys().contains(categoryName)) {
			//categoryName = categoryName.toLowerCase();
			JsonObject jsonObject = JsonObjectFromUrl
					.getJsonObjectFromUrl("https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=" + categoryName);
			JsonArray categorys = jsonObject.get("drinks").asJsonArray();
			int randomIndex = (int) (Math.random() * categorys.size());
			
			JsonObject randomCocktail = categorys.get(randomIndex).asJsonObject();
			return randomCocktail;
		} else {
			System.out.println("Cocktail Cahtegory not available.");
			return null;
		}

	}
}