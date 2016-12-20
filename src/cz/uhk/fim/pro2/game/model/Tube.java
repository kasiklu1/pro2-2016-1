package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Tube {
	
	private static final int GAP = 200;
	private static final int WIDTH = 50;
	
	private float positionX, positionY;
	private int height;
	private Color color;
	private boolean counted = false;
	
	
	public Tube(float positionX, int height, Color color){
		
		this.positionX = positionX;
		this.height = height;
		this.color = color;
		
	}
	
	public void paint(Graphics g, BufferedImage image){
		
	//	g.setColor(Color.green);
		Rectangle rectU = getRectU();
		g.drawImage(image, rectU.x, rectU.y, (int)rectU.getWidth(), (int)rectU.getHeight() , null);
		
		Rectangle rectD = getRectD();
		g.drawImage(image, rectD.x, rectD.y, (int)rectD.getWidth(), (int)rectD.getHeight() , null);
		
	}
	public Rectangle getRectU(){
		
		return new Rectangle((int) getPositionX() - (WIDTH / 2), height, WIDTH, (MainFrame.HEIGHT - height));
	}
	
	public Rectangle getRectD(){
		
		return new Rectangle((int) getPositionX() - (WIDTH / 2), 0, WIDTH, (height - GAP));
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
	
	public void setPositionX(float positionX) {
		
		this.positionX = positionX;
	}
	
	public void setPositionY(float positionY) {
		
		this.positionY = positionY;
	}

	public void setCounted(boolean pass) {
		
		this.counted = pass;
	}

	public float getCenterY() {
		
		return (int) (height - GAP / 2.0);
	}

	public boolean isCounted() {
		
		return counted;
	}

	public float getMaximalX() {
		
		return getPositionX() + (WIDTH / 2);
	}

	public void setHeight(int height) {
		
		this.height = height;
	}

	public static float getRandomHeight() {
		
		return (new Random().nextFloat() *300) + 200;
	}

	
}
