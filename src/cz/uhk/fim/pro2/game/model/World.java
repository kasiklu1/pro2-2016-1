package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import cz.uhk.fim.pro2.game.interfaces.WorldListener;

public class World {
	
	public static final int SPEED = 100;
	public static final int SPACE_BETWEEN_TUBES = 230;
	public static final int SPACE_BETWEEN_HEARTS = 575;

	private Bird bird;
	private WorldListener worldListener;
	private List<Tube> tubes;
	private List<Heart> hearts;
	private boolean generated;
	
	
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
	
/*	public void generateRandom(){
		
		for(int i = 0; i < 3; i++){
			
			addTube(new Tube(SPACE_BETWEEN_TUBES + i * SPACE_BETWEEN_TUBES, (int) Tube.getRandomHeight(), Color.green));
		}
		
		addHeart(new Heart(575, 250));
		
		generated = true;
	}*/
	
	public void regenerate(){
		
		for(Tube tube : tubes){
			
			if(tube.getPositionX() < -100){
				
				tube.setPositionX(tube.getPositionX() + tubes.size() * SPACE_BETWEEN_TUBES);
				tube.setHeight((int)Tube.getRandomHeight());
				tube.setCounted(false);
			}
		}
		
		for(Heart heart : hearts){
			
			if(heart.getPositionX() < -100){
				
				heart.setPositionX(heart.getPositionX() + (hearts.size() + 3 ) * SPACE_BETWEEN_HEARTS);
				heart.setPositionY((int)Heart.getRandomY());
			}
		}
	}
	
	public void update(float deltaTime){
		if(generated){
			
			regenerate();
		}
		
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

	public boolean getGenerated() {
		
		return generated;
	}

	public void setGenerated(boolean generated) {
		
		this.generated = generated;
	}
}
