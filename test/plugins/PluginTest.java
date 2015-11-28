package plugins;

import org.junit.Test;

public abstract class PluginTest {
	
	protected Plugin pluginTest;
	
	protected PluginTest(Plugin pluginTest) {
		this.pluginTest = pluginTest;
	}
	
	@Test
	public abstract void testTransform();
	
	@Test
	public abstract void testGetLabel();

}
