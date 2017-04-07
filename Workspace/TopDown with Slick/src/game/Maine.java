package game;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import variables.*;
public class Maine extends StateBasedGame{
	public static AppGameContainer container; //The game window
	public static final int menu = 0; //Menu ID
	public static final int level1 = 1; //Level ID
	public Maine(String name) { //Creates the game
		super(name);
		this.addState(new MainMenu(menu)); //Adds state "menu"
		this.addState(new Level1(level1)); //Adds state "level"
	}
	public static void main(String[] args) throws SlickException {
		Maine game = new Maine("Survive the Zombies"); //Names the game
		container = new AppGameContainer(game); //Creates the window
		container.setDisplayMode(Numbers.screenSizeX, Numbers.screenSizeY, Booleans.fullScreen); //Sets boundaries
		container.setShowFPS(Booleans.debugMode); //Changes if you show the FPS
		container.start(); //Start the game
	}
	public void initStatesList(GameContainer gc) throws SlickException {
		//Initiates all the states
		this.getState(menu).init(gc, this);
		this.getState(level1).init(gc, this);
		//Sets which state to start the game on
		this.enterState(menu);
	}
}