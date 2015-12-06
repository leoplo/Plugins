package plugins.pluginManager;

import java.util.List;

import plugins.Plugin;

public interface PluginObserver {

	public void updatePlugins(List<Plugin> newPlugins);

}
