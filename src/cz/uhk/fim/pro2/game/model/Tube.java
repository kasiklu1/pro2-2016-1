package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Tube {
	
	private static final int GAP = 200;
	private static final int WIDTH = 50;
	
	private float positionX, positionY;
	private int height;
	private Color color;
	
	
	public Tube(float positionX, int height, Color color){
		
		this.positionX = positionX;
		this.height = height;
		this.color = color;
		
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.green);
		Rectangle rectU = getRectU();
		g.fillRect(rectU.x, rectU.y, rectU.width, rectU.height);
		
		Rectangle rectD = getRectD();
		g.fillRect(rectD.x, rectD.y, rectD.width, rectD.height);
		
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
}
