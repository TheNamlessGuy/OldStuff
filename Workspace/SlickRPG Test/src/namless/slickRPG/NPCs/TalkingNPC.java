package namless.slickRPG.NPCs;

import namless.slickRPG.PlayLevel;
import namless.slickRPG.core.FloatText;
import namless.slickRPG.core.TextBox;
import namless.slickRPG.supers.NPC;
import namless.slickRPG.supers.Tile;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TalkingNPC extends NPC{
	private int locationX = 0;
	private int locationY = 0;
	private String name = "";
	private Animation npc;
	private int talkedTo = 0;
	private String[] dialogue;
	private TextBox talkText;
	public TalkingNPC(int locationX, int locationY, String name, String[] dialogue, Tile[][] tiles) throws SlickException{
		this.locationX = locationX;
		this.locationY = locationY;
		this.name = name;
		this.dialogue = dialogue;
		Image[] npcDownI = { new Image("res/images/player/PlayerDown1.png"), new Image("res/images/player/PlayerDown2.png") };
		int[] duration = {200,200};
		npc = new Animation(npcDownI, duration, true); //Images, time between images, if it should loop automatically
		npcDownI = null;
		duration = null;
		talkText = new TextBox(this, "Error", Color.white, false);
		tiles[locationX][locationY].setCanWalkOn(false);
	}
	public void render(Graphics g){
		if (!(PlayLevel.level.getTiles()[locationX][locationY].getID() == 3 && !PlayLevel.level.getTiles()[locationX][locationY].isPlayerLocation())){
			npc.draw(locationX*40, locationY*40);
		}
		talkText.render(g);
	}
	public void update(){
		talkText.update();
	}
	public void talkingUpdate(){
		if (isTalking()){
			talkedTo++;
			if (talkedTo > dialogue.length-1){
				talkedTo = 0;
			}
			talkText.setText(name + ": " + dialogue[talkedTo]);
			talkText.setActivate(true);
		}
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
	public void reset(){
		talkedTo = 0;
		talkText.setActivate(false);
	}
	public void setTalkingTo(boolean b){
		talkText.setActivate(b);
	}
	public int x(){
		return locationX;
	}
	public int y(){
		return locationY;
	}
	public FloatText getFloaty() {
		return null;
	}
	public String getObjectType() {
		return "Talking NPC";
	}
}
