package nam.namless.GameName.Client;

import java.io.IOException;

import nam.namless.GameName.Client.Core.HUD;
import nam.namless.GameName.Client.Core.Level;
import nam.namless.GameName.Client.Core.PlayerActions;
import nam.namless.GameName.Client.Listeners.ClientListener;
import nam.namless.GameName.Client.Network.Network;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.minlog.Log;

public class Play extends BasicGameState{
	public static Client client;
	public static Level board;
	public static HUD hud;
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		client = new Client();
		Log.set(Log.LEVEL_NONE);
	}
	public static void connect() throws IOException{
		client.start();
		Network.register(client);
		client.addListener(new ClientListener());
		client.connect(60000, Connecting.ip, Connecting.port);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		board.render(g);
		hud.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		Input in = gc.getInput();
		PlayerActions.playerMove(in);
		hud.update();
	}
	public int getID() {
		return 1;
	}

}
