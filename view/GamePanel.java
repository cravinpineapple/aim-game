package view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameEventListener;
import model.Aim;

public class GamePanel {
	
	private JFrame window;
	private Aim aimModel;
	GameCanvas canvas;

	public GamePanel(JFrame window, Aim aimModel) {
		this.window = window;
		this.aimModel = aimModel;
	}

	public void init() {
		Container cp = window.getContentPane();

		// creates panel and adds in order: canvas->panel->cp (container)
		JPanel panel = new JPanel();
		canvas = new GameCanvas(this, aimModel);
		panel.add(canvas);
		cp.add(panel);

		GameEventListener gameEventListener = new GameEventListener(this, aimModel);
		canvas.addMouseListener(gameEventListener);
	}

	public JFrame getWindow() {
		return window;
	}

	public GameCanvas getCanvas() {
		return canvas;
	}

}
