package controllers.scientific;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.Controller;
import entity.button.ClearButton;
import entity.button.DigitButton;
import entity.button.EButton;
import entity.button.EqualButton;
import entity.button.ExponentialButton;
import entity.button.FactorialButton;
import entity.button.FloatingPointButton;
import entity.button.HypebolicButton;
import entity.button.HypebolicButton.Hypebolic;
import entity.button.LogaritButton;
import entity.button.OneOverButton;
import entity.button.OperationButton;
import utils.Configs.OPERATION;
import entity.button.OppositeButton;
import entity.button.PercentageButton;
import entity.button.PiButton;
import entity.button.PowerButton;
import entity.button.RadianButton;
import entity.button.RandomButton;
import entity.button.ReverseHypebolicButton;
import entity.button.ReverseHypebolicButton.REVERSEHYPEBOLIC;
import entity.button.ReverseTrigonometricButton;
import entity.button.ReverseTrigonometricButton.REVERSETRIGONOMETRIC;
import entity.button.RootButton;
import entity.button.TrigonometricButton;
import entity.button.TrigonometricButton.TRIGONOMETRIC;
import utils.Configs;
import utils.Utils;
import views.scientific.ScientificCalculator;

public class ScientificController extends Controller{

	private ScientificCalculator calculator;
	private boolean trigger = false;
	private int previousOperationPriority = 0;
	private DecimalFormat df = new DecimalFormat("#.#");
	private DecimalFormat df15 = new DecimalFormat("#.###############");
	private String trigonometricMeasurement = "Degree";

