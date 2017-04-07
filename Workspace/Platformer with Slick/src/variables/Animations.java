package variables;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
public class Animations {
	public static Animation playerLeft;
	public static Animation playerRight;
	public static Animation playerJumpLeft;
	public static Animation playerJumpRight;
	public static Animation playerFallLeft;
	public static Animation playerFallRight;
	public static Animation playerIdleLeft;
	public static Animation playerIdleRight;
	public static Animation player;
	
	public static void initPlayer() throws SlickException{
		Image[] idleLImg = {new Image("res/player/PlayerIdleL.png"), new Image("res/player/PlayerIdleL.png")};
		Image[] idleRImg = {new Image("res/player/PlayerIdleR.png"), new Image("res/player/PlayerIdleR.png")};
		Image[] jumpLImg = {new Image("res/player/PlayerJumpLeft.png"), new Image("res/player/PlayerJumpLeft.png")};
		Image[] jumpRImg = {new Image("res/player/PlayerJumpRight.png"), new Image("res/player/PlayerJumpRight.png")};
		Image[] fallLImg = {new Image("res/player/PlayerFallLeft.png"), new Image("res/player/PlayerFallLeft.png")};
		Image[] fallRImg = {new Image("res/player/PlayerFallRight.png"), new Image("res/player/PlayerFallRight.png")};
		Image[] walkLeft = {new Image("res/player/PlayerStepLeft1.png"), new Image("res/player/PlayerStepLeft2.png")};
		Image[] walkRight = {new Image("res/player/PlayerStepRight1.png"), new Image("res/player/PlayerStepRight2.png")};

		int[] duration = {200,200};
		playerJumpRight = new Animation(jumpRImg, duration, false);
		playerJumpLeft = new Animation(jumpLImg, duration, false);
		playerFallRight = new Animation(fallRImg, duration, false);
		playerFallLeft = new Animation(fallLImg, duration, false);
		playerLeft = new Animation(walkLeft, duration, true);
		playerRight = new Animation(walkRight, duration, true);
		playerIdleLeft = new Animation(idleLImg, duration, false);
		playerIdleRight = new Animation(idleRImg, duration, false);
		player = playerIdleRight;
	}
}
