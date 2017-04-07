package namless.survivetherezombies;

import java.awt.Font;

import namless.survivetherezombies.core.ImageButton;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState{
	ImageButton play;
	ImageButton options;
	ImageButton quit;
	ImageButton hardmode;
	ImageButton highscore;
	Image background;
	OptionsMenu opMen;
	public static boolean hasWon;
	boolean cheatmode;
	public static TrueTypeFont normalFont;
	public static TrueTypeFont titleFont;
	public static TrueTypeFont nameInputFont;
	public MainMenu(int state){}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		Font fFont = new Font("Courier", Font.PLAIN, 17);
		normalFont = new TrueTypeFont(fFont, false);
		fFont = new Font("Courier", Font.BOLD, 25);
		titleFont = new TrueTypeFont(fFont, false);
		fFont = new Font("Courier", Font.BOLD, 65);
		nameInputFont = new TrueTypeFont(fFont, false);
		hasWon = false;
		cheatmode = false;
		play = new ImageButton(new Image("res/buttons/playButton.png"), SurviveTheReZombies.screenX/2 - 18, SurviveTheReZombies.screenY/2 - 75, true);
		options = new ImageButton(new Image("res/buttons/optionsButton.png"), SurviveTheReZombies.screenX/2 - 44, SurviveTheReZombies.screenY/2 + 75, true);
		quit = new ImageButton(new Image("res/buttons/quitButton.png"), SurviveTheReZombies.screenX/2 - 18, SurviveTheReZombies.screenY/2 + 150, true);
		hardmode = new ImageButton(new Image("res/buttons/hardmodeButton.png"), SurviveTheReZombies.screenX/2-70, SurviveTheReZombies.screenY/2 - 150, true);highscore = new ImageButton(new Image("res/buttons/highscoreButton.png"), SurviveTheReZombies.screenX/2-70, SurviveTheReZombies.screenY/2, true);
		background = new Image("res/title.png");
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0, 0);
		play.render(g);
		options.render(g);
		quit.render(g);
		highscore.render(g);
		if (hasWon){
			hardmode.render(g);
		}
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		play.isHover(mouseX, mouseY);
		options.isHover(mouseX, mouseY);
		quit.isHover(mouseX, mouseY);
		hardmode.isHover(mouseX, mouseY);
		highscore.isHover(mouseX, mouseY);
		if (in.isMousePressed(0)){
			if (play.isClicked(mouseX, mouseY)){
				sbg.enterState(SurviveTheReZombies.game);
				gc.setMouseGrabbed(true);
			}
			if (options.isClicked(mouseX, mouseY)){
				sbg.enterState(SurviveTheReZombies.options);
			}
			if (quit.isClicked(mouseX, mouseY)){
				SurviveTheReZombies.quit();
			}
			if (highscore.isClicked(mouseX, mouseY)){
				sbg.enterState(SurviveTheReZombies.highscore);
			}
			if (hasWon && hardmode.isClicked(mouseX, mouseY)){
				Game.hardmode = true;
				sbg.enterState(SurviveTheReZombies.game);
				gc.setMouseGrabbed(true);
			}
			if (cheatmode && ((mouseX > 173 && mouseX < 189) && (mouseY > 143 && mouseY < 159))){
				sbg.enterState(SurviveTheReZombies.cheat);
			}
		}
		if (in.isKeyPressed(Input.KEY_ENTER)){
			sbg.enterState(SurviveTheReZombies.game);
			gc.setMouseGrabbed(true);
		}
		if (in.isKeyPressed(Input.KEY_C)){
			cheatmode = true;
		}
	}
	public int getID() {
		return 0;
	}

}
