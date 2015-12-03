package plugins;

import static org.junit.Assert.*;
import plugins.globalstrings.GlobalStrings;

public class CaesarCipher13PluginTest extends PluginTest {

	public CaesarCipher13PluginTest() {
		super(new CaesarCipher13Plugin());
	}

	@Override
	public void testTransform() {
		String helloWorld = "Hello world!";
		String encodedHelloWorld = "Uryyb jbeyq!";

		assertEquals(encodedHelloWorld, this.pluginTest.transform(helloWorld));
	}

	@Override
	public void testGetLabel() {
		assertEquals(String.format(GlobalStrings.PLUGIN_LABEL_CAESARCIPHER, 13), this.pluginTest.getLabel());
	}

}
