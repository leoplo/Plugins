package pluginManager;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PluginsChangedLogger {
	protected Set<String> pluginsList;
	protected JMenu toolsMenu;

	public PluginsChangedLogger(JMenu toolsMenu) {
		pluginsList = new HashSet<String>();
		this.toolsMenu = toolsMenu;
	}

	public void update(String[] acceptedFiles) {
		for (String file : acceptedFiles) {
			if (pluginsList.add(file)) {
				toolsMenu.add(new JMenuItem(file));
			}
		}

	}

}
