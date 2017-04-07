package core;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
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
		this.locationX = locationX;
		this.locationY = locationY;
		this.width = width;
		this.height = height;
		this.text = text;
		this.filled = filled;
		this.colorButton = colorButton;
		this.colorText = colorText;
		this.margin = margin;
	}
	public void render(Graphics g){
		g.setColor(colorButton);
		if (filled){
			g.fillRect(locationX, locationY, width, height);
		}else{
			g.drawRect(locationX, locationY, width, height);
		}
		g.setColor(colorText);
		g.drawString(text, locationX + margin, locationY + (height/4));
	}
	public boolean isDown(){
		return false;
	}
	public boolean isClicked(){
		return false;
	}
}
