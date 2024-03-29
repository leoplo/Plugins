package plugins.editor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This class is the main frame of this application. It contains a JTextArea to
 * write text to modify and a JMenu to select plugin to use.
 *
 */
@SuppressWarnings("serial")
// The compiler will generate a serialVersionUID if the developer didn't define
// it. In addition, this class is not serialized in this project.
public class EditorFrame extends JFrame {

	// Dimensions
	public static final int MINIMUM_HEIGHT = 300;
	public static final int MINIMUM_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 600;
	public static final int DEFAULT_WIDTH = 600;

	// Menu
	protected JMenuBar menuBar;
	protected JMenu toolsMenu;

	protected JScrollPane jScrollPane;
	protected JTextArea textArea;

	public EditorFrame() {
		this.setTitle("Extendable Editor");
		this.setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		this.setSize(DEFAULT_HEIGHT, DEFAULT_WIDTH);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.createMenu();
		this.textArea = new JTextArea();
		this.jScrollPane = new JScrollPane(this.textArea);
		this.add(this.jScrollPane, BorderLayout.CENTER);
	}

	protected void createMenu() {
		this.menuBar = new JMenuBar();
		this.toolsMenu = new JMenu("Tools");
		this.menuBar.add(this.toolsMenu);
		this.setJMenuBar(this.menuBar);
	}
}
