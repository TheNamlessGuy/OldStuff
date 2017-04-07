package namless.jatrpg;

import java.awt.Font;

import namless.jatrpg.core.ImageButton;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public class Loading extends BasicGameState{
	public Loading (int state){}
	int step;
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		Font fFont = new Font("Courier", Font.BOLD, 60);
		JAT_RPG.titleFont = new TrueTypeFont(fFont, false);
		step = 0;
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setFont(JAT_RPG.titleFont);
		g.drawString("Loading...", JAT_RPG.screenX/2 - (JAT_RPG.titleFont.getWidth("Loading...")/2), JAT_RPG.screenY/2 - (JAT_RPG.titleFont.getHeight("Loading...")/2));
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		switch(step){
			case 0:
				break;
			case 1:
				initStates(gc, sbg);
				break;
			case 2:
				loadSound();
				break;
			case 3:
				sbg.enterState(JAT_RPG.mainMenu);
				break;
		}
		step++;
	}
	public int getID() {
		return 0;
	}
	public void loadSound(){
		try{
			ImageButton.setClickSound(AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sound/soundEffects/dryfire.wav")));
			ImageButton.setHoverSound(AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sound/soundEffects/guncock.wav")));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void initStates(GameContainer gc, StateBasedGame sbg) throws SlickException{
		sbg.getState(JAT_RPG.mainMenu).init(gc, sbg);
		sbg.getState(JAT_RPG.connect).init(gc, sbg);
	}
}
