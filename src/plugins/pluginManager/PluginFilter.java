package plugins.pluginManager;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import plugins.Plugin;

/**
 * This is a filter which only accepts files which end with ".class", implements
 * plugins.Plugins, belongs to the package plugins and adds a constructor with
 * no parameter.
 *
 */
public class PluginFilter implements FilenameFilter {

	@Override
	public boolean accept(File directory, String name) {
		if (!name.endsWith(".class")) {
			return false;
		}

		String pluginName = name.substring(0, name.length() - 6);

		try {
			Class<?> pluginClass = Class.forName("plugins." + pluginName);
			List<Constructor<?>> constructors = Arrays.asList(pluginClass.getConstructors());

			return Plugin.class.isAssignableFrom(pluginClass) && pluginClass.getPackage().getName().equals("plugins")
					&& constructors.stream().anyMatch(c -> c.getParameterTypes().length == 0);
		} catch (ClassNotFoundException | NoClassDefFoundError e) {
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
