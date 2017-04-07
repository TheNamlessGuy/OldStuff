package nam.namless.KryoSlickGame;

import nam.namless.KryoSlickGame.Core.ImageButton;
import nam.namless.KryoSlickGame.Core.InputBox;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Connect extends BasicGameState{
	public ImageButton connect;
	public InputBox ipBox;
	public InputBox nameBox;
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		connect = new ImageButton(new Image("res/images/buttons/connectButton.png"), (KryoSlickGameMain.screenX / 2) - 100, (KryoSlickGameMain.screenY / 2) +100, true);
		ipBox = new InputBox("LOCALHOST", (KryoSlickGameMain.screenX / 2) - 100, (KryoSlickGameMain.screenY / 3), 200, 50);
		nameBox = new InputBox("TESTNAME", (KryoSlickGameMain.screenX / 2) - 100, (KryoSlickGameMain.screenY / 2), 200, 50);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(new Image("res/images/backgrounds/menuBG.png"), 0, 0);
		connect.render(g);
		ipBox.render(g);
		nameBox.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		ipBox.update(gc, in);
		nameBox.update(gc, in);
		connect.isHover(mouseX, mouseY);
		if (in.isMousePressed(0)){
			if (connect.isClicked(mouseX, mouseY)){
				ChatRoom.name = nameBox.getText();
				ChatRoom.ip = ipBox.getText();
				sbg.enterState(KryoSlickGameMain.chatRoom);
			}
			ipBox.isClicked(mouseX, mouseY);
			nameBox.isClicked(mouseX, mouseY);
		}
		
	}
	public int getID() {
		return 1;
	}
	
}
