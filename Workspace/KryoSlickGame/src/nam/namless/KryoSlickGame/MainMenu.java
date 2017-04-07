package nam.namless.KryoSlickGame;

import nam.namless.KryoSlickGame.Core.ImageButton;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState{
	public ImageButton connect;
	public ImageButton options;
	public ImageButton quit;
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		connect = new ImageButton(new Image("res/images/buttons/connectButton.png"), (KryoSlickGameMain.screenX / 2) - 100, (KryoSlickGameMain.screenY / 2) -200, true);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(new Image("res/images/backgrounds/menuBG.png"), 0, 0);
		connect.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		connect.isHover(mouseX, mouseY);
		if (in.isMousePressed(0)){
			if (connect.isClicked(mouseX, mouseY)){
				sbg.enterState(KryoSlickGameMain.connect);
			}
		}
	}
	public int getID() {
		return 0;
	}
}
