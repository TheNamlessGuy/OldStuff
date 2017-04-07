package namless.jatrpg;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class JAT_RPG extends StateBasedGame{
	public static AppGameContainer container;
	public static int screenX = 800;
	public static int screenY = 600;
	public static boolean fullscreen = false;
	public static boolean showFPS = false;
	public static TrueTypeFont titleFont;
	public static final int loading = 0;
	public static final int mainMenu = 1;
	public static final int connect = 2;
	public JAT_RPG(String name) {
		super(name);
		this.addState(new MainMenu(mainMenu));
		this.addState(new Loading(loading));
		this.addState(new Connect(connect));
	}
	public static void main(String[] args) throws SlickException {
		JAT_RPG game = new JAT_RPG("JAT-RPG");
		container = new AppGameContainer(game);
		container.setDisplayMode(screenX, screenY, fullscreen);
		container.setShowFPS(showFPS);
		container.setTargetFrameRate(100);
		container.start();
	}
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(loading).init(gc, this);
		this.enterState(loading);
	}
	@Override
	public boolean closeRequested(){
		quit();
		return false;
	}
	public static void quit(){
		container.exit();
	}
}
