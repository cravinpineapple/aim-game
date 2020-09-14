package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Aim;

public class GameCanvas extends JPanel {

	public static int WIDTH = 1000;
	public static int HEIGHT = 1000;

	private Aim aimModel;
	private GamePanel panel;

	int countDown = 4000;

	private Timer countDownTimer;
	private Timer gameTimer;


	public GameCanvas(GamePanel panel, Aim aimModel) {
		this.panel = panel;
		this.aimModel = aimModel;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		if (Aim.gameState == Aim.GameState.READY) {
			switch (countDown) {
				case 4000:
					// 3...
					break;
				case 3000:
					// 2...
					break;
				case 2000:
					// 1...
					break;
				case 1000:
					// Go!
					break;
			}
		}
	}

	// Timer for intro countdown
	public void setCountDownTimer() {
		countDownTimer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
					// shuts off countdown timer and begins game.
					if (countDown == 0) {
						Aim.gameState = Aim.GameState.PLAYING;
						countDownTimer.stop();
					}

					countDown -= 1000;

					repaint();
				}

			});
	}

	public void setGameTimer() {
		gameTimer= new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
					
					repaint();
				}

			});
	}
}

