package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

public class World {
	
	public static final int SPEED = 100;

	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	
	
	public World(Bird bird){
		
		this.bird = bird;
		tubes = new ArrayList<Tube>();
	}
	
	public void addTube(Tube tube){
		
		tubes.add(tube);
	}
	
	public List<Tube> getTubes(){
		
		return tubes;
	}
	
	public Bird getBird(){
		
		return bird;
	}
	
	public void update(float deltaTime){
		
		bird.update(deltaTime);
		
		for(Tube tr : tubes){
			
			tr.update(deltaTime);
		}
		
	/*	for(Heart hr : hearts){
			
			hr.update(deltaTime);
		}*/
		
		
		
	}
}
