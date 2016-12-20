package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;

public class ScoreScreen extends Screen {
	
	public ScoreScreen(MainFrame mainFrame){
		super(mainFrame);
		
		JLabel jScoreLabel = new JLabel("Nejvyšší dosažené skóre:");
		jScoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
		jScoreLabel.setBounds(10, 150, 350, 50);
		add(jScoreLabel);
		
		for(int i = 0; i < ScoreManager.getList().size(); i++){
			if(i > 9){
				
				break;
			}
			int score = ScoreManager.getList().get(i);
			ScoreItem scoreItem = new ScoreItem(i + 1, score);
			scoreItem.setBounds(30, 220 + i * 35, 200, 35);
			add(scoreItem);
			
		}
		JButton jButtonBack = new JButton("BACK");
		jButtonBack.setBounds(10, 13, 75, 25);
		jButtonBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));		
			}
		});
		add(jButtonBack);
		jButtonBack.setVisible(true);
		
		
		
		
	}

}
