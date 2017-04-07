package namless.survivetherezombies;

import java.util.ArrayList;

import namless.survivetherezombies.core.Bullet;
import namless.survivetherezombies.core.HUD;
import namless.survivetherezombies.core.Inputs;
import namless.survivetherezombies.core.Player;
import namless.survivetherezombies.core.Tip;
import namless.survivetherezombies.core.Zombie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState{
	static ArrayList<Bullet> usedBullets;
	public static Player player;
	Image background;
	public static HUD hud;
	public static Tip tip;
	public static int slainZombies;
	public static boolean gameover;
	public static boolean win;
	public static boolean hardmode;
	public static boolean immortal;
	public Game(int state){}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		hud = new HUD();
		tip = new Tip();
		player = new Player();
		player.init();
		Bullet.init();
		Zombie.init();
		usedBullets = new ArrayList<Bullet>();
		background = new Image("res/bg.png");
		slainZombies = 0;
		gameover = false;
		win = false;
		hardmode = false;
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw();
		tip.render(g);
		hud.render(g);
		player.render(g);
		for (Bullet b: Bullet.bullets){
			b.render(g);
		}
		for (Zombie z: Zombie.zombies){
			z.render(g);
		}
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (gameover && !immortal){
			hud.toggleDebug(gc);
			gc.setMouseGrabbed(false);
			sbg.enterState(SurviveTheReZombies.gameover);
		}
		if (win){
			hud.toggleDebug(gc);
			gc.setMouseGrabbed(false);
			sbg.enterState(3);
		}
		updateMoveSpeed(delta);
		hud.checkLevel();
		Input in = gc.getInput();
		Inputs.game(in, gc);
		player.update(in);
		for (Bullet b: Bullet.bullets){
			if (b.isHit()){
				usedBullets.add(b);
			}
			b.update();
		}
		for (Zombie z: Zombie.zombies){
			z.update();
		}
		for (int i = 0; i < usedBullets.size(); i++){
			Bullet.bullets.remove(usedBullets.get(i));
		}
	}
	public int getID() {
		return 1;
	}
	public void updateMoveSpeed(int delta){
		player.updateMoveSpeed(delta);
		Zombie.updateMoveSpeed(delta);
		Bullet.updateMoveSpeed(delta);
	}
	public static void hitZombie(Zombie z){
		Zombie.zombies.remove(z);
		z = null;
	}
	public static void hitBullet(Bullet b){
		b = null;
	}
	public static void reset() throws SlickException{
		hud = new HUD();
		tip = new Tip();
		player = new Player();
		player.init();
		Bullet.init();
		Zombie.init();
		usedBullets = new ArrayList<Bullet>();
		slainZombies = 0;
		gameover = false;
		win = false;
		hardmode = false;
	}
}
