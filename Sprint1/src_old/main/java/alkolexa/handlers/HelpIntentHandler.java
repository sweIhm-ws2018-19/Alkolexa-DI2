package main.java.alkolexa.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import main.java.alkolexa.SpeechStrings;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class HelpIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder()
                .withSimpleCard("SpeechStrings.SKILLNAME", SpeechStrings.HELP)
                .withSpeech(SpeechStrings.HELP)
                .withReprompt(SpeechStrings.HELP)
                .withShouldEndSession(false)
                .build();
    }
}