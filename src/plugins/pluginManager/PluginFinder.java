package plugins.pluginManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Timer;

import plugins.Plugin;

/**
 * Check each second if new plugins are available.
 */
public class PluginFinder implements ActionListener {

	public static final int TIMER_DELAY = 1_000; // 1sec

	protected PluginFilter pluginFilter;
	protected File directory;
	protected Timer timer;
	protected List<PluginObserver> observers;
	protected File[] files;

	public PluginFinder(File directory) {
		this.directory = directory;
		this.pluginFilter = new PluginFilter();
		this.observers = new ArrayList<PluginObserver>();
		this.timer = new Timer(TIMER_DELAY, this);
	}

	public File[] acceptedFiles() {
		return this.directory.listFiles(this.pluginFilter);
	}

	public void startTimer() {
		if (!this.timer.isRunning()) {
			this.timer.start();
		}
	}

	public List<PluginObserver> getObservers() {
		return this.observers;
	}

	public void registerObserver(PluginObserver pluginObserver) {
		this.observers.add(pluginObserver);
	}

	public void unregisterObserver(PluginObserver pluginObserver) {
		this.observers.remove(pluginObserver);
	}

	protected void notifyObservers(List<Plugin> newPlugins) {
		List<PluginObserver> observersToNotify = new ArrayList<PluginObserver>(this.observers);

		for (PluginObserver observer : observersToNotify) {
			observer.updatePlugins(newPlugins);
		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		File[] newFiles = this.acceptedFiles();

		if (!Arrays.equals(this.files, newFiles)) {
			List<Plugin> newPlugins = this.pluginFilter.fileArrayToPluginList(newFiles);
			this.notifyObservers(newPlugins);
			this.files = newFiles;
		}
	}

}
