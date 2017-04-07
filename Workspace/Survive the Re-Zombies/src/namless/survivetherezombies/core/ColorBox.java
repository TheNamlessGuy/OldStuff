package namless.survivetherezombies.core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class ColorBox {
	private Color defCol;
	private Color cliCol;
	private Color actCol;
	private Color transparent;
	private boolean clicked;
	private int x;
	private int y;
	private int side;
	private boolean hover;
	public ColorBox(int x, int y, Color defaultColor, Color clickedColor){
		hover = false;
		transparent = new Color(0f,0f,0f,0.3f);
		defCol = defaultColor;
		cliCol = clickedColor;
		clicked = false;
		actCol = defCol;
		this.x = x;
		this.y = y;
		side = 25;
	}
	public void render(Graphics g){
		g.setColor(actCol);
		g.fillRect(x, y, side, side);
		if (hover){
			g.setColor(transparent);
			g.fillRect(x, y, side, side);
		}
	}
	public void isHover(int mouseX, int mouseY){
		if ((mouseX > x && mouseX < (x + side)) && (mouseY > y && mouseY < (y + side))) {
			hover = true;
		}else{
			hover = false;
		}
	}
	public void isClicked(int mouseX, int mouseY){
		if ((mouseX > x && mouseX < (x + side)) && (mouseY > y && mouseY < (y + side))) {
			clicked = !clicked;
			if (clicked){
				actCol = cliCol;
			}else{
				actCol = defCol;
			}
		}
	}
	public boolean getClicked(){
		return clicked;
	}
	public void unClick(){
		clicked = false;
		actCol = defCol;
	}
}
