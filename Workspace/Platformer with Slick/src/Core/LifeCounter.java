package core;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import variables.*;
public class LifeCounter {
	public void render(Graphics g){
		g.setColor(Color.red);
		g.drawString("x"+Numbers.livesLeft, (int)Numbers.charPosX+10, (int)Numbers.charPosY-20);
	}
}
