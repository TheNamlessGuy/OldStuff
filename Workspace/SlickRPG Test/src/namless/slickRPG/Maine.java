package namless.slickRPG;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Maine extends StateBasedGame {
	public static AppGameContainer container;
	public static final int mainMenu = 0;
	public static final int playLevel = 1;
	public static int screenX = 800;
	public static int screenY = 600;

	public Maine(String name) {
		super(name);
		this.addState(new MainMenu());
		this.addState(new PlayLevel());
	}

	public static void main(String[] args) throws SlickException {
		Maine game = new Maine("Roguelike Test");
		container = new AppGameContainer(game);
		container.setDisplayMode(screenX, screenY, false);
		container.setShowFPS(false);
		container.setTargetFrameRate(100);
		container.start();
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(mainMenu).init(gc, this);
		this.getState(playLevel).init(gc, this);
	}
}
