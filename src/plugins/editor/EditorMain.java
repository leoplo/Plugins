package plugins.editor;

import java.io.File;

public class EditorMain {

	public static String DEFAULT_DIRECTORY_LOCATION = "./dropins/plugins";

	public static void main(String[] args) {
		String directoryLocation = (args.length >= 1 ? args[0] : DEFAULT_DIRECTORY_LOCATION);

		File pluginDirectory = new File(directoryLocation);
		EventEditorFrame eventEditorFrame = new EventEditorFrame(pluginDirectory);
		eventEditorFrame.setVisible(true);
	}

}
