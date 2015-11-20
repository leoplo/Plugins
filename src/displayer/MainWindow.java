package displayer;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

//TODO Comment
@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	protected final int height = 700;
	protected final int width = 700;
	protected JMenu toolsMenu;
	protected JTextArea textArea;

	public MainWindow() {
		setSize(this.height, this.width);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		// this.setBackground(Color.WHITE);
		setTitle("Text Editor");
		setLayout(new BorderLayout());
		createMenu();
		createTextArea();
		add(this.textArea, BorderLayout.CENTER);
		addJMenuItem("To lowercase");
		add(this.toolsMenu, BorderLayout.NORTH);
		setVisible(true);
	}

	private JMenu createMenu() {
		toolsMenu = new JMenu("Tools");
		return toolsMenu;

	}

	private JTextArea createTextArea() {
		textArea = new JTextArea();
		return textArea;

	}

	private void addJMenuItem(String name) {
		toolsMenu.add(new JMenuItem(name));
	}

	public static void main(String[] args) {
		new MainWindow();
	}

}
