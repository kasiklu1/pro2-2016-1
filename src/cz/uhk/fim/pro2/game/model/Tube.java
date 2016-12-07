package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Tube {
	
	private float positionX, positionY;
	private int height;
	private Color color;
	
	
	public Tube(float positionX, int height, Color color){
		
		this.positionX = positionX;
		this.height = height;
		this.color = color;
		
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.blue);
		Rectangle rect = getRect();
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		
	}
	public Rectangle getRect(){
		
		return new Rectangle((int) getPositionX() - 25, (int) getPositionY() - 25, 50, 50 );
	}
	
	public void update(float deltaTime){
		
		positionX -= World.SPEED * deltaTime;
		
	}
	
	public float getPositionX(){
		
		return positionX;
	}
	
	public float getPositionY(){
		
		return positionY;
	}
}
