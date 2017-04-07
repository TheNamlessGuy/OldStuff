package namless.slickRPG.items;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import namless.slickRPG.core.TextBox;
import namless.slickRPG.supers.Item;

public class Empty extends Item{
	public Empty(){
		
	}
	public void render(Graphics g){
		
	}
	public String getObjectType() {
		return "Empty";
	}
	public Image getImage() {
		return null;
	}
	public void action() {
		
	}
	public void setItemInvRefID(int id) {
		
	}
	public void setToolTipText(String text) {
		
	}
	public TextBox getToolTip(){
		return null;
	}
	public void update() {
		
	}
	public int x() {
		return 0;
	}
	public int y() {
		return 0;
	}
	public boolean isHover() {
		return false;
	}
	public void setHover(boolean b) {
		
	}
	public void setItemInvRefX(int x) {
		
	}
	public void setItemInvRefY(int y) {
		
	}
	public int getItemInvRefID() {
		return 0;
	}
	public int getGoldAmount() {
		return 0;
	}
	public void setGoldAmount(int amount) {
		
	}
	public void merchAction() {
		
	}
}
