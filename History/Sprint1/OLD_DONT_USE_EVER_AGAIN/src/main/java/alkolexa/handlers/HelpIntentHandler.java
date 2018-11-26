/*
 
 	TODO
 
 */

package main.java.alkolexa.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.Optional;
import static com.amazon.ask.request.Predicates.intentName;

public class HelpIntentHandler implements RequestHandler {
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.HelpIntent"));
	}

	public Optional<Response> handle(HandlerInput input) {
		// TODO: change speechText
		String speechText = "Du kannst mir Deine Lieblingsfarbe sagen. Sage zum Beispiel, meine Lieblingsfarbe ist rot.";
		String repromptText = "Bitte sage mir Deine Lieblingsfarbe."; // TODO: change repromptText
		return input.getResponseBuilder().withSimpleCard("AlkolexaSession", speechText) // TODO: change Session
				.withSpeech(speechText).withReprompt(repromptText).withShouldEndSession(false).build();
	}
}
