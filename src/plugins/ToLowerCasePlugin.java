package plugins;

public class ToLowerCasePlugin implements Plugin {

	@Override
	public String transform(String text) {
		return text.toLowerCase();
	}

	@Override
	public String getLabel() {
		return "To Lower Case";
	}

}
