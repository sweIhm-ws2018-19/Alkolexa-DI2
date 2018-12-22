package alkolexa.handlers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class SearchForCocktailTest {
	
	private LaunchRequestHandler handler;

    @Before
    public void setup() {
        handler = new LaunchRequestHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }
    
    
}