package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.World;
import cz.uhk.fim.pro2.game.model.Tube;

public class GameScreen extends Screen{
	
	private long lastTimeMillies;
	private Timer timer;
	private Bird bird;
	
	
	
	public GameScreen(MainFrame mainFrame){
		super(mainFrame);
		
		JButton jButtonBack = new JButton("BACK");
		JButton jButtonPause = new JButton("PAUSE");
		JLabel jLabelScore = new JLabel("Score: " + Bird.DEFAULT_SCORE);
		
		jButtonBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
				
			}
		});
		
		add(jButtonBack);
		add(jButtonPause);
		add(jLabelScore);
		
		Bird bird = new Bird("Flapy", 240, 400);
		World world = new World(bird);
		
		world.addTube(new Tube(400, 400, Color.green));
		world.addTube(new Tube(600, 300, Color.red));
		world.addTube(new Tube(800, 500, Color.green));
		
		GameCanvas gameCanvas = new GameCanvas(world);
		add(gameCanvas);
		gameCanvas.setBounds(0,0, MainFrame.WIDTH, MainFrame.HEIGHT);
		
		gameCanvas.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e){
				
				super.mousePressed(e);
				bird.goUP();
			}
		});
		
		
		timer = new Timer(20, new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				long currentTimeMillies = System.currentTimeMillis();
				float delta = (currentTimeMillies - lastTimeMillies) / 1000F;
				world.update(delta);
				
				if(!bird.isAlive()){
					
					timer.stop();
				}
				
				gameCanvas.repaint();
				lastTimeMillies = currentTimeMillies;
			}
		});
		
		jButtonPause.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (timer.isRunning()){
					
					timer.stop();
				}
				else {
					
					lastTimeMillies = System.currentTimeMillis();
					timer.start();
				}
			}
		});
		
		lastTimeMillies = System.currentTimeMillis();
		timer.start();
			
	}

}
