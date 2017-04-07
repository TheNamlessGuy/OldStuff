package core;
import game.MainMenu;
import game.Maine;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import variables.*;
public class GameOverScreen {
	Button b;
	public GameOverScreen(){
		b = new Button(Numbers.screenSizeX/2 - 50, 250, 100, 40, "Back", true, Color.white, Color.black, 30); //Create the back button
	}
	public void render(Graphics g){ //Draws the game over screen
		Maine.container.setMouseGrabbed(false);
		g.setColor(Color.red); //Game over text color
		g.drawString("Game Over", Numbers.screenSizeX/3+93, 100);
		g.setColor(Color.white); //Score text color
		g.drawString("Final score: "+Numbers.score + "\nFinal level: " + ((Numbers.level/10)-1), Numbers.screenSizeX/3+80, 150);
		b.render(g); //Draw the back button
	}
	public void update(Input in, StateBasedGame sbg) throws SlickException{
		if (in.isMousePressed(0)){ //Checks if you pressed the back button or enter
			if((Numbers.mousePosX > 350 && Numbers.mousePosX < 450) && (Numbers.mousePosY > 250 && Numbers.mousePosY < 290)){
				//BACK
				Numbers.charPosX = Numbers.screenSizeX/2-20;
				Numbers.charPosY = Numbers.screenSizeY/2-20;
				Numbers.score = 0;
				Numbers.level = 10;
				Booleans.dead = false;
				MainMenu.fromPause = false;
				sbg.enterState(Maine.menu);
			}
		}else if(in.isKeyPressed(Input.KEY_ENTER)){
			//BACK
			Numbers.charPosX = Numbers.screenSizeX/2-20;
			Numbers.charPosY = Numbers.screenSizeY/2-20;
			Numbers.score = 0;
			Numbers.level = 10;
			Booleans.dead = false;
			MainMenu.fromPause = false;
			sbg.enterState(Maine.menu);
		}
		
	}
}
