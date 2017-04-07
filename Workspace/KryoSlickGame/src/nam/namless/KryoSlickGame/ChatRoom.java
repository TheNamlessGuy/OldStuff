package nam.namless.KryoSlickGame;

import java.io.IOException;

import nam.namless.KryoSlickGame.Core.ChatBox;
import nam.namless.KryoSlickGame.Core.ImageButton;
import nam.namless.KryoSlickGame.Core.InputBox;
import nam.namless.KryoSlickGame.Core.PlayerBox;
import nam.namless.KryoSlickGame.client.TestClient;
import nam.namless.KryoSlickGame.network.Network;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ChatRoom extends BasicGameState{
	public static String ip;
	public static String name;
	public TestClient tc;
	public PlayerBox playerBox;
	public ChatBox chatBox;
	public InputBox writeBox;
	public ImageButton send;
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		playerBox = new PlayerBox(KryoSlickGameMain.screenX/2, 0, KryoSlickGameMain.screenX/2, KryoSlickGameMain.screenY - 20);
		chatBox = new ChatBox(0, 0, KryoSlickGameMain.screenX/2, KryoSlickGameMain.screenY - 20);
		TestClient tc = null;
		try {
			tc = new TestClient(playerBox, chatBox);
			tc.setName(name);
			tc.connect(ip, Network.port);
		} catch (IOException e) {
			System.out.println("ERROR Can't create client");
		}
		writeBox = new InputBox("", 0, KryoSlickGameMain.screenY-20, KryoSlickGameMain.screenX-50, 20);
		send = new ImageButton(new Image("res/images/buttons/sendButton.png"), KryoSlickGameMain.screenX-50, KryoSlickGameMain.screenY - 20, true);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(new Image("res/images/backgrounds/menuBG.png"), 0, 0);
		playerBox.render(g);
		chatBox.render(g);
		writeBox.render(g);
		send.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		playerBox.update(gc);
		chatBox.update(gc);
		writeBox.update(gc, in);
		writeBox.isClicked(mouseX, mouseY);
		send.isHover(mouseX, mouseY);
		if (in.isMousePressed(0)){
			if (send.isClicked(mouseX, mouseY)){
				tc.sendMessage(writeBox.getText());
			}
		}
		if (in.isKeyPressed(Input.KEY_ENTER)){
			tc.sendMessage(writeBox.getText());
		}
	}
	public int getID() {
		return 2;
	}
}
