package core;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import variables.Numbers;
public class Button {
	private int locationX;
	private int locationY;
	private int width;
	private int height;
	private String text;
	private boolean filled;
	private Color colorButton;
	private Color colorText;
	private int margin;
	public Button(int locationX, int locationY, int width, int height, String text, boolean filled, Color colorButton, Color colorText, int margin){
		this.locationX = locationX; //x position
		this.locationY = locationY; //y position
		this.width = width; //button width
		this.height = height; //button height
		this.text = text; //text on the button
		this.filled = filled; //if it's filled or an outline
		this.colorButton = colorButton; //What color the button has
		this.colorText = colorText; //What color the text has
		this.margin = margin; //How much you should move the text from the edge of the button
	}
	public void render(Graphics g){
		g.setColor(colorButton); //Set the color of the button
		if (filled){ //Checks what kind of button it should draw and draws it
			g.fillRect(locationX, locationY, width, height);
		}else{
			g.drawRect(locationX, locationY, width, height);
		}
		g.setColor(colorText); //Set the color of the text
		g.drawString(text, locationX + margin, locationY + (height/4)); //Draw the text
	}
	public boolean isClicked(Input in){
		if ((Numbers.mousePosX > locationX && Numbers.mousePosX < (locationX+width) && (Numbers.mousePosY > locationY && Numbers.mousePosY < (locationY+height)) && in.isMousePressed(0))){
			return true;
		}
		return false;
	}
	public boolean isDown(Input in){
		if((Numbers.mousePosX > locationX && Numbers.mousePosX < (locationX+width) && (Numbers.mousePosY > locationY && Numbers.mousePosY < (locationY+height)) && in.isMouseButtonDown(0))){
			return true;
		}
		return false;
	}
}
