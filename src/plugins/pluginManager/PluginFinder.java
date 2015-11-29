package plugins.pluginManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Timer;

import plugins.Plugin;

public class PluginFinder implements ActionListener {
	
	public static final int TIMER_DELAY = 1000;
	
	protected PluginFilter pluginFilter;
	protected File directory;
	protected Timer timer;
	protected List<PluginObserver> observers;
	protected Plugin[] plugins;

	public PluginFinder(File directory) {
		this.directory = directory;
		this.pluginFilter = new PluginFilter();
		this.timer = new Timer(TIMER_DELAY, this);
		this.observers = new ArrayList<PluginObserver>();
	}

	public File[] acceptedFiles() {
		return this.directory.listFiles(this.pluginFilter);
	}
	
	public void startTimer() {
		if(!this.timer.isRunning()) {
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
	
	protected void notifyObservers(Plugin[] newPlugins) {
		List<PluginObserver> observersToNotify = new ArrayList<PluginObserver>(this.observers);
		
		for(PluginObserver observer : observersToNotify) {
			observer.updatePlugins(newPlugins);
		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Plugin[] newPlugins = this.pluginFilter.fileArrayToPluginArray(this.acceptedFiles());
		
		if(!Arrays.equals(this.plugins, newPlugins)) {
			this.notifyObservers(newPlugins);
			this.plugins = newPlugins;
		}
	}

}
