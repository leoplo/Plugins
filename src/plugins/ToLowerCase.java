package plugins;

public class ToLowerCase implements Plugin {

	@Override
	public String transform(String text) {
		return text.toLowerCase();
	}

	@Override
	public String getLabel() {
		return "To Lower Case";
	}

}
