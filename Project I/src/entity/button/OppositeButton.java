package entity.button;

public class OppositeButton extends Button {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OppositeButton(String link, int width, int height) {
		super(link, width, height);
		this.purpose = FUNCTIONALITY.OPPOSITE;
	}	
}
