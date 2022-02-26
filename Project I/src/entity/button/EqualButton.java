package entity.button;

public class EqualButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EqualButton(String link, int width, int height) {
		super(link, width, height);
		this.purpose = FUNCTIONALITY.EQUAL;
	}
}
