package namless.survivetherezombies;
import java.io.IOException;

import namless.survivetherezombies.core.FileManager;

import org.lwjgl.openal.AL;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
public class SurviveTheReZombies extends StateBasedGame{
	public static AppGameContainer container;
	public static int screenX = 800;
	public static int screenY = 600;
	public static boolean fullscreen = false;
	public static boolean showFPS = false;
	public static final int menu = 0;
	public static final int game = 1;
	public static final int gameover = 2;
	public static final int win = 3;
	public static final int cheat = 4;
	public static final int options = 5;
	public static final int highscore = 6;
	public static final int loading = 7;
	public SurviveTheReZombies(String name) {
		super(name);
		this.addState(new MainMenu(menu));
		this.addState(new Game(game));
		this.addState(new GameOver(gameover));
		this.addState(new Win(win));
		this.addState(new Cheat(cheat));
		this.addState(new OptionsMenu(options));
		this.addState(new Highscore(highscore));
		this.addState(new Loading(loading));
	}
	public static void main(String[] args) throws SlickException, IOException {
		SurviveTheReZombies game = new SurviveTheReZombies("Survive The Zombies");
		container = new AppGameContainer(game);
		container.setDisplayMode(screenX, screenY, fullscreen);
		container.setShowFPS(showFPS);
		container.setTargetFrameRate(100);
		container.start();
	}
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(game).init(gc, this);
		this.getState(gameover).init(gc, this);
		this.getState(win).init(gc, this);
		this.getState(cheat).init(gc, this);
		this.getState(options).init(gc, this);
		this.getState(highscore).init(gc, this);
		this.getState(loading).init(gc, this);
		this.enterState(loading);
	}
	@Override
	public boolean closeRequested(){
		quit();
		return false;
	}
	public static void quit(){
		AL.destroy();
		try {
			FileManager.write(Loading.file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		container.exit();
	}
}
