package entity.button;

public class ReverseTrigonometricButton extends Button {
	
	public enum REVERSETRIGONOMETRIC {
		ARCSIN,
		ARCCOS,
		ARCTAN
	};
	
	private static final long serialVersionUID = 1L;
	private REVERSETRIGONOMETRIC type;

	public ReverseTrigonometricButton(String link, int width, int height, REVERSETRIGONOMETRIC type) {
		super(link, width, height);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public REVERSETRIGONOMETRIC getType() {
		return type;
	}
}
