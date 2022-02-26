package controllers;

import java.util.Stack;

public class Controller {

	protected Stack<String> stack;
	
	public Controller() {
		stack = new Stack<String>();
	}
	
	public int getStackSize() {
		return stack.size();
	}
	
	public String getStackElementAt(int index) {
		return stack.elementAt(index);
	}
}
