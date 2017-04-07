package namless.survivetherezombies;

import java.io.IOException;

import namless.survivetherezombies.core.ImageButton;
import namless.survivetherezombies.core.Keys;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Win extends BasicGameState{
	ImageButton back;
	static String name;
	String[] chars;
	int currentChar;
	public Win(int state){}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		currentChar = 0;
		chars = new String[4];
		for (int i = 0; i < chars.length; i++){
			chars[i] = "";
		}
		name = "";
		back = new ImageButton(new Image("res/buttons/backButton.png"), 0, SurviveTheReZombies.screenY/4*3, true);
		back.centerX(SurviveTheReZombies.screenX);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, SurviveTheReZombies.screenX, SurviveTheReZombies.screenY);
		g.setColor(Color.white);
		g.setFont(MainMenu.titleFont);
		g.drawString("You win!", SurviveTheReZombies.screenX/2 - (g.getFont().getWidth("You win!")/2), SurviveTheReZombies.screenY/4);
		g.setFont(MainMenu.normalFont);
		g.drawString("You have now unlocked Hard Mode! Avaliable back at the Main Menu", SurviveTheReZombies.screenX/2 - (g.getFont().getWidth("You have now unlocked Hard Mode! Avaliable back at the Main Menu")/2), SurviveTheReZombies.screenY/3);
		g.setFont(MainMenu.nameInputFont);
		if (currentChar == 0){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.white);
		}
		g.drawString(chars[0], 170 + (MainMenu.nameInputFont.getWidth(chars[0])/2), SurviveTheReZombies.screenY/2);
		g.fillRect(170, SurviveTheReZombies.screenY/4 * 3 - 50, 100, 4);
		if (currentChar == 1){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.white);
		}
		g.drawString(chars[1], 290 + (MainMenu.nameInputFont.getWidth(chars[1])/2), SurviveTheReZombies.screenY/2);
		g.fillRect(290, SurviveTheReZombies.screenY/4 * 3 - 50, 100, 4);
		if (currentChar == 2){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.white);
		}
		g.drawString(chars[2], 410 + (MainMenu.nameInputFont.getWidth(chars[2])/2), SurviveTheReZombies.screenY/2);
		g.fillRect(410, SurviveTheReZombies.screenY/4 * 3 - 50, 100, 4);
		if (currentChar == 3){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.white);
		}
		g.drawString(chars[3], 530 + (MainMenu.nameInputFont.getWidth(chars[3])/2), SurviveTheReZombies.screenY/2);
		g.fillRect(530, SurviveTheReZombies.screenY/4 * 3 - 50, 100, 4);
		back.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		back.isHover(mouseX, mouseY);
		String currentInput = "";
		if (!((currentInput = Keys.getInputChar(in)).equals(""))){
			chars[currentChar] = currentInput;
			currentChar++;
			if (currentChar > 3){
				currentChar = 0;
			}
		}else if (in.isMousePressed(0)){
			if (back.isClicked(mouseX, mouseY)){
				name = chars[0] + chars[1] + chars[2] + chars[3];
				MainMenu.hasWon = true;
				try {
					Highscore.check(Game.hud.getScore(), name);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Game.reset();
				sbg.enterState(0);
			}
		}
		if (in.isKeyPressed(Input.KEY_ENTER)){
			name = chars[0] + chars[1] + chars[2] + chars[3];
			MainMenu.hasWon = true;
			try {
				Highscore.check(Game.hud.getScore(), name);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Game.reset();
			sbg.enterState(0);
		}
	}
	public int getID() {
		return 3;
	}
}
