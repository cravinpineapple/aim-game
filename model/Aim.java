package model;

import java.awt.Color;

import view.MenuScreen;

public class Aim {
	public enum Shape {
		SQUARE, CIRCLE, TRIANGLE
	}

	public enum GameState {
		READY, PLAYING, DONE
	}

	public static GameState gameState = GameState.READY;
	
	// settings variables
	private Color backgroundColor;
	private Color shapeColor;
	private Shape currentShape;
	private int intervalSpeed;
	private int targetSize;

	// score tracking variables
	final public static int TOTAL_TARGETS = 5; // *** CHANGE TO 20
	public int currentTarget = 0;
	public int totalClicks;
	public int clicksHit;

	
	public void init(MenuScreen menu) {
		updateGameSettings(menu);
		totalClicks = 0;
		clicksHit = 0;
		currentTarget = 0;
		gameState = GameState.READY;

	}

	public void updateGameSettings(MenuScreen menu) {
		setBackgroundColor(menu.getSelected(menu.getBackgroundColorButtons()));
		setShapeColor(menu.getSelected(menu.getShapeColorButtons()));
		setTargetShape(menu.getSelected(menu.getTargetShapeButtons()));
		setIntervalSpeed(menu.getSelected(menu.getIntervalSpeedButtons()));
		setTargetSize(menu.getSelected(menu.getTargetSizeButtons()));
		System.out.println("\n\n\n");
		System.out.println(backgroundColor);
		System.out.println(shapeColor);
		System.out.println(currentShape);
		System.out.println(targetSize);
		System.out.println(intervalSpeed);
	}

	void setBackgroundColor(int i) {
		switch (i) {
			case 0:
				backgroundColor = Color.white;
				break;
			case 1:
				backgroundColor = Color.gray;
				break;
			case 2:
				backgroundColor = Color.black;
				break;
		}
	}

	void setShapeColor(int i) {
		switch (i) {
			case 0:
				shapeColor = Color.red;
				break;
			case 1:
				shapeColor = Color.green;
				break;
			case 2:
				shapeColor = Color.blue;
				break;
		}
	}

	void setTargetShape(int i) {
		switch (i) {
			case 0:
				currentShape = Shape.SQUARE;
				break;
			case 1:
				currentShape = Shape.CIRCLE;
				break;
			case 2:
				currentShape = Shape.TRIANGLE;
				break;
		}
	}

	void setIntervalSpeed(int i) {
		switch (i) {
			case 0:
				intervalSpeed = 2000;
				break;
			case 1:
				intervalSpeed = 1000;
				break;
			case 2:
				intervalSpeed = 500;
				break;
		}
	}

	void setTargetSize(int i) {
		targetSize = 50;
		targetSize *= i;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public Color getShapeColor() {
		return shapeColor;
	}

	public Shape getCurrentShape() {
		return currentShape;
	}

	public int getIntervalSpeed() {
		return intervalSpeed;
	}

	public int getTargetSize() {
		return targetSize;
	}


}
