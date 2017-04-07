package nam.namless.GameName.Client;
import nam.namless.GameName.Client.Core.ImageButton;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {
	public ImageButton play;
	public ImageButton options;
	public ImageButton quit;

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		play = new ImageButton(new Image("res/images/buttons/playButton.png"), (GameNameMain.screenX / 2) - 50, (GameNameMain.screenY / 2) - 200, true);
		options = new ImageButton(new Image("res/images/buttons/optionsButton.png"), (GameNameMain.screenX / 2) - 75, (GameNameMain.screenY / 2) - 100, true);
		quit = new ImageButton(new Image("res/images/buttons/quitButton.png"), (GameNameMain.screenX / 2) - 50, (GameNameMain.screenY / 2), true);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(new Image("res/images/background/menuBG.png"), 0, 0);
		play.render(g);
		options.render(g);
		quit.render(g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		Input in = gc.getInput();
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		play.isHover(mouseX, mouseY);
		options.isHover(mouseX, mouseY);
		quit.isHover(mouseX, mouseY);
		if (in.isMousePressed(0)){
			if (play.isClicked(mouseX, mouseY)) {
				sbg.enterState(GameNameMain.connecting);
			}
			if (options.isClicked(mouseX, mouseY)) {
				
			}
			if (quit.isClicked(mouseX, mouseY)) {
				System.exit(0);
			}
		}
	}

	public int getID() {
		return 0;
	}
}