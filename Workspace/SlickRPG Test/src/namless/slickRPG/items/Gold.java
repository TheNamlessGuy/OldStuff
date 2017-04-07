package namless.slickRPG.items;

import namless.slickRPG.core.TextBox;
import namless.slickRPG.supers.Item;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Gold extends Item{
	private int invX;
	private int invY;
	private int invRefID;
	private int amount;
	private Image image;
	private TextBox toolTip;
	private boolean hover;
	public Gold(int amount) throws SlickException{
		image = new Image("res/images/items/Moneh.png");
		toolTip = new TextBox(this, amount + " gold!\nFor buying things", Color.white, true);
		this.amount = amount;
	}
	public Image getImage() {
		return image;
	}
	public void render(Graphics g) {
		if (hover && toolTip.getText() != null){
			toolTip.render(g);
		}
	}
	public void action() {
		
	}
	public void update() {
		toolTip.setX(invX);
		toolTip.setY(invY);
	}
	public void setItemInvRefID(int id) {
		invRefID = id;
	}
	public void setToolTipText(String text) {
		toolTip.setText(text);
	}
	public boolean isHover() {
		return hover;
	}
	public void setHover(boolean b) {
		hover = b;
	}
	public void setItemInvRefX(int x) {
		invX = x;
	}
	public void setItemInvRefY(int y) {
		invY = y;
	}
	public int getItemInvRefID() {
		return invRefID;
	}
	public int x() {
		return invX;
	}
	public int y() {
		return invY;
	}
	public String getObjectType() {
		return "Gold";
	}
	public int getGoldAmount(){
		return amount;
	}
	public void setGoldAmount(int amount){
		this.amount = amount;
		toolTip.setText(amount + " gold!\nFor buying things");
	}
	public void merchAction() {
		
	}
}
