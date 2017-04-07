package namless.slickRPG.core;
import namless.slickRPG.Maine;
import namless.slickRPG.supers.Object;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TextBox {
	private Object object;
	private String text;
	private float x;
	private float y;
	private float count = 0;
	private float countMax = 0;
	private boolean active = false;
	private Color color;
	private boolean toolTip;
	public TextBox(Object object, String text, Color color, boolean toolTip){
		this.color = color;
		this.object = object;
		this.x = object.x()*40;
		this.y = (float)(object.y()-0.5)*40;
		this.text = text;
		countMax = (float)(text.length() * 1.5);
		this.toolTip = toolTip;
		active = toolTip;
	}
	public void render(Graphics g){
		//Opacity
		if (active){
			g.setColor(Color.black);
			g.fillRect(x, y, getStringWidth(), getStringHeight());
			g.setColor(color);
			g.drawRect(x, y, getStringWidth(), getStringHeight());
			g.drawString(text, x, y);
		}
	}
	public void update(){
		if (active && !toolTip){
			if (objectHasMoved()){
				x = object.x()*40;
			}
			count += 0.1;
			if (count >= countMax){
				active = false;
				count = 0;
				y = (float)((object.y()-0.5)*40);
			}
		}
	}
	public void setText(String text){
		this.text = text;
	}
	public void setObject(Object object){
		this.object = object;
	}
	public String getText(){
		return text;
	}
	public boolean objectHasMoved(){
		if (object.x() != x || object.y() != y){
			return true;
		}
		return false;
	}
	public void setActivate(boolean b){
		active = b;
	}
	public boolean isActive(){
		return active;
	}
	public int getStringHeight(){
		return(Maine.container.getDefaultFont().getHeight(text));
	}
	public int getStringWidth(){
		return(Maine.container.getDefaultFont().getWidth(text));
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
}