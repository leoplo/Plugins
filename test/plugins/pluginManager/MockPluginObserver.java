package plugins.pluginManager;

import java.util.List;

import plugins.Plugin;

public class MockPluginObserver implements PluginObserver {

	protected boolean hasBeenUpdated = false;
	
	public boolean hasBeenUpdated() {
		return this.hasBeenUpdated;
	}
	
	@Override
	public void updatePlugins(List<Plugin> newPlugins) {
		this.hasBeenUpdated = true;
	}

}
