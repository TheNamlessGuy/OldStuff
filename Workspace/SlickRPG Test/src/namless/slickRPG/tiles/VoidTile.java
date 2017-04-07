package namless.slickRPG.tiles;

import namless.slickRPG.supers.Tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class VoidTile extends Tile{
	public VoidTile(){}
	public void render(Graphics g) {}
	public void update() {}
	public int getID() {return 0;}
	public void setPlayerSpawn(boolean b) {}
	public void setEnemySpawn(boolean b) {}
	public boolean canWalkOn() {return false;}
	public boolean isPlayerSpawn() {return false;}
	public boolean isEnemySpawn() {return false;}
	public boolean isPlayerLocation() {return false;}
	public void setPlayerLocation(boolean b) {}
	public int x() {return 0;}
	public int y() {return 0;}
	public Image getImage() {return null;}
	public void setCanWalkOn(boolean b) {}
}
