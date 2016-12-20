package cz.uhk.fim.pro2.game;

import cz.uhk.fim.pro2.game.gui.ScoreScreen;

import java.io.File;
import java.io.IOException;

import cz.uhk.fim.pro2.game.gui.GameScreen;
import cz.uhk.fim.pro2.game.gui.HomeScreen;
import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Game {
	
	public static final String SCORE_FILE = "score.csv";

	public static void main(String[] args) {
		
		File file = new File(SCORE_FILE);
		if(!file.exists()){
			
			try {
				
				file.createNewFile();
			} catch (IOException e) {
				
				System.out.println("Soubor nelze vytvoøit");
			}
		}
		MainFrame mainFrame = new MainFrame();
		HomeScreen homeScreen = new HomeScreen(mainFrame);	
		mainFrame.setScreen(homeScreen);
	}
}
