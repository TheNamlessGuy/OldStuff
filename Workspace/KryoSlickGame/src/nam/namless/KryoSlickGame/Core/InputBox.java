package nam.namless.KryoSlickGame.Core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class InputBox {
	private int x;
	private int y;
	private int width;
	private int height;
	private String currentText;
	private int textHeight;
	private boolean isActive;
	private Font font;
	public InputBox (String sampleText, int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		currentText = sampleText;
		isActive = false;
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(Color.white);
		if ((y + textHeight) > height){
			g.drawString(currentText, x+10, y);
		}else{
			g.drawString(currentText, x + 10, y + (textHeight));
		}
	}
	public void update(GameContainer gc, Input in) {
		font = gc.getDefaultFont();
		textHeight = font.getHeight(currentText);
		if (isActive) {
			currentText = TextInputListener.check(in, currentText);
		}
	}
	public void isClicked (int mouseX, int mouseY){
		if ((mouseX > x && mouseX < (x + width)) && (mouseY > y && mouseY < (y + height))){
			isActive = true;
		}else{
			isActive = false;
		}
	}
	public String getText() {
		return currentText;
	}
}
