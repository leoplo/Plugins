package plugins.pluginManager;

import java.util.Calendar;

import plugins.Plugin;

public class PluginsChangedLogger implements PluginObserver {

	@Override
	public void updatePlugins(Plugin[] plugins) {
		System.out.println("[" + Calendar.getInstance().getTime() + "]");
		System.out.println("List of plugins : ");

		for (Plugin plugin : plugins) {
			System.out.println(plugin.getLabel());
		}
	}

}
