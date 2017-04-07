package namless.slickRPG.events;

import namless.slickRPG.PlayLevel;
import namless.slickRPG.core.Level;
import namless.slickRPG.supers.EventHandler;
import namless.slickRPG.tiles.AirTile;
import namless.slickRPG.tiles.FireTile;
import namless.slickRPG.tiles.HiddenTile;
import namless.slickRPG.tiles.VoidTile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Button extends EventHandler{
	private Image display;
	private boolean pressed = false;
	private int idX = 0;
	private int idY = 0;
	private int x = 0;
	private int y = 0;
	private int changeTileID = 0;
	private boolean[] actions = {false, false, false, false, false};
	public Button(int x, int y, int id, boolean changeTile, int changeTileID, boolean setPlayerSpawn, boolean setEnemySpawn, boolean setPlayerLocation, boolean kill, Level level) throws SlickException{
		idX = level.getEvents()[id].x();
		idY = level.getEvents()[id].y();
		this.x = x;
		this.y = y;
		this.changeTileID = changeTileID;
		actions[0] = changeTile;
		actions[1] = setPlayerSpawn;
		actions[2] = setEnemySpawn;
		actions[3] = setPlayerLocation;
		actions[4] = kill;
		display = new Image("res/images/tiles/Button0.png");
	}
	public void render(Graphics g){
		g.drawImage(display, x*40, y*40);
	}
	public void update() throws SlickException{
		if (playerLocation() && !pressed){
			if (actions[0]){ //changeTile
				switch(changeTileID){
				case 0:
					PlayLevel.level.getTiles()[idX][idY] = new VoidTile();
					break;
				case 1:
					PlayLevel.level.getTiles()[idX][idY] = new AirTile(idX, idY, false, false);
					break;
				case 2:
					PlayLevel.level.getTiles()[idX][idY] = new FireTile(idX, idY, false, false);
					break;
				case 3:
					PlayLevel.level.getTiles()[idX][idY] = new HiddenTile(idX, idY, false, false);
					break;
				default:
					break;
				}
			}
			if (actions[1]){ //setPlayerSpawn
				PlayLevel.level.getTiles()[idX][idY].setPlayerSpawn(true);
			}
			if (actions[2]){ //setEnemySpawn
				PlayLevel.level.getTiles()[idX][idY].setEnemySpawn(true);
			}
			if (actions[3]){ //setPlayerLocation
				PlayLevel.level.getTiles()[idX][idY].setPlayerLocation(true);
			}
			if (actions[4]){ //Kill
				PlayLevel.player.kill();
			}
			pressed = true;
			display = new Image("res/images/tiles/Button1.png");
		}
	}
	public boolean playerLocation(){
		if (PlayLevel.player.x() == x && PlayLevel.player.y() == y){
			return true;
		}else{
			return false;
		}
	}
	public void reset() throws SlickException{
		pressed = false;
		display = new Image("res/images/tiles/Button0.png");
	}

}
