package namless.jatrpg.core;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.SoundStore;

public class Play {
	static float soundHeight;
	static float musicHeight;
	static float musicVolume;
	public static void soundEffect(Audio wav, float volume){
		SoundStore.get().setSoundVolume(volume + soundHeight);
		wav.playAsSoundEffect(1.0f, 1.0f, false);
	}
	public static void music(Audio wav, float volume){
		musicVolume = volume;
		SoundStore.get().setMusicVolume(musicVolume + musicHeight);
		wav.playAsMusic(1.0f, 1.0f, true);
	}
	public static void setSoundDifference(float f){
		soundHeight = f;
	}
	public static void setMusicDifference(float f){
		musicHeight = f;
		SoundStore.get().setMusicVolume(musicVolume + musicHeight);
	}
	public static float getSoundDifference(){
		return soundHeight;
	}
	public static float getMusicDifference(){
		return musicHeight;
	}
}
