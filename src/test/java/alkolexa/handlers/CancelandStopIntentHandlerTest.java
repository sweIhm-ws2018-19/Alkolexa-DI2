package alkolexa.handlers;


import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;

import alkolexa.SpeechStrings;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class CancelandStopIntentHandlerTest {

    private CancelandStopIntentHandler handler;

    @Before
    public void setup() {
        handler = new CancelandStopIntentHandler();
    }

    @Test
    public void canHandleTest() {
        HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    public void handleTest1() {
        final Response response = TestUtil.standardTestForHandle(handler);
        assertTrue(response.getOutputSpeech().toString().contains(SpeechStrings.getGoodbye()));
    }
}