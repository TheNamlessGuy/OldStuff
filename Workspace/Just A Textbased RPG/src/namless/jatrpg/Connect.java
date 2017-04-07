package namless.jatrpg;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Connect extends BasicGameState{
	TextField ipInput;
	public Connect(int state){}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		ipInput = new TextField(gc, gc.getDefaultFont(), 100, 300, 400, 20);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.fillRect(0, 0, JAT_RPG.screenX, JAT_RPG.screenY);
		g.setColor(Color.black);
		ipInput.render(gc, g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		ipInput.setFocus(true);
	}
	public int getID() {
		return 2;
	}

}
