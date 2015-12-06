package plugins.pluginManager;

import java.util.Calendar;
import java.util.List;

import plugins.Plugin;

public class PluginsChangedLogger implements PluginObserver {

	@Override
	public void updatePlugins(List<Plugin> plugins) {
		System.out.println("[" + Calendar.getInstance().getTime() + "]");
		System.out.println(String.format("List of plugins : %s", plugins.isEmpty() ? "Empty" : ""));

		for (Plugin plugin : plugins) {
			System.out.println(plugin.getLabel());
		}
	}

}
