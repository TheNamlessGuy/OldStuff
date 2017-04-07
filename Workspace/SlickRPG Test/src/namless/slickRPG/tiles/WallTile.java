package namless.slickRPG.tiles;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import namless.slickRPG.supers.Tile;

public class WallTile extends Tile{
	private int tileID = 1;
	private Image tileDisplay = null;
	private int xLocation = 0;
	private int yLocation = 0;
	private boolean canWalkOn = false;
	private boolean playerSpawn = false;
	private boolean enemySpawn = false;
	private boolean playerLocation = false;
	public WallTile(int x, int y, boolean playerSpawn, boolean enemySpawn) throws SlickException{
		xLocation = x;
		yLocation = y;
		this.playerSpawn = playerSpawn;
		this.enemySpawn = enemySpawn;
		tileDisplay = new Image("res/images/tiles/tile2.png");
	}
	public void render(Graphics g) {
		g.drawImage(tileDisplay, xLocation*40, yLocation*40);
	}
	public void update() throws SlickException {
		
	}
	public int getID() {
		return tileID;
	}
	public void setPlayerSpawn(boolean b) {
		//Can't
	}
	public void setEnemySpawn(boolean b) {
		//Can't
	}
	public boolean canWalkOn() {
		return canWalkOn;
	}
	public boolean isPlayerSpawn() {
		return playerSpawn;
	}
	public boolean isEnemySpawn() {
		return enemySpawn;
	}
	public boolean isPlayerLocation() {
		return playerLocation;
	}
	public void setPlayerLocation(boolean b) {
		//Can't
	}
	public int x() {
		return xLocation;
	}
	public int y() {
		return yLocation;
	}
	public Image getImage() {
		return tileDisplay;
	}
	public void setCanWalkOn(boolean b) {
		//Can't
	}
}
