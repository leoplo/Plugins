package plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ToUpperCasePluginTest extends PluginTest {

	public ToUpperCasePluginTest() {
		super(new ToUpperCasePlugin());
	}

	@Override
	public void testTransform() {
		String helloWorld = "Hello world!";
		String helloWorldInUpperCase = "HELLO WORLD!";
		String transformedText = this.pluginTest.transform(helloWorld);

		for (Character c : transformedText.toCharArray()) {
			if (Character.isLetter(c)) {
				assertTrue(Character.isUpperCase(c));
			}
		}

		assertEquals(helloWorldInUpperCase, transformedText);
	}

	@Override
	public void testGetLabel() {
		assertEquals("To Upper Case", this.pluginTest.getLabel());
	}

}
