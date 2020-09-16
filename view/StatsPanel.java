package view;

import java.awt.Container;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Aim;

public class StatsPanel {
	
	private JFrame window;
	private Aim aimModel;
	//private static DecimalFormat df2 = new DecimalFormat("#.##");

	private JButton playAgainButton = new JButton("Play Again?");

	public StatsPanel(JFrame window, Aim aimModel) {
		this.window = window;
		this.aimModel = aimModel;
		window.setSize(500, 500);
		window.setLocation(100, 100);
	}

	public void init() {
		Container cp = window.getContentPane();

		JPanel northPanel = new JPanel();
		// displays Score: #hit/#targets (#.##%)
		northPanel.add(new JLabel("Score: " + aimModel.clicksHit + "/" + Aim.TOTAL_TARGETS + " (" 
			+ ((aimModel.clicksHit / (double) Aim.TOTAL_TARGETS) * 100) + "%)"));
		cp.add(BorderLayout.NORTH, northPanel);

		JPanel centerPanel = new JPanel();
		// displays Accuracy: #hit/#missed (#.##%)
		centerPanel.add(new JLabel("Accuracy: " + aimModel.clicksHit + "/" + aimModel.totalClicks + " (" 
			+ (Math.round((aimModel.clicksHit / (double) aimModel.totalClicks) * 100) * 100) / 100.0 + "%)"));
		cp.add(BorderLayout.CENTER, centerPanel);

		JPanel southPanel = new JPanel();
		southPanel.add(playAgainButton);
		cp.add(BorderLayout.SOUTH, southPanel);

		playAgainButton.addActionListener(e -> {
			window.getContentPane().removeAll();
			var panel = new MenuScreen(window);
			panel.init();
			window.pack();
			window.revalidate();
		});

	}


}
