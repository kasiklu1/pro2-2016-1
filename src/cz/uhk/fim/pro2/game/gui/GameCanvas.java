package cz.uhk.fim.pro2.game.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameCanvas extends Canvas {

	private World world;
	
	public static final int topRect = 50;
	public static final int bottomRect = 70;
	
	private BufferedImage imageBird, imageHeart, imageTube, imageTop, imageBottom, imageBackground;
	
	public GameCanvas(World world){
		
		this.world = world;
		try {	
			imageBird = ImageIO.read(new File("assets/bird.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {	
			imageHeart = ImageIO.read(new File("assets/heart.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {	
			imageTube = ImageIO.read(new File("assets/tube.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {	
			imageTop = ImageIO.read(new File("assets/top.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {	
			imageBottom = ImageIO.read(new File("assets/bottom.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {	
			imageBackground = ImageIO.read(new File("assets/background.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void paint(Graphics g){
		
		super.paint(g);
		Bird bird = world.getBird();
		g.drawImage(imageBackground, 0, 0, MainFrame.WIDTH, MainFrame.HEIGHT - bottomRect, null);
		bird.paint(g, imageBird);
		List<Tube> tubes = world.getTubes();
		List<Heart> hearts = world.getHearts();
		
		for (Tube tr: tubes){
			
			tr.paint(g, imageTube);
		}
		
		for (Heart hr: hearts){
			
			hr.paint(g, imageHeart);
		}
		g.drawImage(imageTop, 0, 0, MainFrame.WIDTH, topRect, null);
		g.drawImage(imageBottom, 0, MainFrame.HEIGHT - bottomRect, MainFrame.WIDTH, bottomRect, null);
		
		/*g.setColor(Color.ORANGE);
		g.fillRect(0, 0, MainFrame.WIDTH, topRect);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, MainFrame.HEIGHT - bottomRect, MainFrame.WIDTH, bottomRect);
		*/
	}
	
}
