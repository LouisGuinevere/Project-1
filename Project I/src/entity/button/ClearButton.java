package entity.button;

public class ClearButton extends Button {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClearButton(String link, int width, int height) {
		super(link, width, height);
		this.purpose = FUNCTIONALITY.CLEAR;
	}
}
