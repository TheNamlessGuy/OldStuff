package namless.survivetherezombies.core;

import namless.survivetherezombies.Game;
import namless.survivetherezombies.MainMenu;
import namless.survivetherezombies.SurviveTheReZombies;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class HUD {
	private long score;
	private int level;
	private int levelRequirement;
	private boolean debug;
	public HUD(){
		score = 0;
		level = 1;
		levelRequirement = level*10;
	}
	public void render(Graphics g){
		g.setColor(Color.white);
		g.setFont(MainMenu.normalFont);
		g.drawString("Score: "+score, SurviveTheReZombies.screenX/2, 0);
		g.drawString("Level: "+level, SurviveTheReZombies.screenX-100, 0);
		if (debug){
			g.drawString("Slain: "+Game.slainZombies, 0, 25);
			g.drawString("LevReq: "+levelRequirement, 0, 40);
			g.drawString("ActZom: " + Zombie.zombies.size(), 0, 55);
			g.drawString("ActBul: " + Bullet.bullets.size(), 0, 70);
			g.setColor(Color.blue);
			g.fillRect(Game.player.hitX(), Game.player.hitY(), 12, 30);
			g.setColor(Color.red);
			for (Zombie z: Zombie.zombies){
				g.fillRect(z.x()+11, z.y()+4, 16, 32);
			}
			g.fillRect(SurviveTheReZombies.screenX/2-2, 0, 4, SurviveTheReZombies.screenY);
			g.fillRect(0, SurviveTheReZombies.screenY/2-2, SurviveTheReZombies.screenX, 4);
		}
	}
	public void addScore(int scoreAddition){
		score += scoreAddition;
	}
	public int getLevel(){
		return level;
	}
	public long getScore(){
		return score;
	}
	public void checkLevel(){
		if (Game.slainZombies >= levelRequirement){
			if (level == 99){
				Game.win = true;
			}else{
				level++;
				levelRequirement += level*10;
			}
		}
	}
	public void toggleDebug(GameContainer gc){
		debug = !debug;
		gc.setShowFPS(debug);
	}
}
