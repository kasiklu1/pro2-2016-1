package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.World;
import cz.uhk.fim.pro2.game.model.Tube;

public class GameScreen extends Screen{
	
	public GameScreen(MainFrame mainFrame){
		super(mainFrame);
		
		JButton jButtonBack = new JButton("BACK");
		JButton jButtonPause = new JButton("PAUSE");
		
		jButtonBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
				
			}
		});
		
		add(jButtonBack);
		add(jButtonPause);
		
		Bird bird = new Bird("Flapy", 240, 400);
		World world = new World(bird);
		
		world.addTube(new Tube(400, 400, Color.green));
		world.addTube(new Tube(600, 300, Color.red));
		world.addTube(new Tube(800, 500, Color.green));
		
		GameCanvas gameCanvas = new GameCanvas(world);
		add(gameCanvas);
		gameCanvas.setBounds(0,0, MainFrame.WIDTH, MainFrame.HEIGHT);
		
		
		
		
		

		
		
		
		
	}

}
