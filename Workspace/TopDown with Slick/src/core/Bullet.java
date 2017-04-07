package core;
import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import variables.Numbers;
public class Bullet{
    private Vector2f position;
    private String direction;
    private Image bullet;
    private double movementSpeed = 2;
    private int index;
    private boolean hit;
    public Bullet(float x, float y, String direction, int index) throws SlickException{
    	hit = false;
    	this.index = index; //Index in the arrays
        position = new Vector2f(x, y); //Position on screen
        this.direction = direction; //Where it's going
        if (direction.equals("up") || direction.equals("down")){
        	bullet = new Image("res/bulletVer.png"); //if it goes up or down
        }else{
        	bullet = new Image("res/bulletHor.png"); //if it goes left or right
        }
    }
    public synchronized void update(ArrayList<Enemy> enemies){
    	if (!hit){
    		switch(direction){ //Checks what direction the bullet should move and moves it that way
        	case "up":
        		position.y -= movementSpeed;
        		break;
        	case "down":
        		position.y += movementSpeed;
        		break;
        	case "left":
        		position.x -= movementSpeed;
        		break;
        	case "right":
        		position.x += movementSpeed;
        	default:
        		break;
        	}
    		for (int i = 0; i < enemies.size(); i++){ //Checks if you hit anything
    			if (position.y > enemies.get(i).y() && position.y < enemies.get(i).y()+20){
    				if (position.x > enemies.get(i).x() && position.x < enemies.get(i).x()+20){
    					//BULLET HIT
    					enemies.get(i).hit();
    					hit = true;
    					Numbers.score += 100;
    				}
    			}
    			
    		}
    	}else{ //"Removes" bullet
    		position.y = 800;
    		position.x = 800;
    	}
    }
    public void render(Graphics g){
    	g.drawImage(bullet, position.x, position.y); //Draw the bullet
    }
    public int getIndex(){
    	return index;
    }
}