package plugins.pluginManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import plugins.displayer.MainWindow;
import plugins.Plugin;

public class PluginFinder implements ActionListener {

	public static final int TIMER_DELAY = 1000;

	protected PluginFilter pluginFilter;
	protected File directory;
	protected Timer timer;
	protected List<PluginObserver> observers;
	protected List<Plugin> plugins;

	public PluginFinder(File directory) {
		this.directory = directory;
		this.pluginFilter = new PluginFilter();
		this.timer = new Timer(TIMER_DELAY, this);
		this.observers = new ArrayList<PluginObserver>();
		this.plugins = new ArrayList<Plugin>();
	}

	public String[] acceptedFiles() {
		return this.directory.list(this.pluginFilter);
	}

	public void startTimer() {
		if (!this.timer.isRunning()) {
			this.timer.start();
		}
	}

	public void stopTimer() {
		this.timer.stop();
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
		this.plugins = newPlugins;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		List<Plugin> newPlugins = this.pluginFilter.fileArrayToPluginArray(this.acceptedFiles());

		if (plugins.isEmpty()) {
			this.notifyObservers(newPlugins);
			return;
		}

		boolean aPluginMustBeRemoved = true;
		for (Plugin plugin : plugins) {
			for (Plugin newPlugin : newPlugins) {
				if (plugins.contains(newPlugin)) {
					this.notifyObservers(newPlugins);
					return;
				}
				if (newPlugin.getLabel().equals(plugin.getLabel())) {
					aPluginMustBeRemoved = false;
					break;
				}
			}
		}
		if (aPluginMustBeRemoved) {
			this.notifyObservers(newPlugins);
			this.plugins = newPlugins;

		}
	}

}
