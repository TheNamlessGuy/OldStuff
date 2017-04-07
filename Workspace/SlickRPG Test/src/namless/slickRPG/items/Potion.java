package namless.slickRPG.items;


import namless.slickRPG.PlayLevel;
import namless.slickRPG.core.TextBox;
import namless.slickRPG.supers.Item;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Potion extends Item{
	private Image image;
	private int invRefID = 0;
	private boolean heal = false;
	private boolean fireResist = false;
	private boolean hurt = false;
	private TextBox toolTip;
	private boolean hover = false;
	private int invX;
	private int invY;
	public Potion(boolean heal, boolean fireResist, boolean hurt) throws SlickException{
		image = new Image("res/images/items/potion.png");
		this.heal = heal;
		this.fireResist = fireResist;
		this.hurt = hurt;
		toolTip = new TextBox(this, "", Color.white, true);
		String toolTipText = "";
		int healing = 0;
		if(fireResist){
			if (toolTipText == ""){
				toolTipText = "Fire Resistance";
			}else{
				toolTipText = "\nFire Resistance";
			}
			healing -= (PlayLevel.player.getMaxHealth()/2);
		}
		if (heal){
			healing += (PlayLevel.player.getMaxHealth()/2);
		}
		if(hurt){
			healing -= (PlayLevel.player.getMaxHealth()/2);
		}
		if (toolTipText == ""){
			if (healing == -PlayLevel.player.getMaxHealth()){
				toolTipText = "Death";
			}else{
				toolTipText = "Heal: " + healing;
			}
		}else{
			if (healing == -PlayLevel.player.getMaxHealth()){
				toolTipText += "\nDeath";
			}else{
				toolTipText += "\nHeal: " + healing;
			}
		}
		toolTip.setText(toolTipText);
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
	public void action(){
		if (fireResist){
			PlayLevel.player.setFireResistance(true);
			PlayLevel.player.hit(PlayLevel.player.getMaxHealth()/2);
		}
		if (heal){
			PlayLevel.player.heal(PlayLevel.player.getMaxHealth()/2);
		}
		if (hurt){
			PlayLevel.player.hit(PlayLevel.player.getMaxHealth()/2);
		}
		if (!Item.infItems){
			PlayLevel.player.removeItemFromInventory(invRefID);
		}
		
	}
	public String getObjectType() {
		return "Potion";
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
		
	}
}
