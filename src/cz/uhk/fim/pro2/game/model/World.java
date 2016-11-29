package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

public class World {

	private Bird bird;
	private List<Tube> tubes;
	
	
	public World(Bird bird){
		
		this.bird = bird;
		tubes = new ArrayList<Tube>();
	}
}
