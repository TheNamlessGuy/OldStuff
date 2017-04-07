package namless.survivetherezombies.core;

import java.io.IOException;

import namless.survivetherezombies.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Inputs {
	@SuppressWarnings("unused")
	private static Zombie z;
	public static int up = Input.KEY_UP;
	public static int down = Input.KEY_DOWN;
	public static int left = Input.KEY_LEFT;
	public static int right = Input.KEY_RIGHT;
	public static int shoot = Input.KEY_SPACE;
	public static int spawn = Input.KEY_RSHIFT;
	public static void player(Input in) throws SlickException{
		if (in.isKeyDown(left)){
			Game.player.left();
		}
		if (in.isKeyDown(right)){
			Game.player.right();
		}
		if (in.isKeyDown(up)){
			Game.player.up();
		}
		if (in.isKeyDown(down)){
			Game.player.down();
		}
		if (in.isKeyPressed(shoot)){
			try {
				Game.player.shoot();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void game(Input in, GameContainer gc){
		if (in.isKeyPressed(spawn)){
			Game.tip.setUseful(false);
			if (Zombie.zombies.size() <= 0){
				if ((Game.hud.getLevel()*10) >= 100){
					for (int i = 0; i < 100; i++){
						z = new Zombie();
					}
				}else{
					for (int i = 0; i < (Game.hud.getLevel()*10); i++){
						z = new Zombie();
					}
				}
			}
		}
		if (in.isKeyPressed(Input.KEY_F3)){
			Game.hud.toggleDebug(gc);
		}
	}
}
