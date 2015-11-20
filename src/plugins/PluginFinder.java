package plugins;

import java.io.File;

import javax.swing.Timer;

public class PluginFinder {
	protected PluginFilter filter;
	protected File directory;
	protected Timer timer;

	public PluginFinder(File directory) {
		this.directory = directory;
		filter = new PluginFilter();
	}

	public String[] acceptedFiles() {
		return directory.list(filter);
	}
}
