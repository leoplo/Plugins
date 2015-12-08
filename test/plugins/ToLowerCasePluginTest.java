package plugins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ToLowerCasePluginTest extends PluginTest {

	public ToLowerCasePluginTest() {
		super(new ToLowerCasePlugin());
	}

	@Override
	public void testTransform() {
		String helloWorld = "HELLO WORLD!!!";
		String helloWorldInLowerCase = "hello world!!!";
		String transformedText = this.pluginTest.transform(helloWorld);

		for (Character c : transformedText.toCharArray()) {
			if (Character.isLetter(c)) {
				assertTrue(Character.isLowerCase(c));
			}
		}

		assertEquals(helloWorldInLowerCase, transformedText);
	}

	@Override
	public void testGetLabel() {
		assertEquals("To Lower Case", this.pluginTest.getLabel());
	}

}
