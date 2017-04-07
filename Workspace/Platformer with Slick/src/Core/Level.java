package core;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import playerActions.KeysUsed;
import variables.Animations;
import variables.Booleans;
import variables.Numbers;
import variables.Strings;
public class Level {
	private LifeCounter lf = new LifeCounter();
	private PauseMenu pause = new PauseMenu();
	private OptionsMenu optionsMenu = new OptionsMenu("Pausemenu");
	private GameOverScreen gos = new GameOverScreen();
	private DebugMode debug = new DebugMode();
	private Image background;
	private String levelName;
	
	public Level(Image background, String levelName){
		this.background = background;
		this.levelName = levelName;
	}
	public void render(Graphics g){
		Strings.currentFloor = levelName;
		if (!Booleans.dead){
			g.drawImage(background, 0, 0);
			Animations.player.draw((int)Numbers.charPosX, (int)Numbers.charPosY);
			if (Booleans.paused && !Booleans.options){
				pause.render(g);
			}
			if (Booleans.options && !Booleans.paused){
				optionsMenu.render(g);
			}
			lf.render(g);
		}else{
			gos.render(g);
		}
		debug.render(g);
	}
	public void update(Input in, StateBasedGame sbg, float movementSpeed) throws SlickException{
		Numbers.mousePosX = in.getMouseX();
		Numbers.mousePosY = in.getMouseY();
		if (!Booleans.dead){
			if (Booleans.paused && in.isMousePressed(0) && !Booleans.options){
				pause.update(sbg);
			}else if(Booleans.options && in.isMousePressed(0) && !Booleans.paused){
				optionsMenu.update();
			}else if (!Booleans.options && !Booleans.paused){
				KeysUsed.pressedSomething(in, movementSpeed);
			}
		}else{
			gos.update(in, sbg);
		}
	}
}
