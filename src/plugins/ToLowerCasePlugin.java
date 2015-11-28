package plugins;

import plugins.globalstrings.GlobalStrings;

public class ToLowerCasePlugin implements Plugin {

	@Override
	public String transform(String text) {
		return text.toLowerCase();
	}

	@Override
	public String getLabel() {
		return GlobalStrings.PLUGIN_LABEL_TOLOWERCASE;
	}

}
