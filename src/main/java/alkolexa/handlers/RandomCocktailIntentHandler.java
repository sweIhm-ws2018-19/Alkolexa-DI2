package alkolexa.handlers;


import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import alkolexa.SpeechStrings;

import static com.amazon.ask.request.Predicates.intentName;

public class RandomCocktailIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("Randomcocktail"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
    	return input.getResponseBuilder()
                .withSpeech(null)
                .withReprompt(null)
                .build();
    }
    }


