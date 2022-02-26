package entity.button;

public class HypebolicButton extends Button{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Hypebolic {
		SINH,
		COSH,
		TANH
	}
	
	private Hypebolic type;
	
	public HypebolicButton(String link, int width, int height, Hypebolic type) {
		super(link, width, height);
		this.type = type;
	}

	public Hypebolic getType() {
		return type;
	}
}
