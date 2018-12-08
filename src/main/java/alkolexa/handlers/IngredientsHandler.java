package alkolexa.handlers;


import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import java.util.Map;

import alkolexa.SpeechStrings;
import alkolexa.model.*;

import static com.amazon.ask.request.Predicates.intentName;



public class IngredientsHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("Ingredients"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        
    	Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        String value = slots.get("cocktail").getValue();
        
        
    	return input.getResponseBuilder()
                .withSpeech(value)
                .withReprompt(null)
                .build();
    }
    }

