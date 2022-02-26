package entity.button;

public class PowerButton extends Button{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double exponential;
	
	public PowerButton(String link, int width, int height) {
		super(link, width, height);
	}
	
	public PowerButton(String link, int width, int height, double exponential) {
		super(link, width, height);
		this.exponential = exponential;
	}
	
	public double getExponential() {
		return this.exponential;
	}
}
