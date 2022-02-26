package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.Controller;
import views.basic.BasicCalculator;
import views.scientific.ScientificCalculator;

public class BasicWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JFrame frame;
	protected Controller controller;
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	public Controller getController() {
		return controller;
	}
	
	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Create the frame.
	 */
	public BasicWindow() {
		frame = new JFrame();
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu viewMenu = new JMenu("View");
		JMenu convertMenu = new JMenu("Convert");
		JMenu windowMenu = new JMenu("Window");
		
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		menuBar.add(convertMenu);
		menuBar.add(windowMenu);
		JMenuItem showThousandSeparatorsMode = new JMenuItem("Show thousand separators");
		JMenuItem rpnMode = new JMenuItem("RPN mode");
		JMenuItem decimalPlacesMode = new JMenuItem("Decimal Places");

		JMenuItem scientificView = new JMenuItem("Scientific");
		JMenuItem basicView = new JMenuItem("Basic");
		JMenuItem programmerView = new JMenuItem("Programmer");
		
		basicView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BasicCalculator calculator = new BasicCalculator();
				calculator.show();
				frame.dispose();
			}
		});
		
		scientificView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ScientificCalculator calculator = new ScientificCalculator();
				calculator.show();
				frame.dispose();
			}
		});
		
		JMenuItem areaConvertMode = new JMenuItem("Area...");
		JMenuItem currencyConvertMode = new JMenuItem("Currency...");
		JMenuItem energyConvertMode = new JMenuItem("Energy or Work...");
		JMenuItem lengthConvertMode = new JMenuItem("Length...");
		JMenuItem powerConvertMode = new JMenuItem("Power...");
		JMenuItem pressureConvertMode = new JMenuItem("Pressure...");
		JMenuItem speedConvertMode = new JMenuItem("Speed...");
		JMenuItem temperatureConvertMode = new JMenuItem("Temperature...");
		JMenuItem timeConvertMode = new JMenuItem("Time...");
		JMenuItem volumeConvertMode = new JMenuItem("Volume...");
		JMenuItem weightConvertMode = new JMenuItem("Weight and Masses...");

		viewMenu.add(basicView);
		viewMenu.add(scientificView);
		viewMenu.add(programmerView);
		viewMenu.addSeparator();
		viewMenu.add(showThousandSeparatorsMode);
		viewMenu.addSeparator();
		viewMenu.add(rpnMode);
		viewMenu.addSeparator();
		viewMenu.add(decimalPlacesMode);
		
		convertMenu.add(areaConvertMode);
		convertMenu.add(currencyConvertMode);
		convertMenu.add(energyConvertMode);
		convertMenu.add(lengthConvertMode);
		convertMenu.add(powerConvertMode);
		convertMenu.add(pressureConvertMode);
		convertMenu.add(speedConvertMode);
		convertMenu.add(temperatureConvertMode);
		convertMenu.add(timeConvertMode);
		convertMenu.add(volumeConvertMode);
		convertMenu.add(weightConvertMode);
		
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		menuBar.add(convertMenu);
		menuBar.add(windowMenu);
		frame.setJMenuBar(menuBar);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
