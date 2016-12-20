package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.ScoreManager;

public class ScoreScreen extends Screen {
	
	public ScoreScreen(MainFrame mainFrame){
		super(mainFrame);
		
		for(int i = 0; i < ScoreManager.getList().size(); i++){
			
			int score = ScoreManager.getList().get(i);
			ScoreItem scoreItem = new ScoreItem(i + 1, score);
			scoreItem.setBounds(40, 200 + i * 60, 400, 60);
			add(scoreItem);
			if(i > 4){
				
				break;
			}
		}
		JButton jButtonBack = new JButton("BACK");
		jButtonBack.setBounds(50, 13, 75, 25);
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
