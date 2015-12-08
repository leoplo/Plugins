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
	}
}
