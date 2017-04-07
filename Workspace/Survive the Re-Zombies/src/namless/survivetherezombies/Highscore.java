package namless.survivetherezombies;

import java.io.IOException;

import namless.survivetherezombies.core.ImageButton;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Highscore extends BasicGameState{
	ImageButton back;
	static String[] names;
	static long[] scores;
	public Highscore(int state){}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		back = new ImageButton(new Image("res/buttons/backButton.png"), 0, SurviveTheReZombies.screenY/4 * 3, true);
		back.centerX(SurviveTheReZombies.screenX);
		names = new String[5];
		for (int i = 0; i < names.length; i++){
			names[i] = "EMTY";
		}
		scores = new long[5];
		for (int i = 0; i < scores.length; i++){
			scores[i] = 0;
		}
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		back.render(g);
		g.setFont(MainMenu.titleFont);
		g.drawString("1. " + names[0] + " " + scores[0], SurviveTheReZombies.screenX/2 - (g.getFont().getWidth("1. " + names[0] + " " + scores[0])/2), SurviveTheReZombies.screenY/4);
		g.drawString("2. " + names[1] + " " + scores[1], SurviveTheReZombies.screenX/2 - (g.getFont().getWidth("2. " + names[1] + " " + scores[1])/2), SurviveTheReZombies.screenY/4 + 30);
		g.drawString("3. " + names[2] + " " + scores[2], SurviveTheReZombies.screenX/2 - (g.getFont().getWidth("3. " + names[2] + " " + scores[2])/2), SurviveTheReZombies.screenY/4 + 60);
		g.drawString("4. " + names[3] + " " + scores[3], SurviveTheReZombies.screenX/2 - (g.getFont().getWidth("4. " + names[3] + " " + scores[3])/2), SurviveTheReZombies.screenY/4 + 90);
		g.drawString("5. " + names[4] + " " + scores[4], SurviveTheReZombies.screenX/2 - (g.getFont().getWidth("5. " + names[4] + " " + scores[4])/2), SurviveTheReZombies.screenY/4 + 120);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		back.isHover(mouseX, mouseY);
		if (in.isMousePressed(0)){
			if(back.isClicked(mouseX, mouseY)){
				sbg.enterState(SurviveTheReZombies.menu);
			}
		}
		
	}
	public static void updateHighscore(String[] s){
		for (int i = 0; i < s.length; i++){
			String[] s1 = s[i].split(":");
			names[i] = s1[0];
			scores[i] = Integer.parseInt(s1[1]);
		}
	}
	public int getID() {
		return 6;
	}
	public static String getName(int index){
		return names[index];
	}
	public static long getScore(int index){
		return scores[index];
	}
	public static void check(long score, String name) throws IOException{
		if (score > scores[0]){
			scores[4] = scores[3];
			names[4] = names[3];
			scores[3] = scores[2];
			names[3] = names[2];
			scores[2] = scores[1];
			names[2] = names[1];
			scores[1] = scores[0];
			names[1] = names[0];
			scores[0] = score;
			names[0] = name;
		}else if (score > scores[1]){
			scores[4] = scores[3];
			names[4] = names[3];
			scores[3] = scores[2];
			names[3] = names[2];
			scores[2] = scores[1];
			names[2] = names[1];
			scores[1] = score;
			names[1] = name;
		}else if (score > scores[2]){
			scores[4] = scores[3];
			names[4] = names[3];
			scores[3] = scores[2];
			names[3] = names[2];
			scores[2] = score;
			names[2] = name;
		}else if (score > scores[3]){
			scores[4] = scores[3];
			names[4] = names[3];
			scores[3] = score;
			names[3] = name;
		}else if (score > scores[4]){
			scores[4] = score;
			names[4] = name;
		}
	}
}
