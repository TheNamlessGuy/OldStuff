package variables;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
public class Animations {
	public static Animation playerLeft;
	public static Animation playerRight;
	public static Animation playerUp;
	public static Animation playerDown;
	public static Animation player;
	public static Animation enemyUp;
	public static Animation enemyDown;
	public static Animation enemyLeft;
	public static Animation enemyRight;
	
	public static void init() throws SlickException{
		//INITIATES ALL THE ANIMATIONS
		Image[] playerUpI = {new Image("res/player/PlayerUp1.png"), new Image("res/player/PlayerUp2.png")};
		Image[] playerDownI = {new Image("res/player/PlayerDown1.png"), new Image("res/player/PlayerDown2.png")};
		Image[] playerLeftI = {new Image("res/player/PlayerLeft1.png"), new Image("res/player/PlayerLeft2.png")};
		Image[] playerRightI = {new Image("res/player/PlayerRight1.png"), new Image("res/player/PlayerRight2.png")};
		Image[] enemyUpI = {new Image("res/enemy/ZombieUp1.png"), new Image("res/enemy/ZombieUp2.png")};
		Image[] enemyDownI = {new Image("res/enemy/ZombieDown1.png"), new Image("res/enemy/ZombieDown2.png")};
		Image[] enemyLeftI = {new Image("res/enemy/ZombieLeft1.png"), new Image("res/enemy/ZombieLeft2.png")};
		Image[] enemyRightI = {new Image("res/enemy/ZombieRight1.png"), new Image("res/enemy/ZombieRight2.png")};

		int[] duration = {200,200}; //Time between each image (milliseconds)
		playerDown = new Animation(playerDownI, duration, true); //Images, time between images, if it should loop automatically
		playerUp = new Animation(playerUpI, duration, true);
		playerLeft = new Animation(playerLeftI, duration, true);
		playerRight = new Animation(playerRightI, duration, true);
		player = playerDown;
		enemyUp = new Animation (enemyUpI, duration, true);
		enemyDown = new Animation(enemyDownI, duration, true);
		enemyLeft = new Animation(enemyLeftI, duration, true);
		enemyRight = new Animation(enemyRightI, duration, true);
	}
}
