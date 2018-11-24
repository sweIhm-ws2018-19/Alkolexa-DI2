package main.java.alkolexa.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import java.util.Optional;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import main.java.alkolexa.SpeechStrings;

/**
 * @author DerAlex
 *
 */
public class WelcomeHandler implements RequestHandler {

		@Override
	    public boolean canHandle(HandlerInput input) {
	        return input.matches(intentName("WeclomeIntend"));
	    }

		@Override
	    public Optional<Response> handle(HandlerInput input) {
	        return input.getResponseBuilder()
	                .withSimpleCard("SpeechStrings.SKILLNAME", SpeechStrings.HELLO)
	                .withSpeech(SpeechStrings.HELLO)
	                .build();
	    }
}
