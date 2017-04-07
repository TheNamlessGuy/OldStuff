package namless.survivetherezombies.core;

import java.util.ArrayList;

import namless.survivetherezombies.Game;
import namless.survivetherezombies.SurviveTheReZombies;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet{
	public static ArrayList<Bullet> bullets;
	private float x;
	private float y;
    private short direction;
    private Image bullet;
    static float movementSpeed;
    private boolean hit;
    public static void init(){
    	bullets = new ArrayList<Bullet>();
    }
    public Bullet(float x, float y, short direction) throws SlickException{
    	movementSpeed = 0.5f;
    	hit = false;
    	this.x = x;
    	this.y = y;
        this.direction = direction;
        if (direction == 0){
        	bullet = new Image("res/bulletVer.png");
        	this.x += 15;
        	this.y += 35;
        }else if(direction == 1){
        	bullet = new Image("res/bulletVer.png");
        	this.x += 15;
        	this.y -= 5;
        }else if(direction == 2){
        	bullet = new Image("res/bulletHor.png");
        	this.x += 31;
        	this.y += 12;
        }else if (direction == 3){
        	bullet = new Image("res/bulletHor.png");
        	this.y += 12;
        	this.x -= 1;
        }
        bullets.add(this);
    }
    public void update(){
    	if (!(bullets.contains(this))){
    		Game.hitBullet(this);
    	}else{
        	switch(direction){
        	case 0: //DOWN
        		y += movementSpeed;
        		break;
        	case 1: //UP
        		y -= movementSpeed;
        		break;
        	case 2: //RIGHT
        		x += movementSpeed;
        		break;
        	case 3: //LEFT
        		x -= movementSpeed;
        		break;
        	default:
        		break;
        	}
        	if ((y > SurviveTheReZombies.screenY-50) || (y < 40) || (x > SurviveTheReZombies.screenX-50) || (x < 40)){
        		hit = true;
        	}
        	checkForHit();
    	}
    }
    public void render(Graphics g){
    	g.drawImage(bullet, x, y); //Draw the bullet
    }
    public void checkForHit(){
    	for (Zombie z: Zombie.zombies){
    		if (y > z.y() && y < z.y()+35){
    			if (x > z.x()+5 && x < z.x()+25){
    				Game.hitZombie(z);
    				Game.hud.addScore(100);
    				Game.slainZombies++;
    				hit = true;
    				break;
    			}
    		}
    	}
    }
    public boolean isHit(){
    	return hit;
    }
	public static void updateMoveSpeed(int delta){
		movementSpeed = 0.5f * delta;
	}
}