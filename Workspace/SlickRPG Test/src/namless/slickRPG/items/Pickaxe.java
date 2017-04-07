package namless.slickRPG.items;

import namless.slickRPG.core.TextBox;
import namless.slickRPG.supers.Item;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Pickaxe extends Item{
	private Image image;
	private int invRefID = 0;
	private TextBox toolTip;
	private boolean hover = false;
	private int invX = 0;
	private int invY = 0;
	public Pickaxe() throws SlickException{
		image = new Image("res/images/items/pickaxe.png");
		toolTip = new TextBox(this, "Pickaxe\nWith it, you can break certain walls", Color.white, true);
	}
	public String getObjectType() {
		return "Pickaxe";
	}
	public void render(Graphics g){
		if (hover && toolTip.getText() != null){
			toolTip.render(g);
		}
	}
	public void update(){
		toolTip.setX(invX);
		toolTip.setY(invY);
	}
	public Image getImage() {
		return image;
	}
	public void action() {}
	public void setItemInvRefID(int id) {
		invRefID = id;
	}
	public void setToolTipText(String text) {
		toolTip.setText(text);
	}
	public TextBox getToolTip(){
		return toolTip;
	}
	public int x() {
		return invX;
	}
	public int y() {
		return invY;
	}
	public boolean isHover(){
		return hover;
	}
	public void setHover(boolean b){
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
	public int getGoldAmount() {
		return 0;
	}
	public void setGoldAmount(int amount) {
		
	}
	public void merchAction() {
		System.out.println("poop");
	}
}
