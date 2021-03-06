package cz.uhk.fim.pro2.game.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	protected Screen actualScreen; 
	
	public MainFrame() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Flappy BIRD");
		setResizable(false);
		
		
	}
	
	public void setScreen(Screen screen) {
		
	//	getContentPane().removeAll();
		if (actualScreen != null){
			remove(actualScreen);
		}
		actualScreen = screen;
		add(screen);
		revalidate();
		
	}

}
