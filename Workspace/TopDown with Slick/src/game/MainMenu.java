package game;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import variables.Animations;
import variables.ArrayLists;
import variables.Booleans;
import variables.Numbers;
import core.Button;
import core.DebugMode;
import core.OptionsMenu;
public class MainMenu extends BasicGameState{
	Button play;
	Button optionsButton;
	Button quit;
	OptionsMenu optionsMenu = new OptionsMenu(false);
	DebugMode debug = new DebugMode();
	public static boolean fromPause = false;
	
	public MainMenu(int state){}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//Initiates all the buttons
		optionsButton = new Button(Numbers.screenSizeX/2, 250, 100, 40, "Options", true, Color.white, Color.black, 18);
		quit = new Button(Numbers.screenSizeX/2, 300, 100, 40, "Quit", true, Color.white, Color.black, 30);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if (fromPause){
			play = new Button(Numbers.screenSizeX/2, 200, 100, 40, "Continue", true, Color.white, Color.black, 12);
		}else{
			play = new Button(Numbers.screenSizeX/2, 200, 100, 40, "Play", true, Color.white, Color.black, 30);
			for (int i = 0; i < ArrayLists.enemies.size(); i++){ //Empties the enemies arraylist
				ArrayLists.enemies.remove(i);
			}
			for (int i = 0; i < ArrayLists.bullets.size(); i++){ //Empties the bullets arraylist
				ArrayLists.bullets.remove(i);
			} 
		}
		g.drawImage(new Image("res/title.png"), 0, 0);
		if (Booleans.options){ //If you clicked on options
			optionsMenu.render(g);
		}else{ //If you didn't click on options
			play.render(g);
			optionsButton.render(g);
			quit.render(g);
		}
		debug.render(g); //Render debug
	}
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		Input in = gc.getInput();
		Numbers.mousePosX = in.getMouseX();
		Numbers.mousePosY = in.getMouseY();
		optionsMenu.update(in);
		if (play.isClicked(in) && !Booleans.options){
			//PLAY
			Animations.init(); //Initiates the players animations
			Booleans.playing = true; //You are now playing the game
			sbg.enterState(Maine.level1); //Enter level 1
			Maine.container.setMouseGrabbed(true); //Hide cursor
		}else if (optionsButton.isClicked(in)){
			//OPTIONS
			Booleans.options = true;
		}else if(quit.isClicked(in) && !Booleans.options){
			//QUIT
			System.exit(0);
		}else if(in.isKeyPressed(Input.KEY_F3)){
			//Start debug mode
			Booleans.debugMode = !Booleans.debugMode;
		}else if(in.isKeyPressed(Input.KEY_ENTER)){
			//Same as play
			Animations.init();
			Booleans.playing = true;
			sbg.enterState(Maine.level1);
			Maine.container.setMouseGrabbed(true);
		}
	}
	public int getID() {
		return 0; //Main menu has ID 0
	}

}