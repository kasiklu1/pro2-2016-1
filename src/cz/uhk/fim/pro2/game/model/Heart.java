package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Heart {
	
	private float positionX, positionY;
	
	
	public Heart(int positionX, int positionY){
		
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	
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
	
	public void paint(Graphics g, BufferedImage image){
		
		//g.setColor(Color.red);
		Rectangle rect = getRect();
		g.drawImage(image, rect.x, rect.y, (int)rect.getWidth(), (int)rect.getHeight() , null);
		
		
	}
	public Rectangle getRect(){
		
		return new Rectangle((int) getPositionX() - 25, (int) positionY - 25 , 50, 50);
	}


	public static float getRandomY() {
		
		return (new Random().nextFloat() * 300) + 200;
	}

}
