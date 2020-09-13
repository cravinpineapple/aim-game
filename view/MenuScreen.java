package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MenuScreen {
	
	private JFrame window;

	private JLabel backGroundColorText = new JLabel("Background Color:");
	private JLabel shapeColorText = new JLabel("Shape Color:");
	private JLabel targetShapeText = new JLabel("Target Shape:");
	private JLabel targetSizeText = new JLabel("Target Size:");
	private JLabel targetSpeedText = new JLabel("Target Speed:");

	private JRadioButton[] backgroundColorButtons = new JRadioButton[3];
	private JRadioButton[] shapeColorButtons = new JRadioButton[3];
	private JRadioButton[] targetShapeButtons = new JRadioButton[3];
	private JRadioButton[] targetSizeButtons = new JRadioButton[3];
	private JRadioButton[] targetSpeedButtons = new JRadioButton[3];

	public MenuScreen(JFrame window) {
		this.window = window;
	}

	public void init() {
		Container cp = window.getContentPane();

		// header text for menu
		JPanel northPanel = new JPanel();
		northPanel.add(new JLabel("<html>Welcome to Noah's Aim Trainer!<br />Please select from the following options:</html>"));
		cp.add(BorderLayout.NORTH, northPanel);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5, 2));
		centerPanel.add(backGroundColorText);
		//centerPanel.add(backgroundColorButtons);

		cp.add(BorderLayout.CENTER, centerPanel);
	}

	void initRadioButtons() {

	}


}
