package controllers.basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.Controller;
import entity.button.ClearButton;
import entity.button.DigitButton;
import entity.button.EqualButton;
import entity.button.FloatingPointButton;
import entity.button.OperationButton;
import utils.Configs.OPERATION;
import entity.button.OppositeButton;
import entity.button.PercentageButton;
import utils.Configs;
import utils.Utils;
import views.basic.BasicCalculator;

public class BasicController extends Controller{
	
	private BasicCalculator calculator;
	/*
	 *  The trigger which is on if the user had typed the first factor of a math calculation
	 */
	private boolean trigger = false;
	/*
	 *  Previous math operation priority
	 */
	private int previousOperationPriority = 0;
	/*
	 *  Floating point variable display format
	 */
	private DecimalFormat df = new DecimalFormat("#.#");

	/**
	 * Initialize calculator's basic functional components
	 * @param calculator Calculator
	 */
	public void init(BasicCalculator calculator) {
		this.calculator = calculator;
		this.stack.add("0");
		JPanel buttonPanel = calculator.getButtonPanel();
		ArrayList<DigitButton> digitButtons = new ArrayList<DigitButton>();
		ArrayList<OperationButton> operationButtons = new ArrayList<OperationButton>();
		
		//Initialize functional buttons
		ClearButton clearButton = new ClearButton(Configs.CLEAR_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(clearButton);

		OppositeButton oppositeButton = new OppositeButton(Configs.OPPOSITE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(oppositeButton);
		
		PercentageButton percentageButton = new PercentageButton(Configs.PERCENTAGE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(percentageButton);
		
		OperationButton divideButton = new OperationButton(Configs.DIVIDE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, OPERATION.DIVIDE);
		buttonPanel.add(divideButton, "wrap");
		operationButtons.add(divideButton);
		
		DigitButton sevenButton = new DigitButton(Configs.SEVEN_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 7);
		buttonPanel.add(sevenButton);
		digitButtons.add(sevenButton);
		
		DigitButton eightButton = new DigitButton(Configs.EIGHT_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 8);
		buttonPanel.add(eightButton);
		digitButtons.add(eightButton);

		DigitButton nineButton = new DigitButton(Configs.NINE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 9);
		buttonPanel.add(nineButton);
		digitButtons.add(nineButton);

		OperationButton multiplyButton = new OperationButton(Configs.MULTIPLY_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, OPERATION.MULTIPLY);
		buttonPanel.add(multiplyButton, "wrap");
		operationButtons.add(multiplyButton);
		
		DigitButton fourButton = new DigitButton(Configs.FOUR_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 4);
		buttonPanel.add(fourButton);
		digitButtons.add(fourButton);

		DigitButton fiveButton = new DigitButton(Configs.FIVE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 5);
		buttonPanel.add(fiveButton);
		digitButtons.add(fiveButton);

		DigitButton sixButton = new DigitButton(Configs.SIX_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 6);
		buttonPanel.add(sixButton);
		digitButtons.add(sixButton);

		OperationButton subtractButton = new OperationButton(Configs.SUBTRACT_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, OPERATION.SUBTRACT);
		buttonPanel.add(subtractButton, "wrap");
		operationButtons.add(subtractButton);
		
		DigitButton oneButton = new DigitButton(Configs.ONE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 1);
		buttonPanel.add(oneButton);
		digitButtons.add(oneButton);

		DigitButton twoButton = new DigitButton(Configs.TWO_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 2);
		buttonPanel.add(twoButton);
		digitButtons.add(twoButton);

		DigitButton threeButton = new DigitButton(Configs.THREE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 3);
		buttonPanel.add(threeButton);
		digitButtons.add(threeButton);

		OperationButton addButton = new OperationButton(Configs.ADD_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, OPERATION.ADD);
		buttonPanel.add(addButton, "wrap");
		operationButtons.add(addButton);
		
		DigitButton zeroButton = new DigitButton(Configs.ZERO_BUTTON_PATH, 2*Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 0);
		buttonPanel.add(zeroButton, "span 2");
		digitButtons.add(zeroButton);

		FloatingPointButton floatingPointButton = new FloatingPointButton(Configs.DOT_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(floatingPointButton);
		
		EqualButton equalButton = new EqualButton(Configs.EQUAL_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(equalButton);
		
		//Add actionListener
		for (DigitButton db: digitButtons) {
			db.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					handleDigitClick(db);
				}
			});
		}
		for (OperationButton ob: operationButtons) {
			ob.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					handleOperationClick(ob);
				}
			});
		}
		percentageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handlePercentageClick();
			}
		});
		oppositeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleOppositeClick();
			}
		});
		floatingPointButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleFloatingPointClick();
			}
		});
		equalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleEqualClick();
			}
		});
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleClearClick();
			}
		});
	}
	
	/**
	 * Solve previous math operation in stack
	 * @return result of the math operation
	 */
	private double solvePreviousMathOperation() {
		double secondFactor = Double.parseDouble(stack.pop());
		String previousOperation = stack.pop();
		double firstFactor = Double.parseDouble(stack.pop());
		double newFactor = 0;
		switch (previousOperation) {
			case "Add": newFactor = firstFactor + secondFactor; break;
			case "Subtract": newFactor = firstFactor - secondFactor; break;
			case "Multiply": newFactor = firstFactor * secondFactor; break;
			case "Divide": newFactor = firstFactor / secondFactor; break;
		}
		return newFactor;
	}
	
	/**
	 * Handle digit click (0, 1,..., 9)
	 * @param button Digit button
	 */
	private void handleDigitClick(DigitButton digitButton) {
		String digit = digitButton.getValue();
		//If the result display panel is full
		if (calculator.getResultDisplay().getText().length() == 9){
				//&& Utils.isNumeric(stack.lastElement())) {
			return;
		}
		//Else
		String currentDisplay = calculator.getResultDisplay().getText().toString();
		if (currentDisplay.equals("0") || !trigger) {
			//If the current result display value is 0 or the trigger is off
			if (stack.lastElement().equals("0")) stack.pop();
			updateResultDisplay(digit);
			stack.push(digit);
			trigger = true;
		} else {
			//Or else
			updateResultDisplay(currentDisplay + digit);
			stack.set(stack.size()-1, currentDisplay + digit);
		}
	}
	
	/**
	 * Handle operation click (+, -, *, /)
	 * @param operationButton Operation button
	 */
	private void handleOperationClick(OperationButton operationButton) {
		String operation = operationButton.getFunctionality();
		String lastElement = stack.lastElement();
		
		if (stack.size() != 0 && (Utils.isOperation(lastElement))) {
			//If the stack is empty or there was an operation pushed in the stack waiting for the second factor
			stack.pop();
			stack.push(operation);
			if (Configs.OPERATIONS.get(lastElement) == 1) previousOperationPriority = 1;
			else if (Configs.OPERATIONS.get(lastElement) == 2) previousOperationPriority = 2;
			return;
		}
		
		if (Configs.OPERATIONS.get(operation) == 1) {
			//If the operation has the first priority
			if (previousOperationPriority < 1) {
				//If the previous operation's priority < 1
				stack.push(operation);
			} else {
				//Otherwise
				while (stack.size() != 1) {
					double newFactor = solvePreviousMathOperation();
					stack.push(df.format(newFactor));
					updateResultDisplay(df.format(newFactor));
				}
				stack.push(operation);
			}
			previousOperationPriority = 1;
		} else {
			//Otherwise
			if (previousOperationPriority < 2) {
				stack.push(operation);
			} else {
				while (stack.size() != 1) {
					if (Configs.OPERATIONS.get(stack.elementAt(stack.size()-2)) == 1) {
						break;
					}
					double newFactor = solvePreviousMathOperation();
					stack.push(df.format(newFactor));
					updateResultDisplay(df.format(newFactor));
				}
				stack.push(operation);
			}
			previousOperationPriority = 2;
		}
		trigger = false;
	}
	
	/**
	 * Handle percentage click
	 */
	private void handlePercentageClick() {
		double currentResult = Double.parseDouble(calculator.getResultDisplay().getText());
		currentResult /= (100);
		updateResultDisplay(Double.toString(currentResult));
	}
	
	/**
	 * Handle opposite click
	 */
	private void handleOppositeClick() {
		for (int i = stack.size()-1; i >= 0; i--) {
			String iElement = stack.elementAt(i);
			if (Utils.isNumeric(iElement)) {
				if (iElement.charAt(0) != '-') {
					String newElement = "-" + stack.elementAt(i);
					stack.set(i, newElement);
					updateResultDisplay(newElement);
				} else {
					String newElement = iElement.substring(1);
					stack.set(i, newElement);
					updateResultDisplay(newElement);
				}
				return;
			}
		}
	}
	
	/**
	 * Handle floating point click
	 */
	private void handleFloatingPointClick() {
		if (calculator.getResultDisplay().getText().contains(".")) {
			return;
		}
		if (!Utils.isNumeric(stack.lastElement())) {
			updateResultDisplay("0.");
		} else {
			updateResultDisplay(calculator.getResultDisplay().getText() + ".");
		}
	}
	
	/**
	 * Update result display
	 * @param content Displaying content
	 */
	private void updateResultDisplay(String content) {
		if (content.length() > 9) {
			JOptionPane.showMessageDialog(calculator.getFrame(), "9-digit Limitation!", "Error", JOptionPane.ERROR_MESSAGE);
			handleClearClick();
			return;
		}
		calculator.getResultDisplay().setText(content);
	}
	
	/**
	 * Handle clear click
	 */
	private void handleClearClick() {
		stack.clear(); 
		previousOperationPriority = 0; 
		calculator.getResultDisplay().setText("0");
		stack.push("0");
	}

	/**
	 * Handle equal click
	 */
	private void handleEqualClick() {
		double newFactor = 0;
		if (stack.size() == 1) return;
		while (stack.size() != 1) {
			newFactor = solvePreviousMathOperation();
			stack.push(df.format(newFactor));
		}
		updateResultDisplay(df.format(newFactor));
		previousOperationPriority = 0;
	}
}
