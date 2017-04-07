package core;
import game.Maine;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import variables.*;
public class DebugMode {
	public void render(Graphics g){
		if (Booleans.debugMode){
			System.out.println("Here");
			g.setColor(Color.white);
			g.drawString("CharX: " + Numbers.charPosX + "\nCharY: " + Numbers.charPosY, 10, 30);
			g.drawString(Numbers.mousePosX + ", " + Numbers.mousePosY, Numbers.screenSizeX-80, 10);
			g.drawString("\"" + Strings.currentFloor + "\"", Numbers.screenSizeX/2-50, 10);
		}
		Maine.container.setShowFPS(Booleans.debugMode);
	}
}
