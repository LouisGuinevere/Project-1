package entity.button;

public class PercentageButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PercentageButton(String link, int width, int height) {
		super(link, width, height);
		this.purpose = FUNCTIONALITY.CLEAR;
	}	
}
