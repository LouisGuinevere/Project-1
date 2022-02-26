package entity.button;

public class RootButton extends Button{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int base;

	public RootButton(String link, int width, int height, int base) {
		super(link, width, height);
		this.base = base;
	}

	public RootButton(String link, int width, int height) {
		super(link, width, height);
	}
	
	public int getBase() {
		return base;
	}
}
