package plugins.pluginManager;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import plugins.Plugin;

public class PluginFilter implements FilenameFilter {

	@Override
	public boolean accept(File directory, String name) {
		try {
			return name.endsWith(".class")
					&& Plugin.class.isAssignableFrom(Class.forName("plugins." + name.substring(0, name.length() - 6)));
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	public List<Plugin> fileArrayToPluginList(File[] acceptedFiles) {
		List<Plugin> plugins = new ArrayList<Plugin>();
		
		for (File file : acceptedFiles) {
			String fileName = file.getName();
			
			try {
				Plugin plugin = (Plugin) Class
						.forName("plugins." + fileName.substring(0, fileName.length() - 6))
						.newInstance();
				plugins.add(plugin);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// nothing to do
			}
		}
		
		return plugins;
	}

}
