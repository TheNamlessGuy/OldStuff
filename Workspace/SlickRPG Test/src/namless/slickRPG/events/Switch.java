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

public class Switch extends EventHandler{
	private int x = 0;
	private int y = 0;
	private int idX = 0;
	private int idY = 0;
	private int changeTileID = 0;
	private boolean active = false;
	private boolean[] actions = {false, false, false, false, false};
	private Image display;
	public Switch(int x, int y, int id, boolean changeTile, int changeTileID, boolean kill, boolean activateEnemySpawn, boolean showHidden, boolean showSteppedOnFunction, Level level) throws SlickException{
		idX = level.getEvents()[id].x();
		idY = level.getEvents()[id].y();
		this.x = x;
		this.y = y;
		this.changeTileID = changeTileID;
		actions[0] = changeTile;
		actions[1] = kill;
		actions[2] = activateEnemySpawn;
		actions[3] = showHidden;
		actions[4] = showSteppedOnFunction;
		display = new Image("res/images/tiles/Switch"+active+".png");
	}
	public void render(Graphics g) {
		g.drawImage(display, x*40, y*40);
	}
	public void update() throws SlickException {
		if (playerLocation()){
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
			if (actions[1]){ //Kill
				PlayLevel.player.kill();
			}
			if (actions[2]){ //Activate enemy spawn
				
			}
			if (actions[3]){ //ShowHidden
				HiddenTile.setShowHidden(!HiddenTile.showHidden);
			}
			if (actions[4]){ //ShowSteppedOnFunction
				HiddenTile.setHasSteppedOnFunction(!HiddenTile.hasSteppedOnFunction);
			}
			active = !active;
			display = new Image("res/images/tiles/Switch"+active+".png");
		}
	}
	public boolean playerLocation(){
		if (PlayLevel.player.x() == x && PlayLevel.player.y() == y){
			return true;
		}else{
			return false;
		}
	}
	public void reset() throws SlickException {
		active = false;
		display = new Image("res/images/tiles/Switch"+active+".png");
	}
}
