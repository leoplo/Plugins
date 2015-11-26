package pluginManager;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuItem;

import displayer.Tools;

public class PluginsChangedLogger {
	protected Set<String> pluginsList;
	protected Tools toolsMenu;

	public PluginsChangedLogger(Tools toolsMenu) {
		pluginsList = new HashSet<String>();
		this.toolsMenu = toolsMenu;
	}

	public void update(String[] acceptedFiles) {
		for (String file : acceptedFiles) {
			if (pluginsList.add(file)) {
				System.out.println("add " + file);
				toolsMenu.add(new JMenuItem(file));
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
				toolsMenu.remove(oldPlugin);
			}
		}

	}

}
