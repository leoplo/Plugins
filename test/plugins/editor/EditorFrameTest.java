package plugins.editor;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;

import org.junit.Test;

public class EditorFrameTest {

	@Test
	public void creationTest() {
		EditorFrame editorFrame = new EditorFrame();
		Dimension defaultDimension = new Dimension(EditorFrame.DEFAULT_HEIGHT, EditorFrame.DEFAULT_WIDTH);
		assertEquals("Extendable Editor", editorFrame.getTitle());
		assertEquals(defaultDimension, editorFrame.getSize());
	}

}
