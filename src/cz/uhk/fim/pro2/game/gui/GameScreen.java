package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import cz.uhk.fim.pro2.game.interfaces.WorldListener;
import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.World;
import cz.uhk.fim.pro2.game.model.Tube;

public class GameScreen extends Screen implements WorldListener{
	
	private long lastTimeMillies;
	private Timer timer;
	private Bird bird;
	private String name = "Bedøich";
	
	
	
	public GameScreen(MainFrame mainFrame){
		super(mainFrame);
		
		JButton jButtonBack = new JButton("BACK");
		JButton jButtonPause = new JButton("PAUSE");
		JLabel jLabelScore = new JLabel("Score: " + Bird.DEFAULT_SCORE);
		JLabel jLabelLives = new JLabel("Životy: " + Bird.DEFAULT_LIVES);
		
		add(jButtonBack);
		add(jButtonPause);
		add(jLabelScore);
		add(jLabelLives);
		
		jButtonBack.setBounds(50, 50, 400, 100);
		
		jButtonBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
				
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
		
		bird = new Bird("Flapy", 240, 400);
		World world = new World(bird, this);
		
		world.addTube(new Tube(400, 400, Color.green));
		world.addTube(new Tube(600, 300, Color.red));
		world.addTube(new Tube(800, 500, Color.green));
		
		world.addHeart(new Heart(500, 250));
		
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
				
				jLabelLives.setText("Životy: " + bird.getLives());
				jLabelScore.setText("Score: " + bird.getScore());
				
				if(!bird.isAlive()){
					
					timer.stop();
				}
				
				gameCanvas.repaint();
				lastTimeMillies = currentTimeMillies;
			}
		});
		
		
		lastTimeMillies = System.currentTimeMillis();
		timer.start();
			
	}



	@Override
	public void crashTube(Tube tube) {
	
		bird.removeLive();
		bird.setPositionY(tube.getCenterY());
		
	}



	@Override
	public void crashHeart(Heart heart) {
		
		bird.addLive();
		heart.setPositionY(-100);
		
	}



	@Override
	public void outOfScene() {

		bird.removeLive();
		bird.setPositionY(MainFrame.HEIGHT / 2);
		bird.setSpeed(bird.JUMP / 2);
	}

}
