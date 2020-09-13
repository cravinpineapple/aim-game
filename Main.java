import javax.swing.JFrame;

import view.MenuScreen;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(200, 400);
		window.setSize(1200, 1200);

		var menu = new MenuScreen(window);
		menu.init();

		window.pack();
		window.revalidate();
		window.setVisible(true);;
	}
}