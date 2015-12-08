package plugins;

public class CaesarCipherPlugin implements Plugin {

	protected int shift;

	public CaesarCipherPlugin(int shift) {
		this.shift = shift;
	}

	@Override
	public String transform(String text) {
		StringBuilder encodedText = new StringBuilder();

		for (Character c : text.toCharArray()) {
			if (Character.isLetter(c)) {
				char a = (Character.isUpperCase(c) ? 'A' : 'a');
				encodedText.append((char) (a + (c - a + this.shift) % 26));
			} else {
				encodedText.append(c);
			}
		}

		return encodedText.toString();
	}

	@Override
	public String getLabel() {
		return String.format("Caesar cipher %d", this.shift);
	}

}
