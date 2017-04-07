package core;
import game.Maine;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import variables.*;
public class OptionsMenu {
	boolean pausemenu;
	Button back;
	String errorMessage = "";
	public OptionsMenu(boolean pausemenu){
		this.pausemenu = pausemenu;
		boolean filled = true;
		Color textColor = Color.black;
		if (pausemenu){
			filled = false;
			textColor = Color.white;
		}
        back = new Button(Numbers.screenSizeX/2 - 50, 400, 100, 40, "Back", filled, Color.white, textColor, 30);
	}
	public void render(Graphics g){ //Draws the options menu
		Color transparent = new Color(0f,0f,0f,0.5f);
        g.setColor(transparent); //Set the background color
        g.fillRect(0,0, Numbers.screenSizeX, Numbers.screenSizeY); //Draw the background
        g.setColor(Color.white); //Set color of the fullscreen text/toggle
        g.drawString("Fullscreen: ", 300, 150);
        g.drawRect(480, 150, 20, 20); //FULLSCREEN TOGGLE BOX
        if (Booleans.fullScreen){
        	g.fillRect(485, 155, 11, 11); //If you have fullscreen on, draw this box
        }
        g.setColor(Color.red);
        g.drawString(errorMessage, 200, 175);
        //KEYS
        g.setColor(Color.white);
        g.drawString("Move up: ", 300, 200);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Keys.keyUp), 480, 200); //Draw Keys.keyup name (UP)
        g.drawString("Move down: ", 300, 220);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Keys.keyDown), 480, 220); //Draw Keys.keydown name (DOWN)
        g.drawString("Move left: ", 300, 240);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Keys.keyLeft), 480, 240); //Draw Keys.keyleft name (LEFT)
        g.drawString("Move right: ", 300, 260);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Keys.keyRight), 480, 260); //Draw Keys.keyright name (RIGHT)
        g.drawString("Shoot: ", 300, 280);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Keys.shoot), 480, 280); //Draw Keys.keyshoot name (SPACE)
        g.drawString("Next wave: ", 300, 300);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Keys.spawn), 480, 300); //Draw Keys.keyspawn name (LSHIFT)
        g.drawString("Pause: ", 300, 320);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Keys.pause), 480, 320); //Draw Keys.keypause name (ESCAPE)
        back.render(g); //Draw the back button
	}
	public void update(Input in) throws SlickException{
		if (back.isClicked(in)){
			//BACK
			Booleans.options = false;
			if (pausemenu){ //If you entered from the pause menu
				Booleans.paused = true;
			}
			errorMessage = "";
		}else if((Numbers.mousePosX > 480 && Numbers.mousePosX < 500) && (Numbers.mousePosY > 150 && Numbers.mousePosY < 170)){
			//FULLSCREEN BUTTON
			Booleans.fullScreen = !Booleans.fullScreen;
			try{
				Maine.container.setFullscreen(Booleans.fullScreen); //Sets the screen to full size
			}catch(Exception e){
				Booleans.fullScreen = false;
				errorMessage = "Your computer does not support fullscreen mode of this game";
			}
		}else if(in.isKeyPressed(Input.KEY_ESCAPE)){
			//BACK
			Booleans.options = false;
			if (pausemenu){ //If you entered from the pause menu
				Booleans.paused = true;
			}
			errorMessage = "";
		}
	}
}