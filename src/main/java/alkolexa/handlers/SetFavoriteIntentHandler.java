package alkolexa.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import java.util.Optional;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;

import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder;

import alkolexa.model.PersistentSaver;

import java.util.Collections;
import java.util.Map;

import static alkolexa.handlers.GetFavoriteIntentHandler.FAVORITE_KEY;
import static alkolexa.handlers.GetFavoriteIntentHandler.FAVORITE_SLOT;

public class SetFavoriteIntentHandler implements RequestHandler {
	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("SetFavorite"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot favoriteCocktailSlot = slots.get(FAVORITE_SLOT);

		String speechText, repromptText;
		boolean isAskResponse = false;

		if (favoriteCocktailSlot != null) {
			String favoriteCocktail = favoriteCocktailSlot.getValue();
//			input.getAttributesManager().setSessionAttributes(Collections.singletonMap(FAVORITE_KEY, favoriteCocktail));
			PersistentSaver.setFavorite(favoriteCocktail);

			speechText = String.format(
					"Deine Favorite Cocktail ist %s. Du kannst mich jetzt nach Deinem Favorite Cocktail fragen. "
							+ "Frage einfach: was ist mein Favorite Cocktail?",
					favoriteCocktail);
			repromptText = "Frage nach meinem Favorite Cocktail.";

		} else {
			speechText = "Ich kenne Dein Favorite Cocktail nicht. Bitte versuche es noch einmal.";
			repromptText = "Ich weiss nicht welches Dein Favorite Cocktail ist. Sag mir Dein Favorite Cocktail. Sage zum Beispiel: Mein Favorite Cocktail ist Mochito.";
			isAskResponse = true;
		}

		ResponseBuilder responseBuilder = input.getResponseBuilder();

		responseBuilder.withSimpleCard("", speechText)//
				.withSpeech(speechText) //
				.withShouldEndSession(false); // Some error Messages are missing

		if (isAskResponse) {
			responseBuilder.withShouldEndSession(false).withReprompt(repromptText);
		}

		return responseBuilder.build();
	}
}
