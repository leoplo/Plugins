package pluginManager;

import java.io.File;

import javax.swing.Timer;

import displayer.Tools;

public class PluginFinder {
	protected PluginFilter filter;
	protected File directory;
	protected Timer timer;
	protected PluginsChangedLogger pluginsChangedLogger;

	public PluginFinder(File directory, Tools toolsMenu) {
		this.pluginsChangedLogger = new PluginsChangedLogger(toolsMenu);
		this.directory = directory;
		filter = new PluginFilter();
		timer = new Timer(1000, action -> {
			pluginsChangedLogger.update(acceptedFiles());
		});
		timer.setInitialDelay(0);
		timer.start();
	}

	public String[] acceptedFiles() {
		return directory.list(filter);
	}

}
