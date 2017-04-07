package core;
import game.Maine;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import variables.*;
public class OptionsMenu {
	String s = "";
	Button back;
	public OptionsMenu(String entrance){
		s = entrance;
	}
	public void render(Graphics g){
		Color transparent = new Color(0f,0f,0f,0.5f);
        g.setColor(transparent);
        g.fillRect(0,0, Numbers.screenSizeX, Numbers.screenSizeY);
        g.setColor(Color.white);
        g.drawString("Fullscreen: ", 300, 150);
        g.drawRect(480, 150, 20, 20); //FULLSCREEN TOGGLE
        if (Booleans.fullScreen){
        	g.fillRect(485, 155, 11, 11);
        }
        back = new Button(Numbers.screenSizeX/2 - 50, 250, 100, 40, "Back", true, Color.white, Color.black, 30);
        back.render(g);
	}
	public void update() throws SlickException{
		if ((Numbers.mousePosX > 350 && Numbers.mousePosX < 450) && (Numbers.mousePosY > 250 && Numbers.mousePosY < 290)){
			//BACK
			Booleans.options = false;
			if (s.equals("Pausemenu")){
				Booleans.paused = true;
			}
		}else if((Numbers.mousePosX > 480 && Numbers.mousePosX < 500) && (Numbers.mousePosY > 150 && Numbers.mousePosY < 170)){
			//FULLSCREEN BUTTON
			Booleans.fullScreen = !Booleans.fullScreen;
			Maine.container.setFullscreen(Booleans.fullScreen);
		}
	}
}