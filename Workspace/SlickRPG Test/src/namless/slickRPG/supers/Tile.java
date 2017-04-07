package namless.slickRPG.supers;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Tile {
	public Tile(){
	}
	public abstract void render(Graphics g);
	public abstract void update() throws SlickException;
	
	public abstract int getID();
	public abstract void setPlayerSpawn(boolean b);
	public abstract void setEnemySpawn(boolean b);
	public abstract boolean canWalkOn();
	public abstract boolean isPlayerSpawn();
	public abstract boolean isEnemySpawn();
	public abstract boolean isPlayerLocation();
	public abstract void setPlayerLocation(boolean b);
	public abstract int x();
	public abstract int y();
	public abstract Image getImage();
	public abstract void setCanWalkOn(boolean b);
}
