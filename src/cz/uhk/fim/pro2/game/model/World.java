package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

import cz.uhk.fim.pro2.game.interfaces.WorldListener;

public class World {
	
	public static final int SPEED = 100;

	private Bird bird;
	private WorldListener worldListener;
	private List<Tube> tubes;
	private List<Heart> hearts;
	
	
	public World(Bird bird, WorldListener worldListener){
		
		this.bird = bird;
		this.worldListener = worldListener;
		tubes = new ArrayList<Tube>();
		hearts = new ArrayList<Heart>();
	}
	
	public void addTube(Tube tube){
		
		tubes.add(tube);
	}
	
	public List<Tube> getTubes(){
		
		return tubes;
	}
	
	public List<Heart> getHearts(){
		
		return hearts;
	}
	
	public Bird getBird(){
		
		return bird;
	}
	
	public void update(float deltaTime){
		
		bird.update(deltaTime);
		
		if(bird.isOutOfScene()){
			
			worldListener.outOfScene();
		}
		
		for(Tube tr : tubes){
			
			tr.update(deltaTime);
			
			
			if(bird.collideWith(tr)){
				
				tr.setCounted(true);
				worldListener.crashTube(tr);
			}
			
			if(!tr.isCounted() && bird.getPositionX() >= tr.getMaximalX()){
				
				bird.addScore();
				tr.setCounted(true);
			}
		}
		
		for(Heart hr : hearts){
			
			hr.update(deltaTime);
			
				if(bird.collideWith(hr)){
				
				worldListener.crashHeart(hr);
			}
		}
		
		
		
	}

	public void addHeart(Heart heart) {
		
		hearts.add(heart);
		
	}
}
