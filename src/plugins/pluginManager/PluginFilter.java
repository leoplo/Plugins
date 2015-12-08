package plugins.pluginManager;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import plugins.Plugin;

public class PluginFilter implements FilenameFilter {

	@Override
	public boolean accept(File directory, String name) {
		if(!name.endsWith(".class")) {
			return false;
		}
		
		String pluginName = name.substring(0, name.length() - 6);
		
		try {
			Class<?> pluginClass = Class.forName("plugins." + pluginName);
			return Plugin.class.isAssignableFrom(pluginClass);
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	public List<Plugin> fileArrayToPluginList(File[] acceptedFiles) {
		List<Plugin> plugins = new ArrayList<Plugin>();
		
		for (File file : acceptedFiles) {
			String fileName = file.getName();
			String pluginName = fileName.substring(0, fileName.length() - 6);
			
			try {
				Class<?> pluginClass = Class.forName("plugins." + pluginName);
				Plugin plugin = (Plugin) pluginClass.newInstance();
				plugins.add(plugin);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// nothing to do
			}
		}
		
		return plugins;
	}

}
