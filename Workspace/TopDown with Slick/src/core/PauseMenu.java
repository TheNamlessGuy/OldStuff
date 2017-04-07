package core;
import game.MainMenu;
import game.Maine;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import variables.*;
public class PauseMenu {
	Button resume;
	Button options;
	Button mainMenu;
	Button quit;
	public PauseMenu(){
		resume = new Button(350, 100, 100, 40, "Resume", false, Color.white, Color.white, 23);
		options = new Button(350, 150, 100, 40, "Options", false, Color.white, Color.white, 20);
		mainMenu = new Button(350, 200, 100, 40, "Main Menu", false, Color.white, Color.white, 10);
		quit = new Button(350, 250, 100, 40, "Quit", false, Color.white, Color.white, 32);
	}
	public void render(Graphics g){ //Draws the pause menu
    		Color transparent = new Color(0f,0f,0f,0.5f);
            g.setColor(transparent); //Sets the background color
            g.fillRect(0,0, Numbers.screenSizeX, Numbers.screenSizeY); //Draws the background
            //Drawing the buttons
            resume.render(g);
            options.render(g);
            mainMenu.render(g);
            quit.render(g);
	}
	public void update(StateBasedGame sbg, Input in){
		if (resume.isClicked(in)){
			//RESUME
			Booleans.paused = false;
			Maine.container.setMouseGrabbed(true);
		}else if(options.isClicked(in)){
			//OPTIONS
			Booleans.options = true;
			Booleans.paused = false;
		}else if(mainMenu.isClicked(in)){
			//MAIN MENU
			Booleans.paused = false;
			MainMenu.fromPause = true;
			sbg.enterState(Maine.menu);
		}else if(quit.isClicked(in)){
			//QUIT
			System.exit(0);
		}else if(in.isKeyPressed(Input.KEY_ESCAPE)){
			//RESUME
			Booleans.paused = false;
			Maine.container.setMouseGrabbed(true);
		}
	}
}