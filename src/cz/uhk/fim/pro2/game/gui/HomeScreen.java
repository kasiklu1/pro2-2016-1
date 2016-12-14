package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class HomeScreen extends Screen {
	
	public HomeScreen(MainFrame mainFrame){
		super(mainFrame);
		
		JButton jButtonPlay = new JButton("PLAY");
		JButton jButtonScore = new JButton("SCORE");
		//JButton jButtonSounds = new JButton("SOUND");
		JLabel jLabelName = new JLabel("Flappy Bird");
		
		jButtonPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Co se stane kdy� na tla��tko kliknu
				mainFrame.setScreen(new GameScreen(mainFrame));
			}
		});
		
		jButtonScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));
				
			}
		});
		
		add(jButtonPlay);
		add(jButtonScore);
		//add(jButtonSounds);
		add(jLabelName);
		
		jButtonPlay.setBounds(200, 400, 100, 40);
		jButtonScore.setBounds(200, 460, 100, 40);
		jLabelName.setBounds(175, 200, 200, 40);
		
		jButtonPlay.setVisible(true);
		jButtonScore.setVisible(true);
	//	jButtonSounds.setVisible(true);
		
		
		
		
	}

}
