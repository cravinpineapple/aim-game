package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MenuScreen;

public class MenuListener implements ActionListener {

	private MenuScreen panel;

	public MenuListener(MenuScreen panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//var source = e.getSource();
		panel.getAim().updateGameSettings(panel);
	}
	
}
