package namless.slickRPG.tiles;

import namless.slickRPG.PlayLevel;
import namless.slickRPG.supers.Tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AirTile extends Tile{
	private int tileID = 1;
	private Image tileDisplay = null;
	private int xLocation = 0;
	private int yLocation = 0;
	private boolean canWalkOn = true;
	private boolean playerSpawn = false;
	private boolean enemySpawn = false;
	private boolean playerLocation = false;
	public AirTile(int xLocation, int yLocation, boolean playerSpawn, boolean enemySpawn) throws SlickException {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.playerSpawn = playerSpawn;
		this.enemySpawn = enemySpawn;
		tileDisplay = new Image("res/images/tiles/tile"+tileID+".png");
	}
	public void render(Graphics g) {
		g.drawImage(tileDisplay, xLocation*40, yLocation*40);
	}
	public void update() {
		if (playerLocation){
			PlayLevel.player.setLocation(xLocation, yLocation);
			PlayLevel.player.setBurning(false);
		}
	}
	public int getID() {
		return tileID;
	}
	public void setPlayerSpawn(boolean b) {
		if (b){
			int x = PlayLevel.player.getSpawnX();
			int y = PlayLevel.player.getSpawnY();
			PlayLevel.level.getTiles()[x][y].setPlayerSpawn(false);
			PlayLevel.player.setSpawn(xLocation, yLocation);
			playerSpawn = true;
		}else{
			playerSpawn = false;
		}
	}
	public void setEnemySpawn(boolean b) {
		enemySpawn = b;
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
		if (b){
			int x = PlayLevel.player.x();
			int y = PlayLevel.player.y();
			PlayLevel.level.getTiles()[x][y].setPlayerLocation(false);
			PlayLevel.player.setLocation(xLocation, yLocation);
			playerLocation = true;
		}else{
			playerLocation = false;
		}
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
		canWalkOn = b;
	}

}
