package pluginManager;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;

import plugins.Plugin;

public class PluginFilter implements FilenameFilter {

	@Override
	public boolean accept(File directory, String name) {
		boolean returnValue = false;
		// URL[] url = new URL[1];

		try {

			/*
			 * System.out.println(directory.toURI() + name); url[0] = new
			 * URL(directory.toURI() + ""); URLClassLoader classLoader = new
			 * URLClassLoader(url); Class classToTest =
			 * classLoader.loadClass(name.substring(0, name.length() - 6));
			 * System.out.println(classToTest.getName());
			 */
			Class.forName("plugins." + name.substring(0, name.length() - 6)).newInstance();
			returnValue = new File("bin/plugins/" + name).exists()
					&& Plugin.class.isAssignableFrom(Class.forName("plugins." + name.substring(0, name.length() - 6)))

					&& name.endsWith(".class");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
