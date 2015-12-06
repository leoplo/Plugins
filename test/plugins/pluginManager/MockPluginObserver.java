package plugins.pluginManager;

import plugins.Plugin;

public class MockPluginObserver implements PluginObserver {

	protected boolean hasBeenUpdated = false;
	
	public boolean hasBeenUpdated() {
		return this.hasBeenUpdated;
	}
	
	@Override
	public void updatePlugins(Plugin[] newPlugins) {
		this.hasBeenUpdated = true;
	}

}
