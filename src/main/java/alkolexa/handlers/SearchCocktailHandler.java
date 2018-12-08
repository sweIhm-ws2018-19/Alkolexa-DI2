package alkolexa.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import javax.json.JsonObject;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

import alkolexa.model.API;

//org.apache.maven.plugins:maven-assembly-plugin:2.6:assembly -DdescriptorId=jar-with-dependencies package

public class SearchCocktailHandler  implements RequestHandler {

	private Map<String, Slot> slots = null;
	private IntentRequest intentRequest = null;
	private com.amazon.ask.model.Request request = null;
	private Intent intent = null;
	private String search = null;

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("SearchCocktail"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		request = input.getRequestEnvelope().getRequest();
		intentRequest = (IntentRequest) request;
		intent = intentRequest.getIntent();
		slots = intent.getSlots();
		if (emptyRequest()) {
			return input.getResponseBuilder()
					.withSimpleCard("", "") // Some error Messages are missing
					.withSpeech("") // Some error Messages are missing
					.withShouldEndSession(false)
					.build();
		} else {
			JsonObject response = API.searchForCocktail(search);
			if (response == null) {
				return input.getResponseBuilder()
						.withSpeech("Entschuldige ich konnte keinen Cocktail mit diesem Namen finden")
						.withReprompt(null)
						.build();
			} else {
				return input.getResponseBuilder()
						.withSpeech("Ich habe dein Cocktail gefunden moechtest du die Zutaten wissen?")
						.withReprompt(null)
						.build();
			}
			
		}
	}
	
	public boolean emptyRequest() {
		return slots.get("search").getValue() != null;
	}

	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}
}
