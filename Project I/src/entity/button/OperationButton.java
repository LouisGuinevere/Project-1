package entity.button;

import utils.Configs.OPERATION;

public class OperationButton extends Button {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OPERATION operation;
	
	public OperationButton(String link, int width, int height, OPERATION functionality) {
		super(link, width, height);
		this.operation = functionality;
	}
	
	public String getFunctionality() {
		switch(operation) {
		case ADD: return "Add";
		case SUBTRACT: return "Subtract";
		case MULTIPLY: return "Multiply";
		case DIVIDE: return "Divide";
		default:
			break;
		}
		return null;
	}
}
