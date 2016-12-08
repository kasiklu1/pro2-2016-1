package cz.uhk.fim.pro2.game.interfaces;

import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;

public interface WorldListener {

		public void crashTube(Tube tube);
		public void crashHeart(Heart heart);
		public void outOfScene();
		
}
