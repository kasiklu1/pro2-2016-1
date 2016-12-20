package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreItem extends JPanel {
	
	JLabel jLabelIndex, jLabelScore;

	public ScoreItem(int index, int score){
		
		setLayout(null);
		
		jLabelIndex = new JLabel( index + ".");
		jLabelIndex.setBounds(100, 20, 120, 40);
		jLabelIndex.setFont(new Font("Arial", Font.PLAIN, 24));
		
		jLabelScore = new JLabel(String.valueOf(score));
		jLabelScore.setBounds(140, 20, 120, 40);
		jLabelScore.setFont(new Font("Arial", Font.PLAIN, 24));
	
		add(jLabelIndex);
		add(jLabelScore);
	}
}
