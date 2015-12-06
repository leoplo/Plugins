package plugins.editor;

import java.io.File;

import javax.swing.JMenuItem;

import plugins.Plugin;
import plugins.pluginManager.PluginFinder;
import plugins.pluginManager.PluginObserver;

@SuppressWarnings("serial")
public class EventEditorFrame extends EditorFrame implements PluginObserver {

	protected PluginFinder pluginFinder;

	public EventEditorFrame(File pluginDirectory) {
		this.pluginFinder = new PluginFinder(pluginDirectory);
		this.pluginFinder.registerObserver(this);
		this.pluginFinder.startTimer();
	}

	@Override
	public void updatePlugins(Plugin[] plugins) {
		this.toolsMenu.removeAll();

		for (Plugin pluginToAdd : plugins) {
			JMenuItem menuItem = new JMenuItem(pluginToAdd.getLabel());
			menuItem.addActionListener(actionListener -> {
				textArea.setText(pluginToAdd.transform(textArea.getText()));
			});
			this.toolsMenu.add(menuItem);
		}
	}

}
