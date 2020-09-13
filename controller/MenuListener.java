package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MenuListener implements ActionListener {

	private JPanel panel;

	public MenuListener(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var source = e.getSource();
	}
	
}
