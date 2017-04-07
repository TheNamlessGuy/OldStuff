package namless.slickRPG.core;
import namless.slickRPG.Maine;
import namless.slickRPG.PlayLevel;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
public class DebugMode {
	private boolean isActive = false;
	public void render(Graphics g){
		g.setColor(Color.white); //Color of all of the text
		g.drawString("CharX: " + PlayLevel.player.x() + ", CharY: " + PlayLevel.player.y(), 10, 30); //Where the character is
		//g.drawString("", /*Numbers.screenSizeX-*/80, 10); //Where the mouse is
		g.drawString("Fire resistant: " + PlayLevel.player.isFireResistant(), 10, 50);
		g.drawString("Current tile ID: " + PlayLevel.level.getTiles()[PlayLevel.player.x()][PlayLevel.player.y()].getID(), 10, 70);
		g.drawString("Burning: " + PlayLevel.player.isBurning(), 10, 90);
		g.drawString("Invulnerable: " + PlayLevel.player.isInvulnerable(), 10, 110);
		g.drawString("Health: " + PlayLevel.player.getHealth(), 10, 130);
	}
	public void update(){
		Maine.container.setShowFPS(isActive); //Show FPS
	}
	public void setActive(boolean b){
		isActive = b;
	}
	public boolean isActive(){
		return isActive;
	}
}
