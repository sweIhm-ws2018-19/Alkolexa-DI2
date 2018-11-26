package main.java.alkolexa.handlers;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder;

import static main.java.alkolexa.handlers.GetEmergencyContactIntantHandler.CONTACT_KEY;
import static main.java.alkolexa.handlers.GetEmergencyContactIntantHandler.CONTACT_SLOT;
import static com.amazon.ask.request.Predicates.intentName;

public class SetEmergencyContactIntentHandler implements RequestHandler {

	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("SetContactEmergencyIntent"));
	}

	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		// Get the contact slot from the list of slots.
		Slot contactSlot = slots.get(CONTACT_SLOT);
		// till yet there are just normal Strings available
		// TODO: check for existing contact, add the contacts name

		String speechText, repromptText;
		boolean isAskResponse = false;

		// Check for emergency contact and create output to user.
		if (contactSlot != null) {
			// Store the user's emergency contact in the Session and create response.
			String contact = contactSlot.getValue();
			input.getAttributesManager().setSessionAttributes(Collections.singletonMap(CONTACT_KEY, (Object) contact));

			speechText = String
					.format("Dein Notfallkontakt ist %s. Du kannst mich jetzt nach Deinem Notfallkontakt fragen. "
							+ "Frage einfach: was ist mein Notfallkontakt? "//
							+ "Oder rufe dein Notfallkontakt an mit." //
							+ "Sage einfach: <UNDEFINED>?", contact); // TODO: discuss code word for emergency call
			repromptText = "Frage nach meinem Notfallkontakt.";

		} else {
			// Render an error since we don't know what the users emergency contact is.
			speechText = "Ich kenne Deinen Notfallkontakt nicht. Bitte versuche es noch einmal.";
			repromptText = "Ich weiss nicht wer Dein Notfallkontakt ist. Sag mir Deinen Notfallkontakt. Sage zum Beispiel: mir hilft Max Musterman.";
			isAskResponse = true;
		}

		ResponseBuilder responseBuilder = input.getResponseBuilder();

		responseBuilder.withSimpleCard("AlkolexaSession", speechText).withSpeech(speechText)
				.withShouldEndSession(false);

		if (isAskResponse) {
			responseBuilder.withShouldEndSession(false).withReprompt(repromptText);
		}

		return responseBuilder.build();
	}
}
