package core;
import game.Maine;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import variables.*;
public class GameOverScreen {
	public GameOverScreen(){}
	public void render(Graphics g){
		if (Numbers.livesLeft == 0){
			g.setColor(Color.red);
			g.drawString("Game Over", Numbers.screenSizeX/3+93, 100);
			Button b = new Button(Numbers.screenSizeX/2 - 50, 250, 100, 40, "Back", true, Color.white, Color.black, 30);
			b.render(g);
		}else{
			Numbers.livesLeft--;
			Numbers.charPosX = 0;
			Numbers.charPosY = Numbers.floorLevel;
			Booleans.dead = false;
		}
	}
	public void update(Input in, StateBasedGame sbg){
		if (Numbers.livesLeft == 0){
			if (in.isMousePressed(0)){
				if((Numbers.mousePosX > 350 && Numbers.mousePosX < 450) && (Numbers.mousePosY > 250 && Numbers.mousePosY < 290)){
					//BACK
					Numbers.charPosX = 0;
					Numbers.charPosY = Numbers.floorLevel;
					sbg.enterState(Maine.menu);
					Numbers.livesLeft = 10;
				}
			}else if(in.isKeyPressed(Input.KEY_ENTER)){
				Numbers.charPosX = 0;
				Numbers.charPosY = Numbers.floorLevel;
				sbg.enterState(Maine.menu);
				Numbers.livesLeft = 10;
			}
		}
		
	}
}
