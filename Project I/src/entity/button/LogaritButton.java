package entity.button;

public class LogaritButton extends Button{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double base;
	
	public LogaritButton(String link, int width, int height, double base) {
		super(link, width, height);
		this.base = base;
	}

	public LogaritButton(String link, int width, int height) {
		super(link, width, height);
	}

	public double getBase() {
		return base;
	}

}
