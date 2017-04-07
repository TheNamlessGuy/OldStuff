package namless.slickRPG.supers;

import org.newdawn.slick.Graphics;

public abstract class NPC extends Object{
	public abstract void render(Graphics g);
	public abstract void talkingUpdate();
	public abstract void update();
	public abstract void reset();
	public abstract void setTalkingTo(boolean b);
}
