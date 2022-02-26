package entity.button;

public class ReverseHypebolicButton extends Button{
	
	public enum REVERSEHYPEBOLIC {
		ARCSINH,
		ARCCOSH,
		ARCTANH
	};
	
	private static final long serialVersionUID = 1L;
	private REVERSEHYPEBOLIC type;

	public ReverseHypebolicButton(String link, int width, int height, REVERSEHYPEBOLIC type) {
		super(link, width, height);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public REVERSEHYPEBOLIC getType() {
		return type;
	}
}
