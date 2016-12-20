package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;
import cz.uhk.fim.pro2.game.model.World;

public class FinishScreen extends Screen {

		JLabel scoreLabel;
		
		public FinishScreen(MainFrame mainFrame, World world){
			
			super(mainFrame);
			int score = world.getBird().getScore();
			
			ScoreManager.putScore(score);
			scoreLabel = new JLabel(score + "!");
			scoreLabel.setFont(new Font("Arial", Font.BOLD, 40));
			scoreLabel.setBounds(100, 400, 280, 50);
			add(scoreLabel);
			
			JButton jButtonBack = new JButton("BACK");
			jButtonBack.setBounds(50, 13, 75, 25);
			add(jButtonBack);
			ActionListener lsn1 = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					mainFrame.setScreen(new HomeScreen(mainFrame));
				}
			};
			jButtonBack.addActionListener(lsn1);
			
		}
}
