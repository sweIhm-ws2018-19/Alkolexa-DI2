package alkolexa.model;

import org.junit.Assert;
import org.junit.Test;

import alkolexa.SpeechStrings;

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
	public void getSpeechStringHelloTest() {
		Assert.assertEquals("Willkommen bei Alkolexa", SpeechStrings.getHello());
	}
	@Test
	public void getSpeechStringWhyTest() {
		Assert.assertEquals("Was interessiert dich, Wein oder Cocktails", SpeechStrings.getWhy());
	}
	@Test
	public void getSpeechStringSorryRepeatTest() {
		Assert.assertEquals("Koenntest du das noch einmal sagen", SpeechStrings.getSorryPrepeat());
	}
	
	@Test
	public void getSpeechStringHelpTest() {
		Assert.assertEquals("Wenn du hilfe sagst, unterstuetze ich dich ", SpeechStrings.getHelp());
	}
	
	
	
	 
	
}
