package namless.slickRPG.tiles;

import namless.slickRPG.PlayLevel;
import namless.slickRPG.supers.Tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BreakTile extends Tile{
	private int tileID = 1;
	private Image tileDisplay = null;
	private int xLocation = 0;
	private int yLocation = 0;
	private boolean canWalkOn = false;
	private boolean playerSpawn = false;
	private boolean enemySpawn = false;
	private boolean playerLocation = false;
	public BreakTile(int xLocation, int yLocation, boolean playerSpawn, boolean enemySpawn) throws SlickException{
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.playerSpawn = playerSpawn;
		this.enemySpawn = enemySpawn;
		tileDisplay = new Image("res/images/tiles/tile0.png");
	}
	public void render(Graphics g) {
		g.drawImage(tileDisplay, xLocation*40, yLocation*40);
	}
	public void update() throws SlickException {
		if(isBreaking()){
			if (PlayLevel.player.getInventory().containsPickaxe()){
				tileDisplay = new Image("res/images/tiles/tile1.png");
				canWalkOn = true;
			}
		}
	}
	public boolean isBreaking(){
		if (PlayLevel.player.x() == xLocation+1 && PlayLevel.player.y() == yLocation && PlayLevel.player.currentAnimation() == PlayLevel.player.playerLeft()){
			return true;
		}else if(PlayLevel.player.x() == xLocation-1 && PlayLevel.player.y() == yLocation && PlayLevel.player.currentAnimation() == PlayLevel.player.playerRight()){
			return true;
		}else if(PlayLevel.player.x() == xLocation && PlayLevel.player.y() == yLocation+1 && PlayLevel.player.currentAnimation() == PlayLevel.player.playerUp()){
			return true;
		}else if(PlayLevel.player.x() == xLocation && PlayLevel.player.y() == yLocation-1 && PlayLevel.player.currentAnimation() == PlayLevel.player.playerDown()){
			return true;
		}
		return false;
	}
	public int getID() {
		return tileID;
	}
	public void setPlayerSpawn(boolean b) {
		if (canWalkOn){
			playerSpawn = b;
		}
	}
	public void setEnemySpawn(boolean b) {
		if (canWalkOn){
			enemySpawn = b;
		}
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
		if (canWalkOn){
			playerLocation = b;
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
		canWalkOn = true;
	}

}
