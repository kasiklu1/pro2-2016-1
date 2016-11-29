package cz.uhk.fim.pro2.game.gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.List;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends Canvas {

	private World world;
	
	public GameCanvas(World world){
		
		this.world = world;
		
	}
	
	@Override
	public void paint(Graphics g){
		
		super.paint(g);
		Bird bird = world.getBird();
		bird.paint(g);
		List<Tube> tubes = world.getTubes();
		
		for (Tube t: tubes){
			
			t.paint(g);
		}
		
	}
	
}
