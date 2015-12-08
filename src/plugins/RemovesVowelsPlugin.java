package plugins;

public class RemovesVowelsPlugin implements Plugin {

	@Override
	public String transform(String text) {
		return text.replaceAll("[aeiouyAEIOUY]", "");
	}

	@Override
	public String getLabel() {
		return "Removes voyels";
	}

}
