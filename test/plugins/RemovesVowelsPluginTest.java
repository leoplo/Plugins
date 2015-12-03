package plugins;

import static org.junit.Assert.*;
import plugins.globalstrings.GlobalStrings;

public class RemovesVowelsPluginTest extends PluginTest {

	public RemovesVowelsPluginTest() {
		super(new RemovesVowelsPlugin());
	}

	@Override
	public void testTransform() {
		String vowels = "aeiouyAEIOUY";
		String helloWorld = "Hello world!";
		String helloWorldWithoutVowels = "Hll wrld!";
		
		assertEquals(helloWorldWithoutVowels, this.pluginTest.transform(helloWorld));
		assertEquals(helloWorldWithoutVowels.toUpperCase(), this.pluginTest.transform(helloWorld.toUpperCase()));
		assertTrue(this.pluginTest.transform(vowels).isEmpty());
	}
	
	@Override
	public void testGetLabel() {
		assertEquals(GlobalStrings.PLUGIN_LABEL_REMOVESVOWELS, this.pluginTest.getLabel());
	}

}
