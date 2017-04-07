package namless.survivetherezombies;

import java.io.File;
import java.io.IOException;

import namless.survivetherezombies.core.FileManager;
import namless.survivetherezombies.core.ImageButton;
import namless.survivetherezombies.core.Play;
import namless.survivetherezombies.core.Player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public class Loading extends BasicGameState{
	public static File file;
	public Loading (int state){}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		file = new File(System.getProperty("user.dir") + "\\SurviveTheZombies.txt");
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setFont(MainMenu.nameInputFont);
		g.drawString("LOADING...", SurviveTheReZombies.screenX/2 - (MainMenu.nameInputFont.getWidth("LOADING...")/2), SurviveTheReZombies.screenY/2 - (MainMenu.nameInputFont.getHeight()/2));
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (!file.exists()){
			try {
				FileManager.write(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileManager.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file2 = new File(System.getProperty("user.dir") + "\\SurviveTheZombies_Credits.txt");
		if (!file2.exists()){
			try{
				FileManager.creditsWrite(file2);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		try {
			ImageButton.setClickSound(AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sounds/dryfire.wav")));
			ImageButton.setHoverSound(AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sounds/guncock.wav")));
			Player.setGunfireSound(AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sounds/gunfire.wav")));
			Player.setFootstepSound(AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sounds/footstep.wav")));
			Play.music(AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/sounds/bgmusic.wav")), 0.5f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sbg.enterState(SurviveTheReZombies.menu);
	}
	public int getID() {
		return 7;
	}

}
