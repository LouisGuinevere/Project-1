package entity.button;

import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import utils.Configs;

public class Button extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum FUNCTIONALITY {
		DIGIT,
		OPERATION,
		EQUAL,
		OPPOSITE,
		PERCENTAGE,
		FLOATINGPOINT,
		CLEAR
	}
	
	DecimalFormat df = new DecimalFormat("#.#");
	protected FUNCTIONALITY purpose;
	
	protected Button(String link, int width, int height) {
		super(new ImageIcon(link));
		Dimension size1 = new Dimension(2*width, height);
		Dimension size2 = new Dimension(width, height);
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Configs.BUTTON_BORDER_COLOR));
		this.setMaximumSize(size2);
		this.setMinimumSize(size1);
	}
}
