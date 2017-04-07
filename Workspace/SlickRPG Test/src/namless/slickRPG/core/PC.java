package namless.slickRPG.core;

import namless.slickRPG.Maine;
import namless.slickRPG.PlayLevel;
import namless.slickRPG.items.Empty;
import namless.slickRPG.supers.Item;
import namless.slickRPG.supers.Object;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PC extends Object{
	private Animation playerLeft;
	private Animation playerRight;
	private Animation playerUp;
	private Animation playerDown;
	private Animation player;
	private int playerX = 1;
	private int playerY = 1;
	private int playerSpawnX = 1;
	private int playerSpawnY = 1;
	private int health = 40;
	private int maxHealth = 40;
	private boolean burning = false;
	private boolean fireResistant = false;
	private boolean canMove = true;
	private boolean dead = false;
	private boolean invulnerable = false;
	private Inventory inv;
	private FloatText floaty;
	private Heart[] hearts;
	public PC(boolean boy) throws SlickException{
		floaty = new FloatText(this, "test", true, Color.white);
		Item[] inventory = new Item[20];
		for (int i = 0; i < inventory.length; i++){
			inventory[i] = new Empty();
		}
		inv = new Inventory(inventory);
		hearts = new Heart[10];
		for (int i = 0; i < hearts.length; i++){
			hearts[i] = new Heart();
		}
		Image[] playerUpI = new Image[2];
		Image[] playerDownI = new Image[2];
		Image[] playerLeftI = new Image[2];
		Image[] playerRightI = new Image[2];
		if (boy){
			playerUpI[0] = new Image("res/images/player/PlayerUp1.png");
			playerUpI[1] = new Image("res/images/player/PlayerUp2.png");
			playerDownI[0] = new Image("res/images/player/PlayerDown1.png");
			playerDownI[1] = new Image("res/images/player/PlayerDown2.png");
			playerLeftI[0] = new Image("res/images/player/PlayerLeft1.png");
			playerLeftI[1] = new Image("res/images/player/PlayerLeft2.png");
			playerRightI[0] = new Image("res/images/player/PlayerRight1.png");
			playerRightI[1] = new Image("res/images/player/PlayerRight2.png");
		}else{
			playerUpI[0] = new Image("res/images/player/female/PlayerUp1.png");
			playerUpI[1] = new Image("res/images/player/female/PlayerUp2.png");
			playerDownI[0] = new Image("res/images/player/female/PlayerDown1.png");
			playerDownI[1] = new Image("res/images/player/female/PlayerDown2.png");
			playerLeftI[0] = new Image("res/images/player/female/PlayerLeft1.png");
			playerLeftI[1] = new Image("res/images/player/female/PlayerLeft2.png");
			playerRightI[0] = new Image("res/images/player/female/PlayerRight1.png");
			playerRightI[1] = new Image("res/images/player/female/PlayerRight2.png");
		}
		int[] duration = {200,200}; //Time between each image (milliseconds)
		playerDown = new Animation(playerDownI, duration, true); //Images, time between images, if it should loop automatically
		playerUp = new Animation(playerUpI, duration, true);
		playerLeft = new Animation(playerLeftI, duration, true);
		playerRight = new Animation(playerRightI, duration, true);
		player = playerDown;
		playerUpI = null;
		playerDownI = null;
		playerLeftI = null;
		playerRightI = null;
		duration = null;
	}
	public void render(Graphics g){
		if (!dead){
			player.draw(playerX*40, playerY*40);
		}
		for(int i = 0; i < hearts.length; i++){
			g.drawImage(hearts[i].getDisplay(), 20*i, Maine.screenY-20);
		}
		floaty.render(g);
	}
	public void update(){
		floaty.update();
		if (burning){
			hit(1);
		}
	}
	public void setLocation(int x, int y){
		if (x < PlayLevel.level.getMaxX() && x >= 0){
			if (y < PlayLevel.level.getMaxY() && y >= 0){
				playerX = x;
				playerY = y;
			}
		}
	}
	public int getHealth(){
		return health;
	}
	public int x(){
		return playerX;
	}
	public int y(){
		return playerY;
	}
	public void moveUp(){
		PlayLevel.level.getTiles()[playerX][playerY].setPlayerLocation(false);
		playerY -= 1;
		PlayLevel.level.getTiles()[playerX][playerY].setPlayerLocation(true);
	}
	public void moveDown(){
		PlayLevel.level.getTiles()[playerX][playerY].setPlayerLocation(false);
		playerY += 1;
		PlayLevel.level.getTiles()[playerX][playerY].setPlayerLocation(true);
	}
	public void moveLeft(){
		PlayLevel.level.getTiles()[playerX][playerY].setPlayerLocation(false);
		playerX -= 1;
		PlayLevel.level.getTiles()[playerX][playerY].setPlayerLocation(true);
	}
	public void moveRight(){
		PlayLevel.level.getTiles()[playerX][playerY].setPlayerLocation(false);
		playerX += 1;
		PlayLevel.level.getTiles()[playerX][playerY].setPlayerLocation(true);
	}
	public void hit(int dmg){
		if (!dead && !invulnerable){
			health -= dmg;
			for (int i = hearts.length-1; i >= 0; i--){
				if (!hearts[i].isGone() && dmg > 0){
					dmg = hearts[i].hit(dmg);
				}
			}
		}
		if (health <= 0){
			canMove = false;
			dead = true;
		}
	}
	public boolean canMove(){
		return canMove;
	}
	public boolean isFireResistant(){
		return fireResistant;
	}
	public void setCanMove(boolean b){
		canMove = b;
	}
	public void setFireResistance(boolean b){
		fireResistant = b;
	}
	public boolean isDead(){
		return dead;
	}
	public void revive(){
		moveToSpawn();
		player = playerDown;
		dead = false;
		canMove = true;
		burning = false;
		fireResistant = false;
		for (int i = 0; i < hearts.length; i++){
			hearts[i].reset();
		}
		heal(maxHealth);
	}
	public void kill(){
		dead = true;
		canMove = false;
		health = 0;
	}
	public void setSpawn(int x, int y){
		playerSpawnX = x;
		playerSpawnY = y;
	}
	public int getSpawnX(){
		return playerSpawnX;
	}
	public int getSpawnY(){
		return playerSpawnY;
	}
	public void moveToSpawn(){
		PlayLevel.level.getTiles()[playerX][playerY].setPlayerLocation(false);
		playerX = playerSpawnX;
		playerY = playerSpawnY;
		PlayLevel.level.getTiles()[playerX][playerY].setPlayerLocation(true);
	}
	public void setInvulnerable(boolean b){
		invulnerable = b;
	}
	public void heal(int health){
		this.health += health;
		if (this.health > maxHealth){
			this.health = maxHealth;
		}
		for (int i = 0; i < hearts.length; i++){
			if (health > 0 && hearts[i].getHits() != 0){
				health = hearts[i].heal(health);
			}
		}
		if (this.health <= 0){
			kill();
		}
	}
	public void setBurning(boolean b){
		burning = b;
	}
	public boolean isBurning(){
		return burning;
	}
	public boolean isInvulnerable(){
		return invulnerable;
	}
	public void setDirection(String s){
		switch (s){
		case "down":
			player = playerDown;
			break;
		case "up":
			player = playerUp;
			break;
		case "left":
			player = playerLeft;
			break;
		case "right":
			player = playerRight;
			break;
		default:
			break;
		}
	}
	public int getMaxHealth(){
		return maxHealth;
	}
	public Inventory getInventory(){
		return inv;
	}
	public boolean addItemToInventory(Item item){
		if (item.getObjectType().equals("Gold") && inv.containsGold()){
			inv.getList()[inv.getGoldID()].setGoldAmount(inv.getList()[inv.getGoldID()].getGoldAmount() + item.getGoldAmount());
			return true;
		}else{
			for (int i = 0; i < inv.getList().length; i++){
				if (inv.getList()[i] instanceof Empty){
					inv.getList()[i] = item;
					inv.getList()[i].setItemInvRefID(i);
					inv.getList()[i].setItemInvRefX(Inventory.getInvRefX(i));
					inv.getList()[i].setItemInvRefY(Inventory.getInvRefY(i));
					return true;
				}
			}
		}
		return false;
	}
	public void removeItemFromInventory(int id){
		inv.getList()[id] = new Empty();
	}
	public Animation playerDown(){
		return playerDown;
	}
	public Animation playerUp(){
		return playerUp;
	}
	public Animation playerLeft(){
		return playerLeft;
	}
	public Animation playerRight(){
		return playerRight;
	}
	public Animation currentAnimation(){
		return player;
	}
	public FloatText getFloaty(){
		return floaty;
	}
	public String getObjectType() {
		return "Player";
	}
}