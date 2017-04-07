package namless.slickRPG.events;

import namless.slickRPG.Maine;
import namless.slickRPG.PlayLevel;
import namless.slickRPG.supers.EventHandler;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sign extends EventHandler{
	private int x = 0;
	private int y = 0;
	private Image display;
	private String text;
	private boolean active = false;
	public Sign(int x, int y, String text){
		this.x = x;
		this.y = y;
		this.text = text; //Need string length
	}
	public void render(Graphics g) {
		g.drawImage(display, x*40, y*40);
		if (active){
			g.setColor(Color.red);
			g.fillRect(Maine.screenX/2, Maine.screenY/2, 1, 1);
			g.setColor(Color.white);
			g.drawString(text, 0, 0);
		}
	}
	public void update() throws SlickException {
		if (playerLocation()){
			active = true;
		}
	}
	public boolean playerLocation(){
		if(PlayLevel.player.x() == x && PlayLevel.player.y() == y){
			return true;
		}
		return false;
	}
	public void reset() throws SlickException {
		
	}
	
}
