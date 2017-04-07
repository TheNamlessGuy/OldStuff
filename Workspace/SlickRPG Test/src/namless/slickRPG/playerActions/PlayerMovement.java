package namless.slickRPG.playerActions;

import namless.slickRPG.PlayLevel;
import namless.slickRPG.Read;

import org.newdawn.slick.Input;

public class PlayerMovement {
	public static void move(Input in){
		if (in.isKeyPressed(Input.KEY_LEFT) && PlayLevel.player.canMove()){ //Move Left
			PlayLevel.player.setDirection("left");
			if (PlayLevel.player.x() > 0){
				if (PlayLevel.level.getTiles()[PlayLevel.player.x()-1][PlayLevel.player.y()].canWalkOn()){
					PlayLevel.player.moveLeft();
				}
			}
		}else if (in.isKeyPressed(Input.KEY_RIGHT) && PlayLevel.player.canMove()){ //Move Right
			PlayLevel.player.setDirection("right");
			if (PlayLevel.player.x() < Read.fullX-1){
				if (PlayLevel.level.getTiles()[PlayLevel.player.x()+1][PlayLevel.player.y()].canWalkOn()){
					PlayLevel.player.moveRight();
				}
			}
		}else if (in.isKeyPressed(Input.KEY_UP) && PlayLevel.player.canMove()){ //Move Up
			PlayLevel.player.setDirection("up");
			if (PlayLevel.player.y() > 0){
				if (PlayLevel.level.getTiles()[PlayLevel.player.x()][PlayLevel.player.y()-1].canWalkOn()){
					PlayLevel.player.moveUp();
				}
			}
		}else if (in.isKeyPressed(Input.KEY_DOWN) && PlayLevel.player.canMove()){ //Move Down
			PlayLevel.player.setDirection("down");
			if (PlayLevel.player.y() < Read.fullY-1){
				if (PlayLevel.level.getTiles()[PlayLevel.player.x()][PlayLevel.player.y()+1].canWalkOn()){
					PlayLevel.player.moveDown();
				}
			}
		}else if(in.isKeyPressed(Input.KEY_I)){
			PlayLevel.player.getInventory().setActive(true);
		}else if(in.isKeyPressed(Input.KEY_F3)){ //Debug mode
			PlayLevel.debug.setActive(!PlayLevel.debug.isActive());
		}else if(in.isKeyPressed(Input.KEY_TAB)){ //"Console"
			PlayLevel.console.setActive(true);
		}else if(in.isKeyPressed(Input.KEY_SPACE)){
			
		}
		
	}
}
