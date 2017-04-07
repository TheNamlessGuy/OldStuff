package namless.slickRPG.events;

import namless.slickRPG.PlayLevel;
import namless.slickRPG.items.QuestItem;
import namless.slickRPG.supers.Item;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class ItemPickup {
	private boolean pickedUp = false;
	private Image display;
	private Item item;
	private int x;
	private int y;
	public ItemPickup(Item item, int x, int y){
		display = item.getImage();
		this.item = item;
		this.x = x;
		this.y = y;
	}
	public void render(Graphics g){
		if (!pickedUp){
			g.drawImage(display, x*40, y*40);
		}
	}
	public void update(){
		if (!pickedUp && playerLocation()){
			if(PlayLevel.player.addItemToInventory(item)){
				pickedUp = true;
			}
		}
	}
	public boolean playerLocation(){
		if (PlayLevel.player.x() == x && PlayLevel.player.y() == y){
			return true;
		}
		return false;
	}
	public Item getItem(){
		return item;
	}
	public QuestItem getQuestItem(){
		if (item instanceof QuestItem){
			return (QuestItem)item;
		}
		return null;
	}
}
