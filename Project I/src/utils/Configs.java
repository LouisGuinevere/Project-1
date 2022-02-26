package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

public class Configs {

	public enum OPERATION {
		ADD(1),
		SUBTRACT(1),
		MULTIPLY(2),
		DIVIDE(2),
		POWER(3),
		LOGARITHM(3),
		ROOT(3);

		public final int priority;

		OPERATION(int priority) {
			this.priority = priority;
		}
	}
	
	public static final Color BUTTON_BORDER_COLOR = new Color(97,89,92,255);
	
	public static final int BASIC_WINDOW_HEIGHT = 360;
	public static final int BASIC_WINDOW_WIDTH = 240;
	public static final Dimension BASIC_WINDOW_SIZE = new Dimension(BASIC_WINDOW_WIDTH, Configs.BASIC_WINDOW_HEIGHT);
	public static final int BASIC_RESULT_PANEL_WIDTH = BASIC_WINDOW_WIDTH;
	public static final int BASIC_RESULT_PANEL_HEIGHT = 2*Configs.BASIC_WINDOW_HEIGHT/12;
	public static final int BASIC_BUTTON_PANEL_WIDTH = BASIC_WINDOW_WIDTH;
	public static final int BASIC_BUTTON_PANEL_HEIGHT = Configs.BASIC_WINDOW_HEIGHT-BASIC_RESULT_PANEL_HEIGHT-44;
	public static final int BASIC_BUTTON_WIDTH = BASIC_BUTTON_PANEL_WIDTH/4;
	public static final int BASIC_BUTTON_HEIGHT = BASIC_BUTTON_PANEL_HEIGHT/5;
	public static final Dimension BASIC_BUTTON_PANEL_SIZE = new Dimension(BASIC_BUTTON_PANEL_WIDTH, BASIC_BUTTON_PANEL_HEIGHT);
	public static final Dimension BASIC_RESULT_PANEL_SIZE = new Dimension(BASIC_RESULT_PANEL_WIDTH, BASIC_RESULT_PANEL_HEIGHT);

	public static final int SCIENTIFIC_WINDOW_HEIGHT = 360;
	public static final int SCIENTIFIC_WINDOW_WIDTH = 600;
	public static final Dimension SCIENTIFIC_WINDOW_SIZE = new Dimension(SCIENTIFIC_WINDOW_WIDTH, SCIENTIFIC_WINDOW_HEIGHT);
	public static final int SCIENTIFIC_RESULT_PANEL_WIDTH = SCIENTIFIC_WINDOW_WIDTH;
	public static final int SCIENTIFIC_RESULT_PANEL_HEIGHT = 2*SCIENTIFIC_WINDOW_HEIGHT/12;
	public static final int SCIENTIFIC_BUTTON_PANEL_WIDTH = SCIENTIFIC_WINDOW_WIDTH;
	public static final int SCIENTIFIC_BUTTON_PANEL_HEIGHT = SCIENTIFIC_WINDOW_HEIGHT-SCIENTIFIC_RESULT_PANEL_HEIGHT-44;
	public static final int SCIENTIFIC_BUTTON_WIDTH = SCIENTIFIC_BUTTON_PANEL_WIDTH/4;
	public static final int SCIENTIFIC_BUTTON_HEIGHT = SCIENTIFIC_BUTTON_PANEL_HEIGHT/5;
	public static final Dimension SCIENTIFIC_BUTTON_PANEL_SIZE = new Dimension(SCIENTIFIC_BUTTON_PANEL_WIDTH, SCIENTIFIC_BUTTON_PANEL_HEIGHT);
	public static final Dimension SCIENTIFIC_RESULT_PANEL_SIZE = new Dimension(SCIENTIFIC_RESULT_PANEL_WIDTH, SCIENTIFIC_RESULT_PANEL_HEIGHT);

