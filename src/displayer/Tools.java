package displayer;

import javax.swing.JMenu;

/* The compiler will generate a serialVersionUID if the developer didn't define it. In addition, this class is not serialized in this project. */
@SuppressWarnings("serial")
public class Tools extends JMenu {
	public Tools() {
		super("Tools");
	}

	public void remove(String oldPlugin) {
		for (int i = 0; i < getItemCount(); i++) {
			if (getItem(i).getText().equals(oldPlugin)) {
				remove(getItem(i));
			}
		}
	}
}
