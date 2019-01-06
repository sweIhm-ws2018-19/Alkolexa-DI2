package alkolexa.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import javax.json.JsonObject;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

import alkolexa.model.API;

/**
 * Class for the Intent - Search for a Cocktail This Class represents a Intent
 * to Search for a Cocktail given by the User.
 * 
 * @author Team Alkolex
 *
 */
public class SearchCocktailCategoryIntentHandler implements RequestHandler {

	private Map<String, Slot> slots = null;
	private IntentRequest intentRequest = null;
	private com.amazon.ask.model.Request request = null;
	private Intent intent = null;

	/**
	 * canHandle is a method to match the Speechpattern with the input of the user.
	 */
	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("SearchCocktailCategory"));
	}

	/**
	 * Handle Method to Handle a search Request.
	 * 
	 * @param input will be the spoken text from the user
	 */
	@Override
	public Optional<Response> handle(HandlerInput input) {
		request = input.getRequestEnvelope().getRequest();
		intentRequest = (IntentRequest) request;
		intent = intentRequest.getIntent();
		slots = intent.getSlots();

		String kategorie = slots.get("category").getValue();
		String name = API.getCocktailName(API.getRandomCocktailFromCategory(kategorie));
		if (name == null) {
			return input.getResponseBuilder()
					.withSpeech("Entschuldige ich konnte keinen Cocktail mit dieser Category finden")
					.withShouldEndSession(false).build();
		} else {
			return input.getResponseBuilder()
					.withSpeech("Ich habe "
							+ name
							+ " gefunden.")
					.withShouldEndSession(false).build();
		}

	}


}
