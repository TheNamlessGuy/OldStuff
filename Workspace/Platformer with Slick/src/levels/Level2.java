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
public class Level2 extends BasicGameState{
	
	public Level2(int state){}
	
	static StateBasedGame sbg;
	static boolean canMove;
	static boolean changed = false;
	public static float movementSpeed = 0.15f;
	Level level;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		level = new Level(new Image("res/levels/level2.png"), "Level2");
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		level.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		Level2.sbg = sbg;
		Input in = gc.getInput();
		level.update(in, sbg, movementSpeed);
	}
	public int getID() {
		return 2;
	}
	public static boolean down(){ //CHECKS IF YOU CAN MOVE DOWN
		changed = false;
		if(Numbers.charPosY >= Numbers.floorLevel){
			//FLOOR
			changed = true;
			canMove = false;
		}
		if(Numbers.charPosX >= 297 && Numbers.charPosX <= 360 && Numbers.charPosY <= Numbers.screenSizeY){
			//HOLE 1
			changed = true;
			canMove = true;
		}
		if(Numbers.charPosX >= 554 && Numbers.charPosX <= 613 && Numbers.charPosY <= Numbers.screenSizeY){
			//HOLE 2
			changed = true;
			canMove = true;
		}
		if (!changed){
			canMove = true;
		}
		if (Numbers.charPosY >= Numbers.screenSizeY){
			//DEAD
			Booleans.dead = true;
		}
		return canMove;
	}
	public static boolean up(){ //CHECKS IF YOU CAN MOVE UP
		changed = false;
		if (Numbers.charPosY <= 0){
			//TOP OF SCREEN
			canMove = false;
			changed = true;
		}
		if (!changed){
			canMove = true;
		}
		return canMove;
	}
	public static boolean left(){ //CHECKS IF YOU CAN MOVE LEFT
		changed = false;
		if (Numbers.charPosX <= 0){
			//EDGE OF SCREEN
			canMove = false;
			changed = true;
			if (Booleans.playerLeft){
				sbg.enterState(Maine.level1);
				Numbers.charPosX = Numbers.screenSizeX - 40;
				Numbers.charPosY = Numbers.floorLevel;
			}
		}
		if (Numbers.charPosY > Numbers.floorLevel && Numbers.charPosX < 300){
			//HOLE 1
			canMove = false;
			changed = true;
		}
		if (Numbers.charPosY > Numbers.floorLevel && Numbers.charPosX < 555 && Numbers.charPosX > 400){
			//HOLE 2
			canMove = false;
			changed = true;
		}
		if (!changed){
			canMove = true;
		}
		return canMove;
	}
	public static boolean right(){ //CHECKS IF YOU CAN MOVE RIGHT
		changed = false;
		if (Numbers.charPosX >= Numbers.screenSizeX-40){
			//EDGE OF SCREEN
			canMove = false;
			changed = true;
			//CHANGE LEVEL
		}
		if (Numbers.charPosY > Numbers.floorLevel && Numbers.charPosX > 352 && Numbers.charPosX < 550){
			//HOLE 1
			canMove = false;
			changed = true;
		}
		if (Numbers.charPosY > Numbers.floorLevel && Numbers.charPosX > 612){
			//HOLE 2
			canMove = false;
			changed = true;
		}
		if (!changed){
			canMove = true;
		}
		return canMove;
	}
}