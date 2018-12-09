package alkolexa.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.response.ResponseBuilder;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

class TestUtil {

    public static HandlerInput mockHandlerInput(String cocktail) {

        final AttributesManager attributesManagerMock = Mockito.mock(AttributesManager.class);


        // Mock Slots
        final RequestEnvelope requestEnvelopeMock = RequestEnvelope.builder()
                .withRequest(IntentRequest.builder()
                        .withIntent(Intent.builder()
                                .putSlotsItem("cocktail", Slot.builder()
                                        .withName("cocktail")
                                        .withValue(cocktail)
                                        .build())
                                .build())
                        .build())
                .build();

        // Mock Handler input attributes
        final HandlerInput input = Mockito.mock(HandlerInput.class);
        when(input.getAttributesManager()).thenReturn(attributesManagerMock);
        when(input.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(input.getRequestEnvelope()).thenReturn(requestEnvelopeMock);
        return input;
    }

    public static Response standardTestForHandle(RequestHandler handler) {

        final Map<String, Object> sessionAttributes = new HashMap<>();
        sessionAttributes.put("list_of_Cocktails", "Test");
        final HandlerInput inputMock = TestUtil.mockHandlerInput("Zinger");
        final Optional<Response> res = handler.handle(inputMock);

        assertTrue(res.isPresent());
        final Response response = res.get();

        assertFalse(response.getShouldEndSession());
        assertNotEquals("Test", response.getReprompt());
        assertNotNull(response.getOutputSpeech());
        return response;

    }
}