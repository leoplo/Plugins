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
		toolsMenu.add(new JMenuItem("TMP"));
	}

	public static void main(String[] args) throws IOException {
		MainWindow mainWindow = new MainWindow();
		PluginFinder pluginFinder = new PluginFinder(new File("dropins"),mainWindow.toolsMenu);

		
	}

}
