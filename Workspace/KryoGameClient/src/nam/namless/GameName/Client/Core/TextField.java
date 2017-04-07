package nam.namless.GameName.Client.Core;

import nam.namless.GameName.Client.Listeners.TextInputListener;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class TextField {
	private int x;
	private int y;
	private int length;
	private String input = "";
	private boolean active = false;;
	public TextField(int x, int y, int length){
		this.x = x;
		this.y = y;
		this.length = length;
	}
	public void render(Graphics g) throws SlickException{
		g.setColor(Color.blue);
		g.fillRect(x, y, length, 20);
		g.setColor(Color.white);
		if (input.length() > 0){
			g.drawString(input, x, y+2);
		}
	}
	public void update(Input in){
		if (active){
			input = TextInputListener.check(in, input);
		}
	}
	public void isClicked(int mouseX, int mouseY){
		if ((mouseX > x && mouseX < length) && (mouseY > y && mouseY < y+20)){
			active = true;
		}else{
			active = false;
		}
	}
	public String getInput(){
		return input;
	}
}
