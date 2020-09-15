package view;

import java.awt.Container;

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
		Container cp = window.getContentPane();

		// creates panel and adds in order: canvas->panel->cp (container)
		JPanel panel = new JPanel();
		GameCanvas canvas = new GameCanvas(this, aimModel);
		panel.add(canvas);
		cp.add(panel);


	}

}
