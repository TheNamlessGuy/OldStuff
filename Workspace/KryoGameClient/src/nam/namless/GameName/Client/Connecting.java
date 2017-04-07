package nam.namless.GameName.Client;

import java.io.IOException;

import nam.namless.GameName.Client.Core.ImageButton;
import nam.namless.GameName.Client.Core.TextField;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Connecting extends BasicGameState{
	TextField ipField;
	TextField portField;
	ImageButton connect;
	ImageButton back;
	public static String ip;
	public static int port = 54555;
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		ipField = new TextField(15,GameNameMain.screenY/2-75, GameNameMain.screenX - 30);
		portField = new TextField(15, GameNameMain.screenY/2, GameNameMain.screenX - 30);
		connect = new ImageButton(new Image("res/images/buttons/connectButton.png"), GameNameMain.screenX/2-100, GameNameMain.screenY/2+100, true);
		back = new ImageButton(new Image("res/images/buttons/backButton.png"), GameNameMain.screenX/2-50, GameNameMain.screenY/2+175, true);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.drawImage(new Image("res/images/background/menuBG.png"), 0, 0);
		g.drawString("IP Address:", 20, GameNameMain.screenY/2-100);
		g.drawString("Port:", 20, GameNameMain.screenY/2-25);
		ipField.render(g);
		portField.render(g);
		connect.render(g);
		back.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		Input in = gc.getInput();
		connect.isHover(in.getMouseX(), in.getMouseY());
		if (in.isMousePressed(0)){
			ipField.isClicked(in.getMouseX(), in.getMouseY());
			portField.isClicked(in.getMouseX(), in.getMouseY());
			if (connect.isClicked(in.getMouseX(), in.getMouseY())){
				ip = ipField.getInput();
				boolean success = true;
				if (portField.getInput() != null && portField.getInput() != ""){
					try{
						port = Integer.parseInt(portField.getInput());
					}catch(Exception e){
						success = false;
					}
				}
				if (success){
					try {
						Play.connect();
						sbg.enterState(GameNameMain.playGame);
					} catch (IOException e) {}
				}
			}
		}
		ipField.update(in);
		portField.update(in);
	}
	public int getID() {
		return 2;
	}
}
