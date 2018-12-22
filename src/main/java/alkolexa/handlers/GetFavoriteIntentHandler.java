package alkolexa.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import java.util.Optional;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import alkolexa.SpeechStrings;
import alkolexa.model.PersistentSaver;

public class GetFavoriteIntentHandler implements RequestHandler {
	public static final String FAVORITE_KEY = "FAVORITE";
	public static final String FAVORITE_SLOT = "Favorite";

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("GetFavorite"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText;
		// String favorite = (String)
		// input.getAttributesManager().getSessionAttributes().get(FAVORITE_KEY);
		String favorite = PersistentSaver.getFavorite();

		if (favorite != null && !favorite.isEmpty())
			speechText = SpeechStrings.getGetfavoritePositive() + favorite + ".";
		else
			speechText = SpeechStrings.getGetfavoriteNegative();
		return input.getResponseBuilder() //
				.withSpeech(speechText) //
				.withReprompt("") //
				.build();
	}
}