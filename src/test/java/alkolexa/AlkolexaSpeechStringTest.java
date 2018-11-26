package alkolexa;

import org.junit.Assert;
import org.junit.Test;

public class AlkolexaSpeechStringTest {

	
	@Test
	public void getSpeechStringSorryTest() {
		Assert.assertEquals("Entschuldige", SpeechStrings.getSorry());
	}
	
	@Test
	public void getSpeechStringGoodbyeTest() {
		Assert.assertEquals("Bis bald", SpeechStrings.getGoodbye());
	}
	
	@Test
	public void getSpeechStringWelcTest() {
		Assert.assertEquals("Schoen das du da bist! Was kann ich fuer dich tun", SpeechStrings.getWelc());
	}
	
}
