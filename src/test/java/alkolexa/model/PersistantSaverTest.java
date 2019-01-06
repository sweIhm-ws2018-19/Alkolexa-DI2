package alkolexa.model;


import org.junit.Assert;
import org.junit.Test;


public class PersistantSaverTest {
	
	@Test
	public void PersitentSaverGetAndSet() {
		PersistentSaver.setFavorite("Test");
		Assert.assertEquals("Test",PersistentSaver.getFavorite());
	}
}