package namless.slickRPG.supers;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Item extends Object{
	public static boolean infItems = false;
	public abstract Image getImage();
	public abstract void render(Graphics g);
	public abstract void action();
	public abstract void merchAction();
	public abstract void update();
	public abstract void setItemInvRefID(int id);
	public abstract void setToolTipText(String text);
	public abstract boolean isHover();
	public abstract void setHover(boolean b);
	public abstract void setItemInvRefX(int x);
	public abstract void setItemInvRefY(int y);
	public abstract int getItemInvRefID();
	public abstract int getGoldAmount();
	public abstract void setGoldAmount(int amount);
}
