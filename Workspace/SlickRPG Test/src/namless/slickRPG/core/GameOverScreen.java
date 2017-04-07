package namless.slickRPG.core;

import namless.slickRPG.Maine;
import namless.slickRPG.PlayLevel;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
public class GameOverScreen {
	ImageButton b;
	public GameOverScreen() throws SlickException{
		b = new ImageButton(new Image("res/images/buttons/backButton.png"), (Maine.screenX/2)-50, (Maine.screenY/2)-200, true); //Create the back button
	}
	public void render(Graphics g){ //Draws the game over screen
		Maine.container.setMouseGrabbed(false);
		b.render(g); //Draw the back button
	}
	public void update(Input in, StateBasedGame sbg) throws SlickException{
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		b.isHover(mouseX, mouseY);
		if (in.isMousePressed(0)){ //Checks if you pressed the back button or enter
			if(b.isClicked(mouseX, mouseY)){
				PlayLevel.reset();
				sbg.enterState(Maine.mainMenu);
			}
		}else if(in.isKeyPressed(Input.KEY_ENTER)){
			PlayLevel.reset();
			sbg.enterState(Maine.mainMenu);
		}
		
	}
}
