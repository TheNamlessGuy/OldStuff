package playerActions;
import core.*;
import game.Maine;
import game.Spawning;
import java.util.ArrayList;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import variables.*;
public class KeysUsed {
	public static void pressedSomething(Input in, double movementSpeed, ArrayList<Bullet> bullets, ArrayList<Enemy> enemies/*, ArrayList<Boolean> enemyDead, ArrayList<Boolean> bulletGone*/) throws SlickException{
		if (in.isKeyDown(Keys.keyDown) && Numbers.charPosY <= 525){
			//DOWN
			Strings.direction = "down"; //Sets the direction you're looking at to down
			Numbers.charPosY += movementSpeed; //Moves character down
			Animations.player = Animations.playerDown; //Sets the character animation to the downwards animation
		}
		if(in.isKeyDown(Keys.keyUp) && Numbers.charPosY >= 35){
			//UP
			Strings.direction = "up"; //Sets the direction you're looking at to up
			Numbers.charPosY -= movementSpeed; //Moves the player up
			Animations.player = Animations.playerUp; //Sets the player animation to the upwards animation
		}
		if(in.isKeyDown(Keys.keyLeft) && Numbers.charPosX >= 30){
			//LEFT
			Strings.direction = "left"; //Sets the direction you're looking at to left
			Numbers.charPosX -= movementSpeed; //Blah blah see above
			Animations.player = Animations.playerLeft;
		}
		if(in.isKeyDown(Keys.keyRight) && Numbers.charPosX <= 725){
			//RIGHT
			Strings.direction = "right"; //Sets the direction you're looking at to right
			Numbers.charPosX += movementSpeed;
			Animations.player = Animations.playerRight;
		}
		if(in.isKeyPressed(Keys.shoot)){
			//SHOOT
			if (Strings.direction.equals("up")){ //If you're shooting up
				//Creates a new bullet
				bullets.add(new Bullet(Numbers.charPosX+20, Numbers.charPosY, Strings.direction, bullets.size()));
	        }else if(Strings.direction.equals("down")){ //If you're shooting down
	        	//Creates a new bullet
				bullets.add(new Bullet(Numbers.charPosX+20, Numbers.charPosY+20, Strings.direction, bullets.size()));
	        }else if(Strings.direction.equals("right")){ //If you're shooting right
	        	//Creates a new bullet
				bullets.add(new Bullet(Numbers.charPosX+30, Numbers.charPosY+12, Strings.direction, bullets.size()));
	        }else{ //If you're shooting left
	        	//Creates a new bullet
				bullets.add(new Bullet(Numbers.charPosX, Numbers.charPosY+12, Strings.direction, bullets.size()));
	        }
		}
		if(in.isKeyPressed(Input.KEY_F3)){
			//DEBUG MODE
			Booleans.debugMode = !Booleans.debugMode;
		}
		if(in.isKeyPressed(Keys.pause)){
			//PAUSE
			Booleans.paused = !Booleans.paused;
			Booleans.options = false;
			Maine.container.setMouseGrabbed(false);
		}
		if(in.isKeyPressed(Keys.spawn)){
			//Spawn enemies
			Spawning.spawn(Numbers.level);
		}
	}
}
