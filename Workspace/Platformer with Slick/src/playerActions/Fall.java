package playerActions;
import variables.*;
public class Fall implements Runnable{
	public static boolean falling = false;
	public void run() {
		while (Booleans.playing){ //While playing
			while (CanMove.down() && !Jump.jump){ //While can fall
				falling = true;
				if (!Booleans.playerLeft){
					Animations.player = Animations.playerFallRight;
				}else{
					Animations.player = Animations.playerFallLeft;
				}
				Numbers.charPosY += 10;
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} //End while can fall
			if (!Jump.jump){ //Update graphics if not jumping
				if (!Booleans.playerLeft){
					Animations.player = Animations.playerIdleRight;
				}else{
					Animations.player = Animations.playerIdleLeft;
				}
			}
			//SLEEP EVERY LOOP
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			falling = false;
		}
		
	}
}