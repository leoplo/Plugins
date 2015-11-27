package pluginManager;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuItem;

import displayer.MainWindow;

public class PluginsChangedLogger {
	protected Set<String> pluginsList;
	protected MainWindow mainWindow;

	public PluginsChangedLogger(MainWindow mainWindow) {
		pluginsList = new HashSet<String>();
		this.mainWindow = mainWindow;
	}

	public void update(String[] acceptedFiles) {
		for (String file : acceptedFiles) {
			if (pluginsList.add(file)) {
				System.out.println("add " + file);

				mainWindow.addPlugin(file);
			}
		}

		for (String oldPlugin : pluginsList) {
			boolean pluginMustBeRemoved = true;
			for (String currentPlugin : acceptedFiles) {
				if (oldPlugin.equals(currentPlugin)) {
					pluginMustBeRemoved = false;
					break;
				}
			}
			if (pluginMustBeRemoved) {
				System.out.println("remove " + oldPlugin);
				pluginsList.remove(oldPlugin);
				mainWindow.removePlugin(oldPlugin);
			}
		}

	}

}
