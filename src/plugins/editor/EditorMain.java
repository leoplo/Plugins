package plugins.editor;

import java.io.File;

import javax.swing.SwingUtilities;

public class EditorMain {

	public static final String DEFAULT_DIRECTORY_LOCATION = "./dropins/plugins/";
	public static String DIRECTORY_LOCATION;

	public static void main(String[] args) {
		DIRECTORY_LOCATION = (args.length >= 1 ? args[0] : DEFAULT_DIRECTORY_LOCATION);

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
