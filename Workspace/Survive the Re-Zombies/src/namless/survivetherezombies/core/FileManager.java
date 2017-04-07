package namless.survivetherezombies.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.newdawn.slick.SlickException;

import namless.survivetherezombies.Highscore;
import namless.survivetherezombies.MainMenu;
import namless.survivetherezombies.OptionsMenu;
import namless.survivetherezombies.SurviveTheReZombies;

public class FileManager {
	public static void read(File file) throws IOException, SlickException{
		String[] highscore = new String[5];
		BufferedReader bf = new BufferedReader(new FileReader(file));
		String input = "";
		String[] split = new String[3];
		while ((input = bf.readLine()) != null){
			split = input.split(":");
			if (split[0].equals("HIGHSCORE")){
				int i = Integer.parseInt(split[1].substring(0,1));
				split[1] = split[1].substring(1,split[1].length());
				highscore[i] = split[1] + ":" + split[2];
			}else if (split[0].equals("HW")){
				MainMenu.hasWon = Boolean.parseBoolean(split[1]);
			}else if(split[0].equals("FS")){
				SurviveTheReZombies.fullscreen = Boolean.parseBoolean(split[1]);
				SurviveTheReZombies.container.setFullscreen(SurviveTheReZombies.fullscreen);
			}else if(split[0].equals("MV")){
				float music = Float.parseFloat(split[1]);
				Play.setMusicDifference(music);
				OptionsMenu.musicVolume = (short)((music * 10) + 5);
			}else if(split[0].equals("SV")){
				float sound = Float.parseFloat(split[1]);
				Play.setSoundDifference(sound);
				OptionsMenu.soundVolume = (short)((sound * 10) + 5);
			}else if(split[0].equals("BUTTONMAPPING")){
				switch(split[1]){
				case "UP":
					Inputs.up = Integer.parseInt(split[2]);
					break;
				case "DOWN":
					Inputs.down = Integer.parseInt(split[2]);
					break;
				case "LEFT":
					Inputs.left = Integer.parseInt(split[2]);
					break;
				case "RIGHT":
					Inputs.right = Integer.parseInt(split[2]);
					break;
				case "SHOOT":
					Inputs.shoot = Integer.parseInt(split[2]);
					break;
				case "WAVE":
					Inputs.spawn = Integer.parseInt(split[2]);
					break;
				default:
					break;
				}
			}
		}
		bf.close();
		Highscore.updateHighscore(highscore);
	}
	public static void write(File file) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < 5; i++){
			bw.write("HIGHSCORE:" + i + Highscore.getName(i) + ":" + Highscore.getScore(i));
			bw.newLine();
		}
		bw.write("HW:"+MainMenu.hasWon);
		bw.newLine();
		bw.write("FS:"+SurviveTheReZombies.fullscreen);
		bw.newLine();
		bw.write("BUTTONMAPPING:UP:" + Inputs.up);
		bw.newLine();
		bw.write("BUTTONMAPPING:DOWN:" + Inputs.down);
		bw.newLine();
		bw.write("BUTTONMAPPING:LEFT:" + Inputs.left);
		bw.newLine();
		bw.write("BUTTONMAPPING:RIGHT:" + Inputs.right);
		bw.newLine();
		bw.write("BUTTONMAPPING:SHOOT:" + Inputs.shoot);
		bw.newLine();
		bw.write("BUTTONMAPPING:WAVE:" + Inputs.spawn);
		bw.newLine();
		bw.write("MV:" + Play.getMusicDifference());
		bw.newLine();
		bw.write("SV:" + Play.getSoundDifference());
		bw.close();
	}
	public static void creditsWrite(File file) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write("The sounds I've used come from the following people (all from freesound.org):");
		bw.newLine();
		bw.write("Button Hover Sound: SmartWentCody (http://freesound.org/people/SmartWentCody/sounds/179011/)(http://freesound.org/people/SmartWentCody/)");
		bw.newLine();
		bw.write("Button Click Sound: PhreaKsAccount (http://www.freesound.org/people/PhreaKsAccount/sounds/46265/) (http://www.freesound.org/people/PhreaKsAccount/)");
		bw.newLine();
		bw.write("Gunfire Sound: rjonesxlr8 (http://www.freesound.org/people/rjonesxlr8/sounds/211209/) (http://www.freesound.org/people/rjonesxlr8/)");
		bw.newLine();
		bw.write("Footstep Sound: RonaldVanWonderen (http://freesound.org/people/RonaldVanWonderen/sounds/110099/) (http://freesound.org/people/RonaldVanWonderen/)");
		bw.newLine();
		bw.write("Background music: Clinthammer (http://freesound.org/people/Clinthammer/sounds/179511/) (http://freesound.org/people/Clinthammer/)");
		bw.newLine();
		bw.write("DISCLAIMER: At the time of download, all of the sound clips I have downloaded were covered over the \"Attrubution\" license (http://creativecommons.org/licenses/by/3.0/)");
		bw.close();
	}
}
