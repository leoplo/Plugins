package pluginManager;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		/*URL[] url = new URL[1];
		try {
			System.out.println(dir.toURI()+name);
			url[0]=new URL(dir.toURI()+name);
			URLClassLoader classLoader = new URLClassLoader(url);
			Class classToTest = classLoader.loadClass(name);
			System.out.println(classToTest.getName());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}*/
		
		return name.endsWith(".class");
	}

}
