package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.Random;

import model.Aim;

public class GameCanvas extends JPanel {

	public static int WIDTH = 500;
	public static int HEIGHT = 500;

	private Aim aimModel;
	private GamePanel panel;

	int countDown = 4000;

	private Timer countDownTimer;
	private Timer gameTimer;

	boolean shown = false;
	boolean noShown = true;


	public GameCanvas(GamePanel panel, Aim aimModel) {
		this.panel = panel;
		this.aimModel = aimModel;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(aimModel.getBackgroundColor());
		setCountDownTimer();
		countDownTimer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		Random rand = new Random();
		
		// if statement displays '3...' '2...' '1...' 'Go!' while in READY state
		if (Aim.gameState == Aim.GameState.READY) {
			g2.setColor(Color.white);
			g2.setFont(new Font("Courier New", Font.ITALIC, 30));
			switch (countDown) {
				case 4000:
					g2.drawString("3...", 250, 250);
					break;
				case 3000:
					g2.drawString("2...", 250, 250);
					break;
				case 2000:
					g2.drawString("1...", 250, 250);
					break;
				case 1000:
					g2.drawString("Go!!!", 250, 250);
					break;
			}
		}
		else {
			// shape setting: SQUARE
			if (aimModel.getCurrentShape() == Aim.Shape.SQUARE) {
				g2.fillOval(30, 30, 300, 100);
			}
			// shape setting: CIRCLE
			else if (aimModel.getCurrentShape() == Aim.Shape.CIRCLE) {

			}
			// shape setting: TRIANGLEI 
			else {

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
						setGameTimer();
						gameTimer.start();
					}

					countDown -= 1000;

					repaint();
				}

			});
	}

	public void setGameTimer() {
		gameTimer= new Timer(aimModel.getIntervalSpeed(), new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
					repaint();
				}

			});
	}
}

