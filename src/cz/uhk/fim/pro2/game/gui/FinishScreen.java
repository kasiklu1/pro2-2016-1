package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;
import cz.uhk.fim.pro2.game.model.World;

public class FinishScreen extends Screen {

		JLabel jScoreLabel, jEndLabel;
		JButton jButtonBack, jButtonPlay;
		
		public FinishScreen(MainFrame mainFrame, World world){
			
			super(mainFrame);
			int score = world.getBird().getScore();
			ScoreManager.putScore(score);
			
			jEndLabel = new JLabel("Konec hry!");
			jEndLabel.setFont(new Font("Arial", Font.BOLD, 40));
			jEndLabel.setBounds(130, 200, 280, 50);
			add(jEndLabel);
			
			jScoreLabel = new JLabel("Získal jsi bodù: " + score);
			jScoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
			jScoreLabel.setBounds(50, 400, 280, 50);
			add(jScoreLabel);
			
			jButtonBack = new JButton("BACK");
			jButtonBack.setBounds(10, 13, 75, 25);
			add(jButtonBack);
			ActionListener lsn1 = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					mainFrame.setScreen(new HomeScreen(mainFrame));
				}
			};
			jButtonBack.addActionListener(lsn1);
			
			jButtonPlay = new JButton("PLAY AGAIN");
			jButtonPlay.setBounds(95, 13, 125, 25);
			add(jButtonPlay);
			ActionListener lsn2 = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					mainFrame.setScreen(new GameScreen(mainFrame));
				}
			};
			jButtonPlay.addActionListener(lsn2);
		}
}
