package cz.uhk.fim.pro2.game.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends Canvas {

	private World world;
	
	public static final int topRect = 50;
	public static final int bottomRect = 70;
	
	public GameCanvas(World world){
		
		this.world = world;
		
	}
	
	@Override
	public void paint(Graphics g){
		
		super.paint(g);
		Bird bird = world.getBird();
		bird.paint(g);
		List<Tube> tubes = world.getTubes();
		List<Heart> hearts = world.getHearts();
		
		for (Tube tr: tubes){
			
			tr.paint(g);
		}
		
		for (Heart hr: hearts){
			
			hr.paint(g);
		}
		
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, MainFrame.WIDTH, topRect);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, MainFrame.HEIGHT - bottomRect, MainFrame.WIDTH, bottomRect);
		
	}
	
}
