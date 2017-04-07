package core;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import playerActions.KeysUsed;
import variables.*;
public class Level {
	private PauseMenu pause = new PauseMenu();
	private OptionsMenu optionsMenu = new OptionsMenu(true);
	private GameOverScreen gos = new GameOverScreen();
	private DebugMode debug = new DebugMode();
	private Image background;
	private int scoreX;
	private int scoreY;
	public Level(Image background, int scoreX, int scoreY){ //Gets this levels background
		this.background = background;
		this.scoreX = scoreX;
		this.scoreY = scoreY;
	}
	public void render(Graphics g) throws SlickException{ //Draws the level
		if (!Booleans.dead){ //If you haven't died, draw the normal screen
			g.drawImage(background, 0, 0); //Draw the background
			Animations.player.draw((int)Numbers.charPosX, (int)Numbers.charPosY); //Draw the player
			g.setColor(Color.white); //Write the score and stuff
			g.drawString("SCORE: "+Numbers.score, scoreX, scoreY);
			g.drawString("Press left shift to start the next wave!", Numbers.screenSizeX-375, 3);
			g.drawString("Next wave: " + (Numbers.level/10), Numbers.screenSizeX-130, 17);
			if (Booleans.paused && !Booleans.options){ //If pause, draw the pause menu
				pause.render(g);
			}
			if (Booleans.options && !Booleans.paused){ //If options, draw the options menu
				optionsMenu.render(g);
			}
			for (Bullet bullet: ArrayLists.bullets){ //Draws all bullets
				bullet.render(g);
			}
			for (Enemy enemy: ArrayLists.enemies){ //Draws all enemies
				enemy.render(g);
			}
		}else{
			gos.render(g); //Draws the game over screen
		}
		debug.render(g); //Draws the debug menu
	}
	public void update(Input in, StateBasedGame sbg, double movementSpeed) throws SlickException{
		Numbers.mousePosX = in.getMouseX(); //Get the mouse position
		Numbers.mousePosY = in.getMouseY();
		if (!Booleans.dead){ //If not dead, update everything
			if (Booleans.paused && !Booleans.options){ //Updates pause menu if you have it open
				pause.update(sbg, in);
			}else if(Booleans.options && !Booleans.paused){ //Updates options if you have options open
				optionsMenu.update(in);
			}else if (!Booleans.options && !Booleans.paused){ //Checks what button you pressed
				KeysUsed.pressedSomething(in, movementSpeed, ArrayLists.bullets, ArrayLists.enemies);
			}
			for (int i = 0; i < ArrayLists.enemies.size(); i++){ //Update all enemies
				ArrayLists.enemies.get(i).update(ArrayLists.enemies);
			}
			for (int i = 0; i < ArrayLists.bullets.size(); i++){ //Update all the buttons
				ArrayLists.bullets.get(i).update(ArrayLists.enemies);
			}
		}else{
			gos.update(in, sbg); //Update if you're dead
		}
	}
	public void updateScoreX(int scoreX){
		this.scoreX = scoreX;
	}
}