	public void init(ScientificCalculator calculator) {
		this.calculator = calculator;
		this.stack.add("0");
		JPanel buttonPanel = calculator.getButtonPanel();
		ArrayList<DigitButton> digitButtons = new ArrayList<DigitButton>();
		ArrayList<OperationButton> operationButtons = new ArrayList<OperationButton>();
		ArrayList<TrigonometricButton> trigonometricButtons = new ArrayList<TrigonometricButton>();
		ArrayList<ReverseTrigonometricButton> reversetrigonometricButtons = new ArrayList<ReverseTrigonometricButton>();
		ArrayList<HypebolicButton> hypebolicButtons = new ArrayList<HypebolicButton>();
		ArrayList<ReverseHypebolicButton> reversehypebolicButtons = new ArrayList<ReverseHypebolicButton>();
		ArrayList<PowerButton> powerButtons = new ArrayList<PowerButton>();
		ArrayList<ExponentialButton> exponentialButtons = new ArrayList<ExponentialButton>();
		ArrayList<LogaritButton> logaritButtons = new ArrayList<LogaritButton>();
		ArrayList<RootButton> rootButtons = new ArrayList<RootButton>();
		
		PowerButton squareButton = new PowerButton(Configs.SQUARE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 2);
		buttonPanel.add(squareButton);
		powerButtons.add(squareButton);
		
		PowerButton cubeButton = new PowerButton(Configs.CUBE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 3);
		buttonPanel.add(cubeButton);
		powerButtons.add(cubeButton);
		
		PowerButton yPowerButton = new PowerButton(Configs.Y_POWER_OF_X_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(yPowerButton);
		powerButtons.add(yPowerButton);
		
		ExponentialButton exponentialBaseEButton = new ExponentialButton(Configs.X_POWER_OF_E_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, Math.E);
		buttonPanel.add(exponentialBaseEButton);
		exponentialButtons.add(exponentialBaseEButton);
		
		ExponentialButton exponentialBase10Button = new ExponentialButton(Configs.X_POWER_OF_10_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 10);
		buttonPanel.add(exponentialBase10Button);
		exponentialButtons.add(exponentialBase10Button);
		
		ExponentialButton exponentialBaseYButton = new ExponentialButton(Configs.X_POWER_OF_Y_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(exponentialBaseYButton);
		exponentialButtons.add(exponentialBaseYButton);
		
		ClearButton clearButton = new ClearButton(Configs.CLEAR_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(clearButton);

		OppositeButton oppositeButton = new OppositeButton(Configs.OPPOSITE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(oppositeButton);
		
		PercentageButton percentageButton = new PercentageButton(Configs.PERCENTAGE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(percentageButton);
		
		OperationButton divideButton = new OperationButton(Configs.DIVIDE_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, OPERATION.DIVIDE);
		buttonPanel.add(divideButton, "wrap");
		operationButtons.add(divideButton);
		
		RootButton squareRootButton = new RootButton(Configs.SQUARE_ROOT_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 2);
		buttonPanel.add(squareRootButton);
		rootButtons.add(squareRootButton);
		
		RootButton cubeRootButton = new RootButton(Configs.CUBE_ROOT_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 3);
		buttonPanel.add(cubeRootButton);
		rootButtons.add(cubeRootButton);

		RootButton yRootButton = new RootButton(Configs.Y_ROOT_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(yRootButton);
		rootButtons.add(yRootButton);
		
		LogaritButton naturalLogaritButton = new LogaritButton(Configs.LN_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, Math.E);
		buttonPanel.add(naturalLogaritButton);
		logaritButtons.add(naturalLogaritButton);
		
		LogaritButton logaritBase10Button = new LogaritButton(Configs.LOG10_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 10);
		buttonPanel.add(logaritBase10Button);
		logaritButtons.add(logaritBase10Button);

		LogaritButton logaritBaseYButton = new LogaritButton(Configs.LOGY_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(logaritBaseYButton);
		logaritButtons.add(logaritBaseYButton);

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
		
		RadianButton radButton = new RadianButton(Configs.RAD_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(radButton);
		
		FactorialButton factorialButton = new FactorialButton(Configs.X_FACTORIAL_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(factorialButton);

		EButton eButton = new EButton(Configs.E_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(eButton);
		
		PiButton piButton = new PiButton(Configs.PI_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(piButton);
		
		OneOverButton oneOverButton = new OneOverButton(Configs.ONE_OVER_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(oneOverButton);
		
		RandomButton randomButton = new RandomButton(Configs.RAND_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(randomButton);

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
		
		HypebolicButton sinhButton = new HypebolicButton(Configs.SINH_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, Hypebolic.SINH);
		buttonPanel.add(sinhButton);
		hypebolicButtons.add(sinhButton);
		
		HypebolicButton coshButton = new HypebolicButton(Configs.COSH_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, Hypebolic.COSH);
		buttonPanel.add(coshButton);
		hypebolicButtons.add(coshButton);

		HypebolicButton tanhButton = new HypebolicButton(Configs.TANH_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, Hypebolic.TANH);
		buttonPanel.add(tanhButton);
		hypebolicButtons.add(tanhButton);
		
		ReverseHypebolicButton arcsinhButton = new ReverseHypebolicButton(Configs.ARCSINH_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, REVERSEHYPEBOLIC.ARCSINH);
		buttonPanel.add(arcsinhButton);
		reversehypebolicButtons.add(arcsinhButton);
		
		ReverseHypebolicButton arccoshButton = new ReverseHypebolicButton(Configs.ARCCOSH_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, REVERSEHYPEBOLIC.ARCCOSH);
		buttonPanel.add(arccoshButton);
		reversehypebolicButtons.add(arccoshButton);

		ReverseHypebolicButton arctanhButton = new ReverseHypebolicButton(Configs.ARCTANH_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, REVERSEHYPEBOLIC.ARCTANH);
		buttonPanel.add(arctanhButton);
		reversehypebolicButtons.add(arctanhButton);
		
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
		
		TrigonometricButton sinButton = new TrigonometricButton(Configs.SIN_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, TRIGONOMETRIC.SIN);
		buttonPanel.add(sinButton);
		trigonometricButtons.add(sinButton);
		
		TrigonometricButton cosButton = new TrigonometricButton(Configs.COS_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, TRIGONOMETRIC.COS);
		buttonPanel.add(cosButton);
		trigonometricButtons.add(cosButton);
		
		TrigonometricButton tanButton = new TrigonometricButton(Configs.TAN_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, TRIGONOMETRIC.COS);
		buttonPanel.add(tanButton);
		trigonometricButtons.add(tanButton);
		
		ReverseTrigonometricButton arcsinButton = new ReverseTrigonometricButton(Configs.ARCSIN_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, REVERSETRIGONOMETRIC.ARCSIN);
		buttonPanel.add(arcsinButton);
		reversetrigonometricButtons.add(arcsinButton);
		
		ReverseTrigonometricButton arccosButton = new ReverseTrigonometricButton(Configs.ARCCOS_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, REVERSETRIGONOMETRIC.ARCCOS);
		buttonPanel.add(arccosButton);
		reversetrigonometricButtons.add(arccosButton);
		
		ReverseTrigonometricButton arctanButton = new ReverseTrigonometricButton(Configs.ARCTAN_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, REVERSETRIGONOMETRIC.ARCTAN);
		buttonPanel.add(arctanButton);
		reversetrigonometricButtons.add(arctanButton);
		
		DigitButton zeroButton = new DigitButton(Configs.ZERO_BUTTON_PATH, 2*Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT, 0);
		buttonPanel.add(zeroButton, "span 2");
		digitButtons.add(zeroButton);

		FloatingPointButton floatingPointButton = new FloatingPointButton(Configs.DOT_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(floatingPointButton);
		
		EqualButton equalButton = new EqualButton(Configs.EQUAL_BUTTON_PATH, Configs.BASIC_BUTTON_WIDTH, Configs.BASIC_BUTTON_HEIGHT);
		buttonPanel.add(equalButton);
		
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleClearClick();
			}
		});
		
		//add actionListener
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
		
		for (PowerButton pb: powerButtons) {
			pb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					handlePowerClick(pb.getExponential());
				}
			});	
		}
		
		for (ExponentialButton eb: exponentialButtons) {
			eb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					handleExponentialClick(eb.getBase());
				}
			});
		}
		
		piButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handlePiClick();
			}
		});
		
		eButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleEClick();
			}
		});
		
