package nam.namless.KryoSlickGame.Core;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class ChatBox {
	private int x;
	private int y;
	private int width;
	private int height;
	private ArrayList<String> messages;
	private Font font;
	public ChatBox (int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		messages = new ArrayList<String>();
		messages.add("Player 1: Hi");
		messages.add("Player 2: Hello");
	}
	public void render(Graphics g){
		int messageHeight = 0;
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		for (int i = 0; i < messages.size(); i++){
			messageHeight = font.getHeight(messages.get(i));
			g.drawString(messages.get(i), x + 5, y + (i * messageHeight));
		}
	}
	public void update(GameContainer gc){
		font = gc.getDefaultFont();
		/*int totalMessageHeight = 0;
		int messageHeight = 0;
		for (int i = 0; i < messages.size(); i++){
			messageHeight = font.getHeight(messages.get(i));
			totalMessageHeight += messageHeight;
		}
		if (totalMessageHeight >= height - messageHeight){
			messages.remove(0);
		}*/
	}
	public void addMessage(String message) {
		messages.add(message);
	}
}
