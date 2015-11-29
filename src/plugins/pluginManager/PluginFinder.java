package plugins.pluginManager;

import java.io.File;

import javax.swing.Timer;

import plugins.displayer.MainWindow;

public class PluginFinder {
	protected PluginFilter filter;
	protected File directory;
	protected Timer timer;
	protected PluginsChangedLogger pluginsChangedLogger;

	public PluginFinder(File directory, MainWindow mainWindow) {
		this.pluginsChangedLogger = new PluginsChangedLogger(mainWindow);
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
