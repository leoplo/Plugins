package pluginManager;

import java.io.File;

import javax.swing.JMenu;
import javax.swing.Timer;

public class PluginFinder {
	protected PluginFilter filter;
	protected File directory;
	protected Timer timer;
	protected PluginsChangedLogger pluginsChangedLogger;

	public PluginFinder(File directory,JMenu toolsMenu) {
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
