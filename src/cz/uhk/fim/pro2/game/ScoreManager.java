package cz.uhk.fim.pro2.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreManager {
	
	// DEFINICE TØÍDY
	private List<Integer> scoreList;
	private ScoreManager(){
		
		this.scoreList = new ArrayList<>();
	}
	
	public void addScore(int score){
		
		List<Integer> scoreList = getAll();
		scoreList.add(score);
		
		FileWriter fileWriter;
		try {
			
			fileWriter = new FileWriter(Game.SCORE_FILE);
			for(int value : scoreList){
				
				fileWriter.append(String.valueOf(value));
				fileWriter.append(";");
				fileWriter.append(new Date().toGMTString());
				fileWriter.append("\n");
			}
			fileWriter.flush();
			fileWriter.close();
			
		} catch (IOException e) {
			
			System.out.println("Chyba pøi ukládání");
		}
		scoreList.add(score);
	}
	
	public List<Integer> getAll(){
		
		List<Integer> scoreList = new ArrayList<>();
		FileReader fileReader;
		try {
			
			fileReader = new FileReader(Game.SCORE_FILE);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();
			String line;
			while((line = bufferedReader.readLine()) != null){
				
				String[] values = line.split(";");
				scoreList.add(Integer.valueOf(values[0]));
			}
		} catch (Exception e) {
			
			System.out.println("Chyba pøi naèítání dat ze souboru");
		}
		return scoreList;
	}
	
	//SINGLETON
	
	private static ScoreManager instance;
	
	public static ScoreManager getInstance(){
		
		if(instance == null){
			
			instance = new ScoreManager();
		}
		return instance;
	}
	
	// VEØEJNÉ STATICKÉ METODY
	
	public static void putScore(int score){
		
		getInstance().addScore(score);
	}
	
	public static List<Integer> getList(){
		
		return getInstance().getAll();
	}
}
