package alkolexa.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import java.util.Optional;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import alkolexa.SpeechStrings;
import alkolexa.model.API;
import alkolexa.model.PersistentSaver;

public class GetFavoriteIntentHandler implements RequestHandler {
	public static final String FAVORITE_KEY = "FAVORITE";
	public static final String FAVORITE_SLOT = "Favorite";

	/**
	 * Method to Handle a Input.
	 */
	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("GetFavorite"));
	}

	/**
	 * Method to get your Favorite Cocktail.
	 */
	@Override
	public Optional<Response> handle(HandlerInput input) {
		String favorite = PersistentSaver.getFavorite();
		if(favorite == null || favorite.equals("") || favorite.length() < 2) {
			return input.getResponseBuilder()
					.withSpeech("Du hast noch kein Favorite Cocktail hinzugefügt")
					.withShouldEndSession(false)
					.build();
		} else {
			return input.getResponseBuilder()
					.withSpeech("Ich habe deinen Cocktail " + favorite +  " als Favoriten gespeichert.")
					.withShouldEndSession(false)
					.build();
		}
	}
}