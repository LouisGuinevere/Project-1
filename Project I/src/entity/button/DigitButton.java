package entity.button;

public class DigitButton extends Button {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int value;
	
	public DigitButton(String link, int width, int height, int value) {
		super(link, width, height);
		this.purpose = FUNCTIONALITY.DIGIT;
		this.value = value;
	}
	
	public String getValue() {
		return Integer.toString(value);
	}
}
