package alkolexa.handlers;


import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import alkolexa.model.*;

import static com.amazon.ask.request.Predicates.intentName;



public class RandomCocktailIntentHandler implements RequestHandler {
	
	/**
	 * canHandle is a method to match the Speechpattern with the input of the user.
	 */
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("RandomCocktail"));
    }

    /**
	 * Handle Method to Handle a RandomCocktail Request.
	 * @param input will be the spoken text from the user
	 */
    @Override
    public Optional<Response> handle(HandlerInput input) {
    	return input.getResponseBuilder()
                .withSpeech("Ich habe " + API.getCocktailName(API.randomCocktail()) + " endeckt")
                .withShouldEndSession(false)
                .build();
    }
}


