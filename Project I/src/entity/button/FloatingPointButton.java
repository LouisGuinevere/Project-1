package entity.button;

public class FloatingPointButton extends Button{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FloatingPointButton(String link, int width, int height) {
		super(link, width, height);
		this.purpose = FUNCTIONALITY.FLOATINGPOINT;
	}
	
}
