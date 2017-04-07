package nam.namless.KryoSlickGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class KryoSlickGameMain extends StateBasedGame{
	public static AppGameContainer container;
	public static final int mainMenu = 0;
	public static final int connect = 1;
	public static final int chatRoom = 2;
	public static final int screenX = 800;
	public static final int screenY = 600;
	public KryoSlickGameMain (String name) {
		super(name);
		this.addState(new MainMenu());
		this.addState(new Connect());
		this.addState(new ChatRoom());
	}
	public static void main(String[] args) throws SlickException {
		KryoSlickGameMain game = new KryoSlickGameMain("KryoSlickGame");
		container = new AppGameContainer(game);
		container.setDisplayMode(screenX, screenY, false);
		container.setShowFPS(false);
		container.setTargetFrameRate(100);
		container.start();
	}
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(mainMenu).init(gc, this);
		this.getState(connect).init(gc, this);
		this.getState(chatRoom).init(gc, this);
	}
}
