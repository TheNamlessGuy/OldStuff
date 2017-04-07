package namless.survivetherezombies.core;

import java.util.ArrayList;
import java.util.Random;

import namless.survivetherezombies.Game;
import namless.survivetherezombies.SurviveTheReZombies;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie {
	public static ArrayList<Zombie> zombies;
	static float movementSpeed;
	static float movementUpdate;
	private Animation z;
	private static Animation zL;
	private static Animation zU;
	private static Animation zR;
	private static Animation zD;
	private float zombieX;
	private float zombieY;
	private float hitX;
	private float hitY;
	public Zombie(){
		movementSpeed = 0.05f;
		if (Game.hardmode){
			movementUpdate = 0.1f;
		}else{
			movementUpdate = 0.05f;
		}
		Random r = new Random();
		short spawnPlace = (short)r.nextInt(4);
		switch(spawnPlace){
		case 0:
			//Spawn down
			zombieX = r.nextInt(SurviveTheReZombies.screenX-40)+40;
			zombieY = SurviveTheReZombies.screenY-40;
			break;
		case 1:
			//Spawn up
			zombieX = r.nextInt(SurviveTheReZombies.screenX-40)+40;
			zombieY = 40;
			break;
		case 2:
			//Spawn right
			zombieX = SurviveTheReZombies.screenX-40;
			zombieY = r.nextInt(SurviveTheReZombies.screenY-40)+40;
			break;
		case 3:
			//Spawn left
			zombieX = 40;
			zombieY = r.nextInt(SurviveTheReZombies.screenY-40)+40;
			break;
		default:
			break;
		}
		zombies.add(this);
	}
	public Zombie(float x, float y){
		zombieX = x;
		zombieY = y;
		zombies.add(this);
	}
	public static void init() throws SlickException{
		int[] duration = {200,200};
		Image[] zui = {new Image("res/enemy/ZombieUp1.png"), new Image("res/enemy/ZombieUp2.png")};
		Image[] zdi = {new Image("res/enemy/ZombieDown1.png"), new Image("res/enemy/ZombieDown2.png")};
		Image[] zli = {new Image("res/enemy/ZombieLeft1.png"), new Image("res/enemy/ZombieLeft2.png")};
		Image[] zri = {new Image("res/enemy/ZombieRight1.png"), new Image("res/enemy/ZombieRight2.png")};
		zL = new Animation(zli, duration, true);
		zU = new Animation(zui, duration, true);
		zR = new Animation(zri, duration, true);
		zD = new Animation(zdi, duration, true);
		zui = null;
		zdi = null;
		zli = null;
		zri = null;
		zombies = new ArrayList<Zombie>();
	}
	public void render(Graphics g){
		z.draw(zombieX, zombieY);
	}
	public void update(){
		hitX = zombieX+11;
		hitY = zombieY+4;
		if (zombieX > Game.player.x()){
			//Go left
			zombieX -= movementSpeed;
			z = zL;
		}
		if (zombieX < Game.player.x()){
			//Go right
			zombieX += movementSpeed;
			z = zR;
		}
		if (zombieY > Game.player.y()){
			//Go up
			zombieY -= movementSpeed;
			z = zU;
		}
		if (zombieY < Game.player.y()){
			//Go down
			zombieY += movementSpeed;
			z = zD;
		}
		if (checkIfKill()){
			Game.gameover = true;
		}
	}
	public float x(){
		return zombieX;
	}
	public float y(){
		return zombieY;
	}
	public static void updateMoveSpeed(int delta){
		movementSpeed = movementUpdate * delta;
	}
	public boolean checkIfKill(){
		if ((hitX+8) < (Game.player.hitX()-6) || (hitX-8) > (Game.player.hitX()+6) || (hitY+16) < (Game.player.hitY()-15) || (hitY-16) > (Game.player.hitY()+15)){
			return false;
		}
		return true;
	}
	public static void setmoveUpdate(float i){
		movementUpdate = i;
	}
}