package alkolexa.handlers;


import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import alkolexa.SpeechStrings;
import alkolexa.model.*;

import static com.amazon.ask.request.Predicates.intentName;



public class RandomCocktailIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("RandomCocktail"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        
    	
    	return input.getResponseBuilder()
                .withSpeech("Ich habe " + API.getCocktailName(API.randomCocktail()) + " endeckt")
                .withReprompt(null)
                .build();
    }
    }


