package cz.uhk.fim.pro2.game.model;

public class Heart {
	
	private float positionX, positionY;
	
	
	public void update(float deltaTime){
		
		positionX -= World.SPEED * deltaTime;
		
	}
	
	public void setPositionX(float positionX){
		
		this.positionX = positionX;
	}
	
	public void setPositionY(float positionY){
		
		this.positionY = positionY;
	}
	
	public float getPositionX(){
		
		return positionX;
	}
	
	public float getPositionY(){
		
		return positionY;
	}

}
