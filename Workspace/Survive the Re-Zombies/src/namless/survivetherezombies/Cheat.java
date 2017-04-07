package namless.survivetherezombies;

import namless.survivetherezombies.core.ColorBox;
import namless.survivetherezombies.core.ImageButton;
import namless.survivetherezombies.core.Player;
import namless.survivetherezombies.core.Zombie;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Cheat extends BasicGameState{
	ColorBox[] cb1;
	ColorBox[] cb2;
	ImageButton activate;
	ImageButton back;
	String message;
	int messageX;
	boolean fastZombies;
	boolean fastPlayer;
	boolean hardmode;
	boolean immortal;
	public Cheat(int state){}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		hardmode = false;
		immortal = false;
		fastZombies = false;
		fastPlayer = false;
		message = "";
		cb1 = new ColorBox[25];
		for (int i = 0; i < cb1.length; i++){
			cb1[i] = new ColorBox((i*30) + 30, 20, Color.white, Color.red);
		}
		cb2 = new ColorBox[25];
		for (int i = 0; i < cb2.length; i++){
			cb2[i] = new ColorBox((i*30) + 30, 50, Color.white, Color.red);
		}
		activate = new ImageButton(new Image("res/buttons/activateButton.png"), 0, SurviveTheReZombies.screenY/4, true);
		activate.centerX(SurviveTheReZombies.screenX);
		back = new ImageButton(new Image("res/buttons/backButton.png"), 0, SurviveTheReZombies.screenY/3 + 20, true);
		back.centerX(SurviveTheReZombies.screenX);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.red);
		g.setFont(MainMenu.titleFont);
		g.drawString(message, messageX, SurviveTheReZombies.screenY/4 - 50);
		for (ColorBox c : cb1){
			c.render(g);
		}
		for (ColorBox c : cb2){
			c.render(g);
		}
		activate.render(g);
		back.render(g);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		activate.isHover(mouseX, mouseY);
		back.isHover(mouseX, mouseY);
		for (ColorBox c : cb1){
			c.isHover(mouseX, mouseY);
		}
		for (ColorBox c : cb2){
			c.isHover(mouseX, mouseY);
		}
		if (in.isMousePressed(0)){
			for (ColorBox c : cb1){
				c.isClicked(mouseX, mouseY);
			}
			for (ColorBox c : cb2){
				c.isClicked(mouseX, mouseY);
			}
			if (activate.isClicked(mouseX, mouseY)){
				checkForCheat();
			}
			if (back.isClicked(mouseX, mouseY)){
				sbg.enterState(SurviveTheReZombies.menu);
			}
		}
	}
	public int getID() {
		return 4;
	}
	public void checkForCheat(){
		if (noBoxesChecked()){
			message = "";
		}else if (onlyBoxesChecked(cb1[0], cb1[1], cb2[0], cb2[24])){
			if (hardmode){
				message = "Hardmode deactivated!";
				messageX = SurviveTheReZombies.screenX/2 - (MainMenu.titleFont.getWidth(message)/2);
				MainMenu.hasWon = false;
				hardmode = false;
				reset();
			}else{
				message = "Hardmode activated!";
				messageX = SurviveTheReZombies.screenX/2 - (MainMenu.titleFont.getWidth(message)/2);
				MainMenu.hasWon = true;
				hardmode = true;
				reset();
			}
		}else if (onlyBoxesChecked(cb1[23], cb1[24], cb2[23], cb2[24])){
			if (fastZombies){
				message = "Fast Zombies deactivated!";
				messageX = SurviveTheReZombies.screenX/2 - (MainMenu.titleFont.getWidth(message)/2);
				if (MainMenu.hasWon){
					Zombie.setmoveUpdate(0.1f);
				}else{
					Zombie.setmoveUpdate(0.05f);
				}
				fastZombies = false;
				reset();
			}else{
				message = "Fast Zombies activated!";
				messageX = SurviveTheReZombies.screenX/2 - (MainMenu.titleFont.getWidth(message)/2);
				Zombie.setmoveUpdate(0.15f);
				fastZombies = true;
				reset();
			}
		}else if (onlyBoxesChecked(cb1[0], cb1[1], cb2[0], cb2[1])){
			if (fastPlayer){
				message = "Fast Player deactivated";
				messageX = SurviveTheReZombies.screenX/2 - (MainMenu.titleFont.getWidth(message)/2);
				Player.setmoveUpdate(0.2f);
				fastPlayer = false;
				reset();
			}else{
				message = "Fast Player activated";
				messageX = SurviveTheReZombies.screenX/2 - (MainMenu.titleFont.getWidth(message)/2);
				Player.setmoveUpdate(0.4f);
				fastPlayer = true;
				reset();
			}
		}else if (onlyBoxesChecked(cb1[0], cb1[1], cb1[2], cb1[24])){
			if (immortal){
				message = "Immortal Player deactivated!";
				messageX = SurviveTheReZombies.screenX/2 - (MainMenu.titleFont.getWidth(message)/2);
				Game.immortal = false;
				immortal = false;
				reset();
			}else{
				message = "Immortal Player activated!";
				messageX = SurviveTheReZombies.screenX/2 - (MainMenu.titleFont.getWidth(message)/2);
				Game.immortal = true;
				immortal = true;
				reset();
			}
		}
	}
	public void reset(){
		for (ColorBox c : cb1){
			c.unClick();
		}
		for (ColorBox c: cb2){
			c.unClick();
		}
	}
	public boolean onlyBoxesChecked(ColorBox c1, ColorBox c2, ColorBox c3, ColorBox c4){
		for (int i = 0; i < cb1.length; i++){
			if (cb1[i].getClicked()){
				if (!(cb1[i] == c1 || cb1[i] == c2 || cb1[i] == c3 || cb1[i] == c4)){
					return false;
				}
			}
		}
		for (int i = 0; i < cb2.length; i++){
			if (cb2[i].getClicked()){
				if (!(cb2[i] == c1 || cb2[i] == c2 || cb2[i] == c3 || cb2[i] == c4)){
					return false;
				}
			}
		}
		return true;
	}
	public boolean noBoxesChecked(){
		for (int i = 0; i < cb1.length; i++){
			if (cb1[i].getClicked()){
				return false;
			}
		}
		for (int i = 0; i < cb2.length; i++){
			if (cb2[i].getClicked()){
				return false;
			}
		}
		return true;
	}
}
