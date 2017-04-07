package namless.slickRPG.supers;

import org.newdawn.slick.Graphics;

public abstract class Enemy extends Object{
	public abstract void render(Graphics g);
	public abstract void update();
	public abstract void reset();
}
