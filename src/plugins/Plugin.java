package plugins;

/**
 * A plugin must implement a method transform which modify a text to another
 * text (like put it to lowercase).
 */
public interface Plugin {

	public String transform(String text);

	/**
	 * @return Plugin's name which is displayed in the Tools Menu.
	 */
	public String getLabel();
}