	public static HashMap<String, Integer> OPERATIONS = createMap();
	private static HashMap<String, Integer> createMap() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("Add", 1);
		result.put("Subtract", 1);
		result.put("Multiply", 2);
		result.put("Divide", 2);
		result.put("Power", 3);
		result.put("Root", 3);
		result.put("Logarithm", 3);
		return result;
	}
	
	public static final String EQUAL_BUTTON_PATH = "src/Images/Equal-button.png";
	public static final String DOT_BUTTON_PATH = "src/Images/Dot-button.png";
	public static final String ZERO_BUTTON_PATH = "src/Images/0-button.png";
	public static final String ADD_BUTTON_PATH = "src/Images/Add-button.png";
	public static final String THREE_BUTTON_PATH = "src/Images/3-button.png";
	public static final String TWO_BUTTON_PATH = "src/Images/2-button.png";
	public static final String ONE_BUTTON_PATH = "src/Images/1-button.png";
	public static final String SUBTRACT_BUTTON_PATH = "src/Images/Subtract-button.png";
	public static final String SIX_BUTTON_PATH = "src/Images/6-button.png";
	public static final String FIVE_BUTTON_PATH = "src/Images/5-button.png";
	public static final String FOUR_BUTTON_PATH = "src/Images/4-button.png";
	public static final String MULTIPLY_BUTTON_PATH = "src/Images/Multiply-button.png";
	public static final String NINE_BUTTON_PATH = "src/Images/9-button.png";
	public static final String EIGHT_BUTTON_PATH = "src/Images/8-button.png";
	public static final String SEVEN_BUTTON_PATH = "src/Images/7-button.png";
	public static final String DIVIDE_BUTTON_PATH = "src/Images/Divide-button.png";
	public static final String PERCENTAGE_BUTTON_PATH = "src/Images/Percentage-button.png";
	public static final String OPPOSITE_BUTTON_PATH = "src/Images/Negative-button.png";
	public static final String CLEAR_BUTTON_PATH = "src/Images/AC-button.png";
	
	public static final String OPEN_BRACKET_BUTTON_PATH = "src/Images/open-bracket-button.png";
	public static final String CLOSE_BRACKET_BUTTON_PATH = "src/Images/close-bracket-button.png";
	public static final String SQUARE_BUTTON_PATH = "src/Images/square-button.png";
	public static final String CUBE_BUTTON_PATH = "src/Images/cube-button.png";
	public static final String Y_POWER_OF_X_BUTTON_PATH = "src/Images/power-button.png";
	public static final String X_POWER_OF_E_BUTTON_PATH = "src/Images/epower-button.png";
	public static final String X_POWER_OF_Y_BUTTON_PATH = "src/Images/y-power-x-button.png";
	public static final String X_POWER_OF_10_BUTTON_PATH = "src/Images/10power-button.png";
	public static final String SQUARE_ROOT_BUTTON_PATH = "src/Images/square-root-button.png";
	public static final String CUBE_ROOT_BUTTON_PATH = "src/Images/cube-root-button.png";
	public static final String Y_ROOT_BUTTON_PATH = "src/Images/y-root-button.png";
	public static final String LN_BUTTON_PATH = "src/Images/ln-button.png";
	public static final String LOGY_BUTTON_PATH = "src/Images/logarit-base-y-button.png";
	public static final String LOG10_BUTTON_PATH = "src/Images/logaritb10-button.png";
	public static final String X_FACTORIAL_BUTTON_PATH = "src/Images/xfactorial-button.png";
	public static final String SIN_BUTTON_PATH = "src/Images/sin-button.png";
	public static final String COS_BUTTON_PATH = "src/Images/cos-button.png";
	public static final String TAN_BUTTON_PATH = "src/Images/tan-button.png";
	public static final String ARCSIN_BUTTON_PATH = "src/Images/arcsin-button.png";
	public static final String ARCCOS_BUTTON_PATH = "src/Images/arccos-button.png";
	public static final String ARCTAN_BUTTON_PATH = "src/Images/arctan-button.png";
	public static final String E_BUTTON_PATH = "src/Images/e-button.png";
	public static final String RAD_BUTTON_PATH = "src/Images/rad-button.png";
	public static final String SINH_BUTTON_PATH = "src/Images/sinh-button.png";
	public static final String COSH_BUTTON_PATH = "src/Images/cosh-button.png";
	public static final String TANH_BUTTON_PATH = "src/Images/tanh-button.png";
	public static final String ARCSINH_BUTTON_PATH = "src/Images/arcsinh-button.png";
	public static final String ARCCOSH_BUTTON_PATH = "src/Images/arccosh-button.png";
	public static final String ARCTANH_BUTTON_PATH = "src/Images/arctanh-button.png";
	public static final String PI_BUTTON_PATH = "src/Images/pi-button.png";
	public static final String ONE_OVER_BUTTON_PATH = "src/Images/1over-button.png";
	public static final String RAND_BUTTON_PATH = "src/Images/rand-button.png";
}
