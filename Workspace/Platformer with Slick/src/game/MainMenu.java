package game;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import playerActions.Fall;
import variables.*;
import core.*;
public class MainMenu extends BasicGameState{
	Button play;
	Button optionsButton;
	Button quit;
	OptionsMenu optionsMenu = new OptionsMenu("Main Menu");
	DebugMode debug = new DebugMode();
	
	public MainMenu(int state){}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		play = new Button(Numbers.screenSizeX/2 - 50, 50, 100, 40, "Play", true, Color.white, Color.black, 30);
		optionsButton = new Button(Numbers.screenSizeX/2 - 50, 100, 100, 40, "Options", true, Color.white, Color.black, 18);
		quit = new Button(Numbers.screenSizeX/2 - 50, 150, 100, 40, "Quit", true, Color.white, Color.black, 30);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Strings.currentFloor = "Main Menu";
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
		if (in.isMousePressed(0)){
			optionsMenu.update();
			if ((Numbers.mousePosX > Numbers.screenSizeX/2-50 && Numbers.mousePosX < Numbers.screenSizeX/2 + 50) && (Numbers.mousePosY > 50 && Numbers.mousePosY < 90 && !Booleans.options)){
				//PLAY
				Animations.initPlayer(); //Initiates the players animations
				Booleans.playing = true; //You are now playing the game
				Thread fall = new Thread(new Fall()); //Initiate the falling thread
				fall.start(); //Start the falling thread
				sbg.enterState(Maine.level1); //Enter level 1
			}else if ((Numbers.mousePosX > Numbers.screenSizeX/2-50 && Numbers.mousePosX < Numbers.screenSizeX/2 + 50) && (Numbers.mousePosY > 100 && Numbers.mousePosY < 140)){
				//OPTIONS
				Booleans.options = true;
			}else if((Numbers.mousePosX > Numbers.screenSizeX/2-50 && Numbers.mousePosX < Numbers.screenSizeX/2 + 50) && (Numbers.mousePosY > 150 && Numbers.mousePosY < 190 && !Booleans.options)){
				//QUIT
				System.exit(0);
			}
		}else if(in.isKeyPressed(Input.KEY_F3)){
			//Start debug mode
			Booleans.debugMode = !Booleans.debugMode;
		}else if(in.isKeyPressed(Input.KEY_ENTER)){
			//Same as play
			Animations.initPlayer();
			Booleans.playing = true;
			Thread fall = new Thread(new Fall());
			fall.start();
			sbg.enterState(Maine.level1);
		}
	}
	public int getID() {
		return 0; //Main menu has ID 0
	}

}
