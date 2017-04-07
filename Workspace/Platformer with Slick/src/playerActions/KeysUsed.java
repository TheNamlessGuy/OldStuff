package playerActions;
import org.newdawn.slick.Input;
import variables.*;
public class KeysUsed {
	public static void pressedSomething(Input in, float movementSpeed){
		if (in.isKeyDown(Input.KEY_UP)){
			//MOVE UP
			if (CanMove.up()){
				if (!Jump.jump && !Fall.falling){
					Thread jump = new Thread(new Jump());
					jump.start();
				}
			}
		}else if(in.isKeyDown(Input.KEY_DOWN)){
			//NADA
		}else if(in.isKeyDown(Input.KEY_LEFT)){
			//MOVE LEFT
			Booleans.playerLeft = true;
			if (CanMove.left()){
				if (!Jump.jump && !Fall.falling){
					Animations.player = Animations.playerLeft;
				}
				Numbers.charPosX -= movementSpeed;
			}
		}else if(in.isKeyDown(Input.KEY_RIGHT)){
			//MOVE RIGHT
			Booleans.playerLeft = false;
			if (CanMove.right()){
				if (!Jump.jump && !Fall.falling){
					Animations.player = Animations.playerRight;
				}
				Numbers.charPosX += movementSpeed;
			}
		}else if(in.isKeyPressed(Input.KEY_ESCAPE)){
			//PAUSE
			Booleans.paused = !Booleans.paused;
			Booleans.options = false;
		}else if(in.isKeyPressed(Input.KEY_F3)){
			//DEBUG
			Booleans.debugMode = !Booleans.debugMode;
		}
		
	}
	
}
