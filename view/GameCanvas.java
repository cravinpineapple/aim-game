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

	public static int WIDTH = 1200;
	public static int HEIGHT = 600;

	private Aim aimModel;
	private GamePanel panel;

	// Timer stuff for countdown and canvas painting
	int countDown = 4000;
	private Timer countDownTimer;
	private Timer gameTimer;

	int targetSizeX; // width of target
	int targetSizeY; // height of target
	int randX; // random position for target (X cord)
	int randY; // random position for target (Y cord)

	boolean shown = false;
	boolean noShown = true;


	public GameCanvas(GamePanel panel, Aim aimModel) {
		this.panel = panel;
		this.aimModel = aimModel;
		targetSizeX = 50 + aimModel.getTargetSize(); // sets width for target size
		targetSizeY = 50 + aimModel.getTargetSize(); // sets height for target size
		panel.getWindow().setLocation(25, 20); // sets window caddy corner to top left 
		setPreferredSize(new Dimension(WIDTH, HEIGHT)); // sets canvas size
		setBackground(aimModel.getBackgroundColor()); // changes background color to setting form aimmodel
		setCountDownTimer();
		countDownTimer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		// if statement displays '3...' '2...' '1...' 'Go!' while in READY state
		if (Aim.gameState == Aim.GameState.READY) {
			g2.setColor(Color.red);
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
			Random rand = new Random();
			// randX & randY generates random X and Y for shape location
			randX = rand.nextInt((WIDTH - targetSizeX - 10) - 10) + 10; // (max: (Screen width - shape X size - cushion) - min (10)) + min
			randY = rand.nextInt((HEIGHT - targetSizeY - 10) - 10) + 10; //   = random number range of nextInt(max - min) - min
			g2.setColor(aimModel.getShapeColor()); // sets render color for shapes

			// shape setting: SQUARE
			if (aimModel.getCurrentShape() == Aim.Shape.SQUARE) {
				g2.fillRect(randX, randY, targetSizeX, targetSizeY);
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

	public int getRandX() {
		return randX;
	}

	public int getRandY() {
		return randY;
	}

	public int getTargetSizeX() {
		return targetSizeX;
	}

	public int getTargetSizeY() {
		return targetSizeY;
	}
}

