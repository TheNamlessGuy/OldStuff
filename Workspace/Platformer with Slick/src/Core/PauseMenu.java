package core;
import game.Maine;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import variables.*;
public class PauseMenu {
	public void render(Graphics g){
    		Color transparent = new Color(0f,0f,0f,0.5f);
            g.setColor(transparent);
            g.fillRect(0,0, Numbers.screenSizeX, Numbers.screenSizeY);
            g.setColor(Color.white);
            g.drawRect(350, 100, 100, 40);
            g.drawString("Resume", 373, 110);
            g.drawRect(350, 150, 100, 40);
            g.drawString("Options", 370, 160);
            g.drawRect(350, 200, 100, 40);
            g.drawString("Main Menu", 360, 210);
            g.drawRect(350, 250, 100, 40);
            g.drawString("Quit", 382, 260);
	}
	public void update(StateBasedGame sbg){
		if ((Numbers.mousePosX > 350 && Numbers.mousePosX < 450) && (Numbers.mousePosY > 100 && Numbers.mousePosY < 140)){
			//RESUME
			Booleans.paused = false;
		}else if((Numbers.mousePosX > 350 && Numbers.mousePosX < 450) && (Numbers.mousePosY > 150 && Numbers.mousePosY < 190)){
			//OPTIONS
			Booleans.options = true;
			Booleans.paused = false;
		}else if((Numbers.mousePosX > 350 && Numbers.mousePosX < 450) && (Numbers.mousePosY > 200 && Numbers.mousePosY < 240)){
			//MAIN MENU
			Booleans.paused = false;
			Numbers.charPosX = 0;
			Numbers.charPosY = Numbers.floorLevel;
			sbg.enterState(Maine.menu);
		}else if((Numbers.mousePosX > 350 && Numbers.mousePosX < 450) && (Numbers.mousePosY > 250 && Numbers.mousePosY <290 )){
			//QUIT
			System.exit(0);
		}
	}
}