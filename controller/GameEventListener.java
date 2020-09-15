package controller;

import java.awt.event.MouseListener;

import model.Aim;
import view.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GameEventListener implements ActionListener, MouseListener {

	private GamePanel panel;
	private Aim aimModel;

	int[] shapeX = new int[2]; // shape width
	int[] shapeY = new int[2]; // shape height

	public GameEventListener(GamePanel panel, Aim aimModel) {
		this.panel = panel;
		this.aimModel = aimModel;
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	public void updateShapeSize() {
		shapeX[0] = panel.getCanvas().getRandX(); // gets left most shape x
		shapeX[1] = panel.getCanvas().getRandX() + panel.getCanvas().getTargetSizeX(); // gets right most shape x

		shapeY[0] = panel.getCanvas().getRandY(); // gets top most height Y
		shapeY[1] = panel.getCanvas().getRandY() + panel.getCanvas().getTargetSizeX(); // gets bottom most height Y
	}

	private boolean clickHit(MouseEvent e) {
		// if click is within shape bounds
		if ((e.getX() >= shapeX[0] && e.getX() <= shapeX[1]) && (e.getY() >= shapeY[0] && e.getY() <= shapeY[1]))
			return true;
		else
			return false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		updateShapeSize();

		if (clickHit(e)) {
			aimModel.clicksHit++;
		}
		else {
			aimModel.clicksMissed++;
		}

		System.out.println("Clicks Hit: " + aimModel.clicksHit);
		System.out.println("Clicks Missed: " + aimModel.clicksMissed);
	}

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }

	@Override
	public void actionPerformed(ActionEvent e) { }
	
}
