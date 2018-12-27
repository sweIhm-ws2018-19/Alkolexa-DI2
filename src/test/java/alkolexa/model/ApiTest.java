package alkolexa.model;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class ApiTest {
	
	@Test
	public void randomCocktailTest() {
		Assert.assertNotNull(API.randomCocktail());
	}
	
	@Test
	public void CoktailNameTest() {
		Assert.assertEquals("Zorro", API.getCocktailName(API.searchForCocktail("zorro")));
	}
	
	@Test
	public void randomCocktailInstructionTest() {
		API.randomCocktail();
		Assert.assertNotNull(API.getRandomCocktailInstructions());
	}
	
	@Test
	public void CocktailInstructionTest() {
		Assert.assertEquals("Pour beer into large mug, slowly add the 7-up (or Sprite).",API.getCocktailInstructions(API.searchForCocktail("radler")));
	}

	@Test
	public void CocktailIngredientsTest() {
		ArrayList<String> ingredients = new ArrayList<>();
		ingredients.add("Beer");
		ingredients.add("7-Up");
		Assert.assertEquals(ingredients,API.getCocktailIngredients(API.searchForCocktail("radler")));
	}
	
	@Test
	public void CocktailCategorySearchTest() {
		Assert.assertNotNull(API.getRandomCocktailFromCategory("cocktail"));
	}

	@Test
	public void CocktailMeasuresTest() {
		ArrayList<String> ingredients = new ArrayList<>();
		ingredients.add("12 oz ");
		ingredients.add("12 oz ");
		Assert.assertEquals(ingredients.get(1),API.getCocktailMeasures(API.searchForCocktail("radler")).get(1));
	}
	
	
	@Test
	public void getSpeechStringSorryTest() {
		Assert.assertEquals("add all and pour black coffee and add whipped cream on top.",API.getCocktailInstructions((API.searchForCocktail("zorro"))));
	}
	
	

	
}
