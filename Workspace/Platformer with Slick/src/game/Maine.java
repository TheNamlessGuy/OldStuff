package game;
import levels.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import variables.*;
public class Maine extends StateBasedGame{
	public static AppGameContainer container;
	public static final int menu = 0;
	public static final int level1 = 1;
	public static final int level2 = 2;
	public Maine(String name) {
		super(name);
		this.addState(new MainMenu(menu));
		this.addState(new Level1(level1));
		this.addState(new Level2(level2));
	}
	public static void main(String[] args) throws SlickException {
		Maine game = new Maine("Game");
		container = new AppGameContainer(game);
		container.setDisplayMode(Numbers.screenSizeX, Numbers.screenSizeY, Booleans.fullScreen);
		container.setShowFPS(Booleans.debugMode);
		container.start();
	}
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(level1).init(gc, this);
		this.getState(level2).init(gc, this);
		this.enterState(menu);
	}
}
