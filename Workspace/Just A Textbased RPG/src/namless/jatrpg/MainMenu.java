package namless.jatrpg;

import namless.jatrpg.core.ImageButton;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState{
	public MainMenu (int state){}
	ImageButton connectButton;
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		connectButton = new ImageButton(new Image("res/img/buttons/connectButton.png"), 0, 200, true);
		connectButton.centerX(JAT_RPG.screenX);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		connectButton.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		connectButton.isHover(mouseX, mouseY);
		if (in.isMousePressed(0)){
			if (connectButton.isClicked(mouseX, mouseY)){
				sbg.enterState(JAT_RPG.connect);
			}
		}
	}
	public int getID() {
		return 1;
	}

}
