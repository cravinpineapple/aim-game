package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Aim;

public class GamePanel {
	
	private JFrame window;
	private Aim aimModel;

	public GamePanel(JFrame window, Aim aimModel) {
		this.window = window;
		this.aimModel = aimModel;
	}

	public void init() {
		JPanel panel = new JPanel();
		
	}

}
