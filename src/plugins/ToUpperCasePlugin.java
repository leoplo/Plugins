package plugins;

import plugins.globalstrings.GlobalStrings;

public class ToUpperCasePlugin implements Plugin {

	@Override
	public String transform(String text) {
		return text.toUpperCase();
	}

	@Override
	public String getLabel() {
		return GlobalStrings.PLUGIN_LABEL_TOUPPERCASE;
	}

}
