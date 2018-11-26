package main.java.alkolexa.handlers;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import static com.amazon.ask.request.Predicates.intentName;

public class GetEmergencyContactIntantHandler implements RequestHandler {
	public static final String CONTACT_KEY = "CONTACT";
	public static final String CONTACT_SLOT = "Contact";

	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("GetEmergencyContactIntent"));
	}

	public Optional<Response> handle(HandlerInput input) {
		String speechText;
		String favoriteColor = (String) input.getAttributesManager().getSessionAttributes().get(CONTACT_KEY);
		// till jet just saved for session
		// TODO: access to DynamoDB

		if (favoriteColor != null && !favoriteColor.isEmpty()) {
			speechText = String.format("Dein Notfallkontakt ist %s.", favoriteColor);
		} else {
			// Since the user's favorite color is not set render an error message.
			speechText = "Ich weiss nicht wer Dein Notfallkontakt ist. Sag mir Dein Notfallkontakt. Sage zum Beispiel: Mein Notfallkontakt ist Max Mustermann.";
		}

		return input.getResponseBuilder().withSpeech(speechText).withSimpleCard("AlkolexaSession", speechText).build();
	}
}
