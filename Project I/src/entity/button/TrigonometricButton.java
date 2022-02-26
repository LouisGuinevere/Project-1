package entity.button;

public class TrigonometricButton extends Button {

	/**
	 * 
	 */
	
	public enum TRIGONOMETRIC {
		SIN,
		COS,
		TAN
	};
	
	private static final long serialVersionUID = 1L;
	private TRIGONOMETRIC type;

	public TrigonometricButton(String link, int width, int height, TRIGONOMETRIC type) {
		super(link, width, height);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public TRIGONOMETRIC getType() {
		return type;
	}
}
