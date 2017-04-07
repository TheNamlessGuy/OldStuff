package namless.slickRPG.items;

import namless.slickRPG.core.TextBox;
import namless.slickRPG.supers.Item;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class QuestItem extends Item{
	private Image image;
	private int invRefID;
	private int invX;
	private int invY;
	private boolean hover;
	private TextBox toolTip;
	private String itemName;
	public QuestItem(Image image, String text, String itemName){
		this.image = image;
		toolTip = new TextBox(this, text, Color.white, true);
		this.itemName = itemName;
	}
	public String getObjectType() {
		return "Quest item";
	}
	public void render(Graphics g){
		if (hover && toolTip.getText() != null){
			toolTip.render(g);
		}
	}
	public void action() {}
	public void update() {
		toolTip.setX(invX);
		toolTip.setY(invY);
	}
	public Image getImage() {
		return image;
	}
	public void setItemInvRefID(int id) {
		invRefID = id;
	}
	public void setToolTipText(String text) {
		toolTip.setText(text);
	}
	public int x() {
		return invX;
	}
	public int y() {
		return invY;
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
	public String getItemName(){
		return itemName;
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
		
	}
}
