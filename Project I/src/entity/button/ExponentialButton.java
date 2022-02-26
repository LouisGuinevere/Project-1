package entity.button;

public class ExponentialButton extends Button{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double base;
	
	public ExponentialButton(String link, int width, int height, double base) {
		super(link, width, height);
		this.base = base;
	}

	public ExponentialButton(String link, int width, int height) {
		super(link, width, height);
	}

	public double getBase() {
		return base;
	}
}
