package namless.slickRPG.NPCs;

import namless.slickRPG.PlayLevel;
import namless.slickRPG.core.TextBox;
import namless.slickRPG.items.QuestItem;
import namless.slickRPG.supers.Item;
import namless.slickRPG.supers.NPC;
import namless.slickRPG.supers.Tile;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class QuestNPC extends NPC{
	private int locationX;
	private int locationY;
	private Item reward;
	private QuestItem item;
	private TextBox textBox;
	private Animation npc;
	public QuestNPC(int locationX, int locationY, Tile[][] tiles, Item reward, QuestItem item) throws SlickException{
		this.locationX = locationX;
		this.locationY = locationY;
		this.reward = reward;
		this.item = item;
		textBox = new TextBox(this, "I want a " + item.getItemName(), Color.white, false);
		Image[] npcDownI = { new Image("res/images/player/PlayerDown1.png"), new Image("res/images/player/PlayerDown2.png") };
		int[] duration = {200,200};
		npc = new Animation(npcDownI, duration, true); //Images, time between images, if it should loop automatically
		npcDownI = null;
		duration = null;
		tiles[locationX][locationY].setCanWalkOn(false);
	}
	public void render(Graphics g) {
		npc.draw(locationX*40, locationY*40);
		textBox.render(g);
	}
	public void update() {
		textBox.update();
	}
	public void talkingUpdate() {
		if (isTalking()){
			textBox.setActivate(true);
			if (PlayLevel.player.getInventory().contains(item)){
				textBox.setText("Thanks!\nHere, take this " + reward.getObjectType());
				PlayLevel.player.addItemToInventory(reward);
				PlayLevel.player.removeItemFromInventory(item.getItemInvRefID());
			}
		}
	}
	public void reset() {
		
	}
	public void setTalkingTo(boolean b) {
		textBox.setActivate(b);
	}
	public int x(){
		return locationX;
	}
	public int y(){
		return locationY;
	}
	public String getObjectType() {
		return "Quest NPC";
	}
	public boolean isTalking(){
		if (PlayLevel.player.x() == locationX+1 && PlayLevel.player.y() == locationY && PlayLevel.player.currentAnimation() == PlayLevel.player.playerLeft()){
			return true;
		}else if(PlayLevel.player.x() == locationX-1 && PlayLevel.player.y() == locationY && PlayLevel.player.currentAnimation() == PlayLevel.player.playerRight()){
			return true;
		}else if(PlayLevel.player.x() == locationX && PlayLevel.player.y() == locationY+1 && PlayLevel.player.currentAnimation() == PlayLevel.player.playerUp()){
			return true;
		}else if(PlayLevel.player.x() == locationX && PlayLevel.player.y() == locationY-1 && PlayLevel.player.currentAnimation() == PlayLevel.player.playerDown()){
			return true;
		}
		return false;
	}
}
