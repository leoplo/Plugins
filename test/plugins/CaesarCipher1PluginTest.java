package plugins;

import static org.junit.Assert.assertEquals;

public class CaesarCipher1PluginTest extends PluginTest {

	public CaesarCipher1PluginTest() {
		super(new CaesarCipher1Plugin());
	}

	@Override
	public void testTransform() {
		String helloWorld = "Hello world!";
		String encodedHelloWorld = "Ifmmp xpsme!";

		assertEquals(encodedHelloWorld, this.pluginTest.transform(helloWorld));
	}

	@Override
	public void testGetLabel() {
		assertEquals(String.format("Caesar cipher %d", 1), this.pluginTest.getLabel());
	}

}
