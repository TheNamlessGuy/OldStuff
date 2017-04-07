package playerActions;
import variables.*;
public class Jump implements Runnable{
	public static boolean jump = false;
	public void run() {
		if (!jump && !Fall.falling){ //If not already jumping
			jump = true;
			int upJump = 0;
			for (int i = 0; i < 10; i++){ //Try to jump 10 high
				if (CanMove.up()){ //Checks if you actually can jump up
					upJump++; //Counts how many times you jumped up
					if (!Booleans.playerLeft){ //Checks what animation to use
						Animations.player = Animations.playerJumpRight;
					}else{
						Animations.player = Animations.playerJumpLeft;
					}
					Numbers.charPosY -= 10;
					try { //Sleep every loop
						Thread.sleep(40);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} //End upjump
			//Falling
			while(upJump > 0 && CanMove.down()){ //While (number of move-units you moved up is less than 0) and if you can move down
				if (!Booleans.playerLeft){ //Gets which animation
					Animations.player = Animations.playerFallRight;
				}else{
					Animations.player = Animations.playerFallLeft;
				}
				Numbers.charPosY += 10;
				try { //Sleep every loop
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				upJump--;
			}//End falling
			jump = false;
			Animations.player = Animations.playerIdleRight;
		} //End if already jumping
		
	}
}