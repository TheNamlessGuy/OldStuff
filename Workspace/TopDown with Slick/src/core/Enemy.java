package core;
import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import variables.*;
public class Enemy {
	private float posX;
	private float posY;
	private double movementSpeed = 1 ;
	private Random r;
	private Animation enemy;
	private int index;
	private boolean hit;
	public Enemy(int index){
		hit = false;
		this.index = index; //Index in the arrays
		r = new Random();
		int spawnPlace = r.nextInt(4); //Which side it should spawn on
		switch(spawnPlace){
		case 0:
			//SPAWN RIGHT
			posX = Numbers.screenSizeX-40;
			posY = r.nextInt(560)+40;
			enemy = Animations.enemyLeft;
			break;
		case 1:
			//SPAWN LEFT
			posX = 40;
			posY = r.nextInt(560)+40;
			enemy = Animations.enemyRight;
			break;
		case 2:
			//SPAWN UP
			posY = 40;
			posX = r.nextInt(760)+40;
			enemy = Animations.enemyDown;
			break;
		case 3:
			//SPAWN DOWN
			posX = r.nextInt(760)+40;
			posY = Numbers.screenSizeY-40;
			enemy = Animations.enemyUp;
			break;
		default:
			break;
		}
	}
	public synchronized void render(Graphics g){
		if (!hit){ //Draws the enemy only if it's not dead
			if (posX > Numbers.charPosX){
				enemy = Animations.enemyLeft;
			}else if (posY > Numbers.charPosY){
				enemy = Animations.enemyUp;
			}
			if (posX < Numbers.charPosX){
				enemy = Animations.enemyRight;
			}else if (posY < Numbers.charPosY){
				enemy = Animations.enemyDown;
			}
			enemy.draw(posX, posY);
		}
		
	}
	public synchronized void update(ArrayList<Enemy> enemies){
		if (hit){ //If the enemy is dead, move it to location below to "remove" it
			enemies.get(index).enemy = null;
			enemies.get(index).posX = -400;
			enemies.get(index).posY = -400;
		}else if (!Booleans.paused){ //Check which way the enemy should go and walks that way
			if (posX > Numbers.charPosX){
				posX -= movementSpeed;
			}
			if (posX < Numbers.charPosX){
				posX += movementSpeed;
			}
			if (posY > Numbers.charPosY){
				posY -= movementSpeed;
			}
			if (posY < Numbers.charPosY){
				posY += movementSpeed;
			}
			if (posY > Numbers.charPosY && posY < Numbers.charPosY+20){ //Checks if they touched you
				if (posX > Numbers.charPosX && posX < Numbers.charPosX+20){
					Booleans.dead = true;
				}
			}
		}
	}
	public int getIndex(){
		return index; //Get the index of this enemy
	}
	public float x(){
		return posX; //Get it's x position
	}
	public float y(){
		return posY; //Get it's y position
	}
	public void hit(){ //Sets the zombie to "hit" mode
		hit = true;
	}
}
