package namless.slickRPG.core;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Heart {
	private Image[] hearts;
	private Image display;
	private boolean isGone = false;
	private int hits = 0;
	public Heart() throws SlickException{
		display = new Image("res/images/player/health/Heart0.png");
		hearts = new Image[5];
		hearts[0] = new Image("res/images/player/health/Heart0.png");
		hearts[1] = new Image("res/images/player/health/Heart1.png");
		hearts[2] = new Image("res/images/player/health/Heart2.png");
		hearts[3] = new Image("res/images/player/health/Heart3.png");
		hearts[4] = new Image("res/images/player/health/Heart4.png");
	}
	public Image getDisplay(){
		return display;
	}
	public int hit(int dmg){
		while (hits < 4 && dmg > 0){
			dmg--;
			hits++;
		}
		if (hits >= 4){
			display = hearts[4];
			isGone = true;
		}else{
			display = hearts[hits];
			if (display == hearts[4]){
				isGone = true;
			}
		}
		return dmg;
	}
	public int heal(int heal){
		while (hits > 0 && heal > 0){
			heal--;
			hits--;
		}
		display = hearts[hits];
		if (display != hearts[4]){
			isGone = false;
		}
		return heal;
	}
	public boolean isGone(){
		return isGone;
	}
	public void reset(){
		display = hearts[0];
		hits = 0;
		isGone = false;
	}
	public int getHits(){
		return hits;
	}
}
