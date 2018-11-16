/*
 
 	TODO
 
 */

package main.java.alkolexa.handlers;

import static com.amazon.ask.request.Predicates.requestType;
import java.util.Optional;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

public class LaunchRequestHandler implements RequestHandler {
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

	public Optional<Response> handle(HandlerInput input) { // TODO: change texts
        String speechText = "Hallo. Ich lerne Deine Lieblingsfarbe. Bitte sage mir zum Beispiel: Meine Lieblingsfarbe ist blau.";
        String repromptText = "Bitte nenne Deine Lieblingsfarbe.";
        return input.getResponseBuilder()
                .withSimpleCard("AlkolexaSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .build();
    }
}

