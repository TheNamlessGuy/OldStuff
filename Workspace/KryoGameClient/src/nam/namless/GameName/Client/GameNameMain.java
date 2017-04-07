package nam.namless.GameName.Client;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameNameMain extends StateBasedGame{
	public static AppGameContainer container;
	public static final int mainMenu = 0;
	public static final int playGame = 1;
	public static final int connecting = 2;
	public static final int screenX = 800;
	public static final int screenY = 600;
	public static final int tileX = 40;
	public static final int tileY = 40;
	public GameNameMain(String name){
		super(name);
		this.addState(new MainMenu());
		this.addState(new Play());
		this.addState(new Connecting());
	}
	public static void main(String[] args) throws SlickException {
		GameNameMain game = new GameNameMain("GameName");
		container = new AppGameContainer(game);
		container.setDisplayMode(screenX, screenY, false);
		container.setShowFPS(false);
		container.setTargetFrameRate(100);
		container.start();
	}
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(mainMenu).init(gc, this);
		this.getState(playGame).init(gc, this);
		this.getState(connecting).init(gc, this);
	}
}
