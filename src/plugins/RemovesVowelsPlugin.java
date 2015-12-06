package plugins;

import plugins.globalstrings.GlobalStrings;

public class RemovesVowelsPlugin implements Plugin {

	@Override
	public String transform(String text) {
		return text.replaceAll("[aeiouyAEIOUY]", "");
	}

	@Override
	public String getLabel() {
		return GlobalStrings.PLUGIN_LABEL_REMOVESVOWELS;
	}

}