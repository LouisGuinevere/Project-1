package views.basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controllers.basic.BasicController;
import net.miginfocom.swing.MigLayout;
import utils.Configs;
import views.BasicWindow;

public class BasicCalculator extends BasicWindow{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel resultPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JLabel resultDisplay = new JLabel();
	private final Dimension BUTTON_PANEL_SIZE = new Dimension(Configs.BASIC_BUTTON_PANEL_WIDTH, Configs.BASIC_BUTTON_PANEL_HEIGHT);
	private final Dimension RESULT_PANEL_SIZE = new Dimension(Configs.BASIC_RESULT_PANEL_WIDTH, Configs.BASIC_RESULT_PANEL_HEIGHT);

	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JPanel getResultPanel() {
		return resultPanel;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public JLabel getResultDisplay() {
		return resultDisplay;
	}
	
	public void setController(BasicController controller) {
		this.controller = controller;
	}

	public BasicController getController() {
		return (BasicController) controller;
	}

	/**
	 * Launch the application.
	 */
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicCalculator calculator = new BasicCalculator();
					BasicController controller = new BasicController();
					calculator.initialize();
					calculator.setController(controller);
					calculator.getController().init(calculator);
					calculator.frame.setVisible(true);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BasicCalculator() {
		super();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.frame.setBounds(100, 100, Configs.BASIC_WINDOW_WIDTH, Configs.BASIC_WINDOW_HEIGHT);
		this.contentPane = new JPanel();
		this.contentPane.setLayout(new BorderLayout());
		this.frame.setContentPane(this.contentPane);
		
		this.resultPanel.setPreferredSize(RESULT_PANEL_SIZE);
		this.resultPanel.setMinimumSize(RESULT_PANEL_SIZE);
		this.resultPanel.setMaximumSize(RESULT_PANEL_SIZE);
		this.resultPanel.setLayout(null);
		this.resultPanel.setBackground(new Color(86,89,83,255));
		this.resultDisplay.setBounds(0, 0, Configs.BASIC_RESULT_PANEL_WIDTH, Configs.BASIC_RESULT_PANEL_HEIGHT);
		this.resultDisplay.setHorizontalAlignment(SwingConstants.SOUTH_EAST);
		this.resultDisplay.setFont(new Font("Arial", Font.PLAIN, 44));
		this.resultDisplay.setForeground(Color.white);
		this.resultDisplay.setText("0");
		this.resultPanel.add(this.resultDisplay);
		
		this.buttonPanel.setPreferredSize(BUTTON_PANEL_SIZE);
		this.buttonPanel.setMinimumSize(BUTTON_PANEL_SIZE);
		this.buttonPanel.setMaximumSize(BUTTON_PANEL_SIZE);
		this.buttonPanel.setLayout(new MigLayout("insets 0", "[]0[]0[]0[]", "[]0[]"));

		this.contentPane.add(this.resultPanel, BorderLayout.NORTH);
		this.contentPane.add(this.buttonPanel, BorderLayout.SOUTH);
	}
}
