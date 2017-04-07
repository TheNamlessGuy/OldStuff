package namless.survivetherezombies.core;

import java.io.IOException;

import namless.survivetherezombies.Game;
import namless.survivetherezombies.SurviveTheReZombies;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;

public class Player {
	private float movementSpeed;
	private static float movementUpdate;
	private Animation p;
	private Animation pL;
	private Animation pU;
	private Animation pR;
	private Animation pD;
	private float playerX;
	private float playerY;
	private short direction;
	private float hitX;
	private float hitY;
	static Audio gunfire;
	static Audio footstep;
	public Player(){}
	public void init() throws SlickException{
		playerX = SurviveTheReZombies.screenX/2 - 20;
		playerY = SurviveTheReZombies.screenY/2 - 20;
		updateHit();
		int[] duration = {200,200};
		Image[] pui = {new Image("res/player/PlayerUp1.png"), new Image("res/player/PlayerUp2.png")};
		Image[] pdi = {new Image("res/player/PlayerDown1.png"), new Image("res/player/PlayerDown2.png")};
		Image[] pli = {new Image("res/player/PlayerLeft1.png"), new Image("res/player/PlayerLeft2.png")};
		Image[] pri = {new Image("res/player/PlayerRight1.png"), new Image("res/player/PlayerRight2.png")};
		pL = new Animation(pli, duration, true);
		pU = new Animation(pui, duration, true);
		pR = new Animation(pri, duration, true);
		pD = new Animation(pdi, duration, true);
		pui = null;
		pdi = null;
		pli = null;
		pri = null;
		p = pD;
		direction = 0;
		movementSpeed = 0.2f;
		movementUpdate = 0.2f;
	}
	public void render(Graphics g){
		p.draw(playerX, playerY);
	}
	public void update(Input in) throws SlickException{
		Inputs.player(in);
	}
	public void left(){
		p = pL;
		if (playerX >= 31){
			playerX -= movementSpeed;
		}
		direction = 3;
		updateHit();
		if (!footstep.isPlaying()){
			Play.soundEffect(footstep, 0.2f);
		}
	}
	public void right(){
		p = pR;
		if (playerX <= 725){
			playerX += movementSpeed;
		}
		direction = 2;
		updateHit();
		if (!footstep.isPlaying()){
			Play.soundEffect(footstep, 0.1f);
		}
	}
	public void up(){
		p = pU;
		if (playerY >= 37){
			playerY -= movementSpeed;
		}
		direction = 1;
		updateHit();
		if (!footstep.isPlaying()){
			Play.soundEffect(footstep, 0.1f);
		}
	}
	public void down(){
		p = pD;
		if (playerY <= 525){
			playerY += movementSpeed;
		}
		direction = 0;
		updateHit();
		if (!footstep.isPlaying()){
			Play.soundEffect(footstep, 0.1f);
		}
	}
	public void shoot() throws SlickException, IOException{
		if (Game.hardmode){
			if (Bullet.bullets.size() < 1){
				Play.soundEffect(gunfire, 0.3f);
				@SuppressWarnings("unused")
				Bullet bullet = new Bullet(playerX, playerY, direction);
			}
		}else{
			Play.soundEffect(gunfire, 0.3f);
			@SuppressWarnings("unused")
			Bullet bullet = new Bullet(playerX, playerY, direction);
		}
	}
	public void updateMoveSpeed(int delta){
		movementSpeed = movementUpdate * delta;
	}
	public float x(){
		return playerX;
	}
	public float y(){
		return playerY;
	}
	public float hitX(){
		return hitX;
	}
	public float hitY(){
		return hitY;
	}
	public void updateHit(){
		hitX = playerX + 14;
		hitY = playerY + 6;
	}
	public static void setmoveUpdate(float i){
		movementUpdate = i;
	}
	public static void setGunfireSound(Audio a){
		gunfire = a;
	}
	public static void setFootstepSound(Audio a){
		footstep = a;
	}
}
