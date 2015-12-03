package plugins.pluginManager;

import java.io.File;

public class LoggerMain {

	public static final String DEFAULT_DIRECTORY_LOCATION = "./dropins";

	public static void main(String[] args) {
		String directoryLocation = (args.length >= 1 ? args[0] : DEFAULT_DIRECTORY_LOCATION);
		File pluginDirectory = new File(directoryLocation);
		PluginFinder pluginFinder = new PluginFinder(pluginDirectory);
		PluginsChangedLogger logger = new PluginsChangedLogger();
		pluginFinder.registerObserver(logger);
		System.out.println("Plugins in " + directoryLocation + " :");
		pluginFinder.startTimer();
	}

}
