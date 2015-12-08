package plugins;

public class ToUpperCasePlugin implements Plugin {

	@Override
	public String transform(String text) {
		return text.toUpperCase();
	}

	@Override
	public String getLabel() {
		return "To Upper Case";
	}

}
