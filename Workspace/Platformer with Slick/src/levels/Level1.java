package levels;
import game.Maine;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import variables.*;
import core.*;
public class Level1 extends BasicGameState{
	public Level1(int state){}
	static StateBasedGame sbg;
	static boolean canMove;
	static boolean changed = false;
	Level level;
	public static float movementSpeed = 0.15f;
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		level = new Level(new Image("res/levels/level1.png"), "Level1");
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		level.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		Level1.sbg = sbg;
		Input in = gc.getInput();
		level.update(in, sbg, movementSpeed);
	}
	public int getID() {
		return 1;
	}
	public static boolean down(){
		changed = false;
		if(Numbers.charPosY >= Numbers.floorLevel){
			changed = true;
			canMove = false;
		}
		if(Numbers.charPosX >= 297 && Numbers.charPosX <= 360 && Numbers.charPosY <= Numbers.screenSizeY){
			changed = true;
			canMove = true;
		}
		if (!changed){
			canMove = true;
		}
		if (Numbers.charPosY >= Numbers.screenSizeY){
			Booleans.dead = true;
		}
		return canMove;
	}
	public static boolean up(){
		if (Numbers.charPosY <= 0){
			canMove = false;
		}else{
			canMove = true;
		}
		return canMove;
	}
	public static boolean left(){
		changed = false;
		if (Numbers.charPosX <= 0){
			//EDGE OF SCREEN
			canMove = false;
			changed = true;
		}
		if (Numbers.charPosY > Numbers.floorLevel && Numbers.charPosX < 300){
			//HOLE
			canMove = false;
			changed = true;
		}
		if (!changed){
			canMove = true;
		}
		return canMove;
	}
	public static boolean right(){
		changed = false;
		if (Numbers.charPosX >= Numbers.screenSizeX-40){
			//EDGE OF SCREEN
			canMove = false;
			changed = true;
			Level1.sbg.enterState(Maine.level2);
			Numbers.charPosX = 0;
			Numbers.charPosY = Numbers.floorLevel;
		}
		if (Numbers.charPosY > Numbers.floorLevel && Numbers.charPosX > 352){
			//HOLE
			canMove = false;
			changed = true;
		}
		if (!changed){
			canMove = true;
		}
		return canMove;
	}
}
