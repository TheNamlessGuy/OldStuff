package namless.slickRPG;

import namless.slickRPG.core.Console;
import namless.slickRPG.core.DebugMode;
import namless.slickRPG.core.GameOverScreen;
import namless.slickRPG.core.Level;
import namless.slickRPG.core.PC;
import namless.slickRPG.playerActions.PlayerMovement;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PlayLevel extends BasicGameState {
	public static Level level;
	public static DebugMode debug;
	public static Console console;
	public static PC player;
	public static GameOverScreen gos;
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		player = new PC(false);
		debug = new DebugMode();
		console = new Console();
		gos = new GameOverScreen();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if (player.isDead()){
			gos.render(g);
		}else{
			level.render(g);
			player.render(g);
			if (player.getInventory().isActive()){
				player.getInventory().render(g);
			}
		}
		if (debug.isActive()){
			debug.render(g);
		}
		if (console.isActive()){
			console.render(g);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		Input in = gc.getInput();
		debug.update();
		if (player.isDead()){
			gos.update(in, sbg);
		}else{
			player.update();
			if (console.isActive()){
				console.update(in);
			}else if(player.getInventory().isActive()){
				player.getInventory().update(in);
			}else{
				level.update(in);
				PlayerMovement.move(in);
			}
		}
	}
	public static void reset() throws SlickException{
		player.revive();
		console.setActive(false);
		player.getInventory().setActive(false);
		level.reset();
	}
	public int getID() {
		return 1;
	}

}
