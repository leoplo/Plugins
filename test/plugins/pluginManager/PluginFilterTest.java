package plugins.pluginManager;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class PluginFilterTest {

	@Test
	public void acceptTest() {
		PluginFilter pluginFilter = new PluginFilter();
		File directory = new File("src/plugins");
		
		assertFalse(pluginFilter.accept(directory, "MyPlugin"));
		assertFalse(pluginFilter.accept(directory, "MyPlugin.class"));
		assertTrue(pluginFilter.accept(directory, "RemovesVowelsPlugin.class"));
	}
	
	@Test
	public void fileArrayToPluginListTest() {
		PluginFilter pluginFilter = new PluginFilter();
		File[] files = { new File("MyPlugin.class") };
		assertTrue(pluginFilter.fileArrayToPluginList(files).isEmpty());
	}
}