		for (TrigonometricButton tb: trigonometricButtons) {
			tb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					handleTrigonometricClick(tb);
				}
			});
		}
		
		for (ReverseTrigonometricButton rtb: reversetrigonometricButtons) {
			rtb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					handleReverserigonometricClick(rtb);
				}
			});
		}
		
		for (HypebolicButton hb: hypebolicButtons) {
			hb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					handleHypebolicClick(hb);
				}
			});
		}
		
		for (ReverseHypebolicButton rhb: reversehypebolicButtons) {
			rhb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					handleReverseHypebolicClick(rhb);
				}
			});
		}
		
		for (LogaritButton lb: logaritButtons) {
			lb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					handleLogaritClick(lb.getBase());
				}
			});
		}
		
		for (RootButton rb: rootButtons) {
			rb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					handleRootClick(rb.getBase());
				}
			});
		}
		
		radButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadianClick();
			}
		});
		
		oneOverButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleInverseClick();
			}
		});
		
		randomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRandomClick();
			}
		});
		
		factorialButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleFactorialClick();
			}
		});
	}
	
	/**
	 * Solve previous math operation in stack
	 * @return result of the math operation
	 */
	private double solvePreviousMathOperation(int priority) {
		double secondFactor = Double.parseDouble(stack.pop());
		String previousOperation = stack.pop();
		if (Configs.OPERATIONS.get(previousOperation) < priority) return -1;
		double firstFactor = Double.parseDouble(stack.pop());
		double newFactor = 0;
		switch (previousOperation) {
			case "Add": newFactor = firstFactor + secondFactor; break;
			case "Subtract": newFactor = firstFactor - secondFactor; break;
			case "Multiply": newFactor = firstFactor * secondFactor; break;
			case "Divide": newFactor = firstFactor / secondFactor; break;
			case "Power": newFactor = (double) Math.pow(firstFactor,  secondFactor); break;
			case "Root": newFactor = (double) Math.pow(secondFactor,  1/firstFactor); break;
			case "Logarithm": newFactor = (double) (Math.log(firstFactor)/Math.log(secondFactor)); break;
		}
		return newFactor;
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
			case "Power": newFactor = (double) Math.pow(firstFactor,  secondFactor); break;
			case "Root": newFactor = (double) Math.pow(secondFactor,  1/firstFactor); break;
			case "Logarithm": newFactor = (double) (Math.log(firstFactor)/Math.log(secondFactor)); break;
		}
		return newFactor;
	}

	private void handleDigitClick(DigitButton button) {
		if (calculator.getResultDisplay().getText().length() == 9 && Utils.isNumeric(stack.lastElement())) {
			return;
		}
		String currentDisplay = calculator.getResultDisplay().getText().toString();
		if (!trigger || currentDisplay.equals("0")) {
			if (stack.lastElement().equals("0")) stack.pop();
			updateResultDisplay(button.getValue());
			stack.push(button.getValue());
			trigger = true;
		} else {
			updateResultDisplay(currentDisplay + button.getValue());
			stack.set(stack.size()-1, currentDisplay + button.getValue());
		}
	}
	
	private void handleOperationClick(OperationButton operationButton) {
		String operation = operationButton.getFunctionality();
		String lastElement = stack.lastElement();
		
		if (stack.size() != 0 && Utils.isOperation(lastElement)) {
			stack.pop();
			stack.push(operation);
			if (Configs.OPERATIONS.get(lastElement) == 1) previousOperationPriority = 1;
			else if (Configs.OPERATIONS.get(lastElement) == 2) previousOperationPriority = 2;
			return;
		}
		
		if (Configs.OPERATIONS.get(operation) == 1) {
			if (previousOperationPriority < 1) {
				stack.push(operation);
			} else {
				while (stack.size() != 1) {
					double newFactor = solvePreviousMathOperation(1);
					stack.push(df.format(newFactor));
					updateResultDisplay(df.format(newFactor));
				}
				stack.push(operation);
			}
			previousOperationPriority = 1;
		} else {
			if (previousOperationPriority < 2) {
				stack.push(operation);
			} else {
				while (stack.size() != 1) {
					if (Configs.OPERATIONS.get(stack.elementAt(stack.size()-2)) == 1) {
						break;
					}
					double newFactor = solvePreviousMathOperation(2);
					stack.push(df.format(newFactor));
					updateResultDisplay(df.format(newFactor));
				}
				stack.push(operation);
			}
			previousOperationPriority = 2;
		}
		trigger = false;
	}
	
	private void handlePowerClick(double exponential) {
		Double currentDisplay = Double.parseDouble(calculator.getResultDisplay().getText());
		double result = 0;
		if (exponential == 0) {
			if (previousOperationPriority == 3) {
				double newFactor = solvePreviousMathOperation(3);
				if (newFactor != -1) {
					stack.push(Double.toString(newFactor));
					if (Utils.isInteger(newFactor)) {
						updateResultDisplay((int) newFactor);
					} else {
						updateResultDisplay(df.format(newFactor));
					}
				}
			}
			stack.push("Power");
			trigger = false;
			previousOperationPriority = 3;
		} else {
			result = Math.pow(currentDisplay.doubleValue(), exponential);
			stack.pop();
			stack.push(Double.toString(result));
			if (Utils.isInteger(result)) {
				updateResultDisplay((int) (result));
			}
		}
	}
	
	private void handleExponentialClick(double base) {
		double currentDisplay = Double.parseDouble(calculator.getResultDisplay().getText());
		if (base == 0) {
			if (previousOperationPriority == 3) {
				String newFactor = Double.toString(solvePreviousMathOperation(3));
				if (newFactor != "-1") {
					stack.push(newFactor);
					updateResultDisplay(newFactor);
				}
			}
			stack.push("Power");
			trigger = false;
			previousOperationPriority = 3;
		} else {
			double result = (double) Math.pow(base, currentDisplay);
			stack.pop();
			stack.push(Double.toString(result));
			updateResultDisplay(df15.format(result));
		}
	}
	
	private void handleRootClick(int base) {
		double currentDisplay = Double.parseDouble(calculator.getResultDisplay().getText());
		if (base == 0) {
			if (previousOperationPriority == 3) {
				String newFactor = Double.toString(solvePreviousMathOperation(3));
				if (newFactor != "-1") {
					stack.push(newFactor);
					updateResultDisplay(newFactor);
				}
			}
			stack.push("Root");
			trigger = false;
			previousOperationPriority = 3;
		} else {
			base = 1/base;
			double result = (double) Math.pow(base, currentDisplay);
			stack.pop();
			stack.push(Double.toString(result));
			updateResultDisplay(df15.format(result));
		}
	}

	protected void handleLogaritClick(double base) {
		double currentDisplay = Double.parseDouble(calculator.getResultDisplay().getText());
		if (base == 0) {
			if (previousOperationPriority == 3) {
				String newFactor = Double.toString(solvePreviousMathOperation(3));
				if (newFactor != "-1") {
					stack.push(newFactor);
					updateResultDisplay(newFactor);
				}
			}
			stack.push("Logarithm");
			trigger = false;
			previousOperationPriority = 3;
		} else {
			double result = (double) (Math.log(currentDisplay)/Math.log(base));
			stack.pop();
			stack.push(Double.toString(result));
			updateResultDisplay(df15.format(result));
		}
	}
	
	protected void handlePercentageClick() {
		double currentResult = Double.parseDouble(calculator.getResultDisplay().getText());
		currentResult /= (100);
		updateResultDisplay(Double.toString(currentResult));
	}
	
	protected void handleOppositeClick() {
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
	
	protected void handleFloatingPointClick() {
		if (calculator.getResultDisplay().getText().contains(".")) {
			return;
		}
		if (!Utils.isNumeric(stack.lastElement())) {
			updateResultDisplay("0.");
		} else {
			updateResultDisplay(calculator.getResultDisplay().getText() + ".");
		}
	}
	
	private void handlePiClick() {
		String pi = df15.format(Math.PI);
		stack.pop();
		stack.push(pi);
		updateResultDisplay(pi);
	}
	
	private void handleEClick() {
		String e = df15.format(Math.E);
		stack.pop();
		stack.push(e);
		updateResultDisplay(e);
	}
	
	private void handleTrigonometricClick(TrigonometricButton button) {
		double currentDisplay = Double.parseDouble(calculator.getResultDisplay().getText());
		if (trigonometricMeasurement.equals("Degree")) {
			currentDisplay = (double) Math.toRadians(currentDisplay);
		}
		double result = 0;
		switch(button.getType()) {
		case SIN: result = (double) Math.sin(currentDisplay); break;
		case COS: result = (double) Math.cos(currentDisplay); break;
		case TAN: result = (double) Math.tan(currentDisplay); break;
		}
		stack.pop();
		stack.push(Double.toString(result));
		updateResultDisplay(result);
	}
	
	private void handleHypebolicClick(HypebolicButton button) {
		double currentDisplay = Double.parseDouble(calculator.getResultDisplay().getText());
		double result = 0;
		switch(button.getType()) {
		case SINH: result = (double) Math.sinh(currentDisplay); break;
		case COSH: result = (double) Math.cosh(currentDisplay); break;
		case TANH: result = (double) Math.tanh(currentDisplay); break;
		}
		stack.pop();
		stack.push(Double.toString(result));
		updateResultDisplay(Double.toString(result));
	}
	
	protected void handleReverseHypebolicClick(ReverseHypebolicButton button) {
		double currentDisplay = Double.parseDouble(calculator.getResultDisplay().getText());
		double result = 0;
		switch(button.getType()) {
		case ARCSINH: result = (double) Utils.calculateArcsinh(currentDisplay); break;
		case ARCCOSH: result = (double) Utils.calculateArccosh(currentDisplay); break;
		case ARCTANH: result = (double) Utils.calculateArctanh(currentDisplay); break;
		}
		stack.pop();
		stack.push(Double.toString(result));
		updateResultDisplay(Double.toString(result));
	}

	protected void handleReverserigonometricClick(ReverseTrigonometricButton button) {
		double currentDisplay = Double.parseDouble(calculator.getResultDisplay().getText());
		double result = 0;
		switch(button.getType()) {
		case ARCSIN: result = (double) Math.asin(currentDisplay); break;
		case ARCCOS: result = (double) Math.acos(currentDisplay); break;
		case ARCTAN: result = (double) Math.atan(currentDisplay); break;
		}
		if (trigonometricMeasurement.equals("Degree")) {
			double resultInDegree = Math.toDegrees(result);
			if (Utils.isInteger(resultInDegree)) {
				int intResult = (int) resultInDegree;
				stack.pop();
				stack.push(Integer.toString(intResult));
				updateResultDisplay(Integer.toString(intResult));
			} else {
				result = (double) resultInDegree;
				stack.pop();
				stack.push(Double.toString(result));
				updateResultDisplay(Double.toString(result));
			}
		}
	}
	
	private void handleFactorialClick() {
		String result = null;
		try {
			int currentDisplay = Integer.parseInt(calculator.getResultDisplay().getText());
			if (currentDisplay < 0) {
				updateResultDisplay("Not a number");
			}
			result = Integer.toString(Utils.factorial(currentDisplay));
			updateResultDisplay(result);
			stack.pop();
			stack.push(result);
		} catch (Exception e) {
			updateResultDisplay("Not a number");
		}
	}
	
	private void handleRadianClick() {
		trigonometricMeasurement = (trigonometricMeasurement.equals("Radian")) ? "Degree" : "Radian";
	}
	
	private void handleInverseClick() {
		double currentDisplay = Double.parseDouble(calculator.getResultDisplay().getText());
		updateResultDisplay(1/currentDisplay);
	}
	
	private void handleRandomClick() {
		double randomNumber = Math.random();
		updateResultDisplay(df15.format(randomNumber));
	}
	
	protected void updateResultDisplay(double content) {
		String contentString = null;
		if (Utils.isInteger(content)) {
			contentString = Integer.toString((int) content);
		} else {
			contentString = Double.toString(content);
		}
		if (contentString.length() > 20) {
			JOptionPane.showMessageDialog(calculator.getFrame(), "20-digit Limitation!", "Error", JOptionPane.ERROR_MESSAGE);
			handleClearClick();
			return;
		}
		updateResultDisplay(contentString);
	}
	
	protected void updateResultDisplay(String content) {
		if (content.length() > 20) {
			JOptionPane.showMessageDialog(calculator.getFrame(), "20-digit Limitation!", "Error", JOptionPane.ERROR_MESSAGE);
			handleClearClick();
			return;
		}
		calculator.getResultDisplay().setText(content);
	}
	
	protected void handleClearClick() {
		stack.clear(); 
		previousOperationPriority = 0; 
		calculator.getResultDisplay().setText("0");
		stack.push("0");
	}

	protected void handleEqualClick() {
		double newFactor = 0;
		if (stack.size() == 1) return;
		while (stack.size() != 1) {
			newFactor = solvePreviousMathOperation();
			stack.push(Double.toString(newFactor));
		}
		updateResultDisplay(newFactor);
		previousOperationPriority = 0;
	}
	
	protected void printStack() {
		System.out.print("Stack: ");
		for (int i = 0; i < stack.size(); i++){
			System.out.print(stack.elementAt(i) + " ");
		}
		System.out.print("\n");
	}
}
