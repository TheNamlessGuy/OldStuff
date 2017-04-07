package namless.slickRPG.core;
import namless.slickRPG.supers.Object;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class FloatText {
	private Object object;
	private String text;
	private float x;
	private float y;
	private float yMove = 0;
	private boolean active = false;
	private boolean move;
	private Color color;
	public FloatText(Object object, String text, boolean move, Color color){
		this.color = color;
		this.object = object;
		this.x = object.x();
		this.y = (float)(object.y()-0.5)*40;
		this.text = text;
		this.move = move;
	}
	public void render(Graphics g){
		//Opacity
		if (active){
			g.setColor(color);
			g.drawString(text, x*40, y);
		}
	}
	public void update(){
		if (active){
			if (objectHasMoved()){
				x = object.x();
			}
			if (move){
				y -= yMove;
			}
			yMove += 0.1;
			if (yMove >= 2){
				active = false;
				yMove = 0;
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
}
