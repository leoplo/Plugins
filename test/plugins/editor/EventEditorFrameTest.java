package plugins.editor;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import plugins.Plugin;
import plugins.RemovesVowelsPlugin;
import plugins.ToLowerCasePlugin;
import plugins.ToUpperCasePlugin;

public class EventEditorFrameTest {

	@Test
	public void updatePluginTest() {
		EventEditorFrame eventEditorFrame = new EventEditorFrame(new File(""));
		List<Plugin> plugins = new ArrayList<Plugin>();

		plugins.add(new ToUpperCasePlugin());
		plugins.add(new RemovesVowelsPlugin());
		plugins.add(new ToLowerCasePlugin());

		assertEquals(0, eventEditorFrame.toolsMenu.getItemCount());
		eventEditorFrame.updatePlugins(plugins);
		assertEquals(plugins.size(), eventEditorFrame.toolsMenu.getItemCount());
	}
}
