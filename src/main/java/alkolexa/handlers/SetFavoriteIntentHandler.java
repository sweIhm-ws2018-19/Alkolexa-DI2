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
import alkolexa.model.PersistentSaver;


public class SetFavoriteIntentHandler implements RequestHandler {
	private Map<String, Slot> slots = null;
	private IntentRequest intentRequest = null;
	private com.amazon.ask.model.Request request = null;
	private Intent intent = null;

	/**
	 * canHandle is a method to match the Speechpattern with the input of the user.
	 */
	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("SetFavorite"));
	}

	/**
	 * Handle Method to Handle a Set Favorite Cocktail
	 * @param input will be the spoken text from the user
	 */
	@Override
	public Optional<Response> handle(HandlerInput input) {
		request = input.getRequestEnvelope().getRequest();
		intentRequest = (IntentRequest) request;
		intent = intentRequest.getIntent();
		slots = intent.getSlots();
		if (emptyRequest()) {
			return input.getResponseBuilder()
					.withSimpleCard("", "") // Some error Messages are missing
					.withSpeech("") // Some error Messages are missing
					.withShouldEndSession(false)
					.build();
		} else {
			JsonObject response =  API.searchForCocktail(slots.get("cocktail").getValue());
			try {
				PersistentSaver.setFavorite(API.getCocktailName(response));
				return input.getResponseBuilder()
						.withSpeech("Ich habe deinen Cocktail " + API.getCocktailName(response) +  " als Favoriten gespeichert.")
						.withShouldEndSession(false)
						.build();
			} catch(Exception e) {
				System.out.println("Cannot set this Cocktail to FAV.Cock");
			}
			return input.getResponseBuilder()
					.withSpeech("Ich konnte leider kein Favoriten speichern")
					.withShouldEndSession(false)
					.build();
		}
	}
	
	/**
	 * Method to check whether a Request is Empty or not.
	 * @return Will return true in case the request is empty. Empty is considered as null.
	 */
	public boolean emptyRequest() {
		return slots.get("cocktail").getValue() == null;
	}
}
