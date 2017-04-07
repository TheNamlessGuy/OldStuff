package core;
import game.Level1;
import game.Maine;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import variables.*;
public class DebugMode {
	public void render(Graphics g){
		if (Booleans.debugMode){
			g.setColor(Color.white); //Color of all of the text
			g.drawString("CharX: " + Numbers.charPosX + "\nCharY: " + Numbers.charPosY, 10, 30); //Where the character is
			g.drawString(Numbers.mousePosX + ", " + Numbers.mousePosY, Numbers.screenSizeX-80, 10); //Where the mouse is
			Level1.scoreX = 100;
		}else{
			Level1.scoreX = 10;
		}
		Maine.container.setShowFPS(Booleans.debugMode); //Show FPS
	}
}
