package namless.slickRPG.Enemies;

import namless.slickRPG.PlayLevel;
import namless.slickRPG.supers.Enemy;
import namless.slickRPG.supers.Tile;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie extends Enemy{
	private int health = 5;
	private int locationX = 0;
	private int locationY = 0;
	private Animation enemy;
	private boolean dead = false;
	public Zombie(int x, int y, Tile[][] tiles) throws SlickException{
		locationX = x;
		locationY = y;
		Image[] enemyDownI = { new Image("res/images/enemies/ZombieDown1.png"), new Image("res/images/enemies/ZombieDown2.png") };
		int[] duration = {200,200};
		enemy = new Animation(enemyDownI, duration, true); //Images, time between images, if it should loop automatically
		enemyDownI = null;
		duration = null;
		tiles[x][y].setCanWalkOn(false);
	}
	public void render(Graphics g){
		if (!dead){
			enemy.draw(locationX*40, locationY*40);
			g.setColor(Color.red);
			g.drawString(""+health, (locationX*40)+15, (locationY*40)-10);
			g.setColor(Color.white);
		}
	}
	public void update(){
		if (isAttacking()){
			health -= 1;
			if (health <= 0){
				dead = true;
				PlayLevel.level.getTiles()[locationX][locationY].setCanWalkOn(true);
			}
		}
	}
	public boolean isAttacking(){
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
	public int x(){
		return locationX;
	}
	public int y(){
		return locationY;
	}
	public void reset(){
		health = 5;
		dead = false;
	}
	public String getObjectType() {
		return "Zombie";
	}
}
