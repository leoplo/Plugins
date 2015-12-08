package plugins.editor;

import java.io.File;

import javax.swing.SwingUtilities;

public class EditorMain {

	
	public static String DIRECTORY_LOCATION;

	public static void main(String[] args) {
		DIRECTORY_LOCATION = (args.length >= 1 ? args[0] : "./dropins/plugins");

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				File pluginDirectory = new File(DIRECTORY_LOCATION);
				EventEditorFrame eventEditorFrame = new EventEditorFrame(pluginDirectory);
				eventEditorFrame.setVisible(true);
			}

		});
	}

}
