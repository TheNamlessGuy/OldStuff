package game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import core.Level;
public class Level1 extends BasicGameState{
	public Level1(int state){}
	double movementSpeed = 1.5; //Sets the movement speed of the player
	public static Level level; //Creates a new level
	public static int scoreX = 10;
	public static int scoreY = 10;
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		level = new Level(new Image("res/bg.png"), scoreX, scoreY); //Initiates the level
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		level.render(g); //Renders the level
		level.updateScoreX(scoreX);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		Input in = gc.getInput();
		level.update(in, sbg, movementSpeed); //Updates the level
	}
	public int getID() {
		return 1;
	}
}