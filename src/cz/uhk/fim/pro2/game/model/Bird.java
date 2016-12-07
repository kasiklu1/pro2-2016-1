package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bird {
	
	private static final int GRAVITY = 180;
	public static final int JUMP = 380;
	public static final int DEFAULT_SCORE = 0;
	public static final int DEFAULT_LIVES = 3;
	
	private String name;
	private float positionX, positionY;
	private float speed;
	private int lives;
	private int score;
	
	
	public Bird(String name, float positionX, float positionY){
		
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
		this.speed = 0;
		this.lives = DEFAULT_LIVES;
		this.score = DEFAULT_SCORE;
		
	}

	public void goUP(){
		
		speed = JUMP;	
	}
	public void update(float deltaTime){
		
		positionY -= speed * deltaTime;
		positionY += GRAVITY * deltaTime;
		speed -= speed * deltaTime;
	}
	
	public boolean isAlive(){
		
		return lives > 0;
	}
	
	public void catchHeart(){
		
	}
	
	public void die() {
		
	}
	
	public void addLive(){
		
	}
	
	public void removeLive(){
		
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.blue);
		Rectangle rect = getRect();
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		
	}
	public Rectangle getRect(){
		
		return new Rectangle((int) getPositionX() - 25, (int) getPositionY() - 25, 50, 50 );
	}
	
	public float getPositionX(){
		
		return positionX;
	}
	
	public float getPositionY(){
		
		return positionY;
	}
}

