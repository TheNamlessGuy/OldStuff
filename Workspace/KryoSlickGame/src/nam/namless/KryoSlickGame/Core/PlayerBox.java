package nam.namless.KryoSlickGame.Core;

import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class PlayerBox {
	private int x;
	private int y;
	private int width;
	private int height;
	private ArrayList<String> players;
	private Font font;
	public PlayerBox (int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		players = new ArrayList<String>();
		players.add("Player 1");
		players.add("Player 2");
	}
	public void render(Graphics g){
		int messageHeight = 0;
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		for (int i = 0; i < players.size(); i++){
			messageHeight = font.getHeight(players.get(i));
			g.drawString(players.get(i), x + 5, y + (i * messageHeight));
		}
	}
	public void update(GameContainer gc){
		font = gc.getDefaultFont();
	}
	public void updatePlayers(String[] newPlayers) {
		players = new ArrayList<String>(Arrays.asList(newPlayers));
	}
}