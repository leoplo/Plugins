package plugins.pluginManager;

import java.io.File;
import java.io.FilenameFilter;

import plugins.Plugin;

public class PluginFilter implements FilenameFilter {

	@Override
	public boolean accept(File directory, String name) {
		try {
			return new File("dropins/plugins/" + name).exists()
					&& Plugin.class.isAssignableFrom(Class.forName("plugins." + name.substring(0, name.length() - 6)))
					&& name.endsWith(".class");
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	public Plugin[] fileArrayToPluginArray(File[] acceptedFiles) {
		Plugin[] plugins = new Plugin[acceptedFiles.length];
		
		for (int i = 0; i < acceptedFiles.length; i++) {
			String fileName = acceptedFiles[i].getName();
			
			try {
				plugins[i] = (Plugin) Class
						.forName("plugins." + fileName.substring(0, fileName.length() - 6))
						.newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				plugins[i] = null;
			}
		}
		
		return plugins;
	}

}
