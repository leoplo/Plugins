package displayer;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pluginManager.PluginFinder;
import plugins.Plugin;

/* The compiler will generate a serialVersionUID if the developer didn't define it. In addition, this class is not serialized in this project. */
@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	protected final int height = 700;
	protected final int width = 700;
	protected JScrollPane jScrollPane;
	protected JMenuBar toolsMenuBar;
	protected JMenu toolsMenu;
	protected JTextArea textArea;

	public MainWindow() {
		setSize(this.height, this.width);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setTitle("Text Editor");
		setLayout(new BorderLayout());
		toolsMenuBar = new JMenuBar();
		textArea = new JTextArea();
		jScrollPane = new JScrollPane(textArea);
		add(this.jScrollPane, BorderLayout.CENTER);
		toolsMenu = new JMenu("Tools");
		toolsMenuBar.add(toolsMenu);
		setJMenuBar(toolsMenuBar);
		setVisible(true);
	}

	public void addPlugin(String file) {
		JMenuItem newPlugin = new JMenuItem(file);
		newPlugin.addActionListener(ActionEvent -> {
			try {
				// Plugin plugin = (Plugin)
				// Class.forName(newPlugin.getText()).newInstance();
				Plugin plugin = (Plugin) Class.forName("plugins." + file.substring(0, file.length() - 6)).newInstance();
				textArea.setText(plugin.transform(textArea.getText()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		toolsMenu.add(newPlugin);
	}

	public void removePlugin(String oldPlugin) {
		for (int i = 0; i < toolsMenu.getItemCount(); i++) {
			if (toolsMenu.getItem(i).getText().equals(oldPlugin)) {
				remove(toolsMenu.getItem(i));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		MainWindow mainWindow = new MainWindow();
		PluginFinder pluginFinder = new PluginFinder(new File("dropins"), mainWindow);

	}

}
