package namless.slickRPG.supers;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public abstract class EventHandler {
	public abstract void render(Graphics g);
	public abstract void update() throws SlickException;
	public abstract void reset() throws SlickException;
}
