package namless.survivetherezombies.core;

import namless.survivetherezombies.SurviveTheReZombies;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Tip {
	private boolean useful;
	public Tip(){
		useful = true;
	}
	public void render (Graphics g){
		if (useful){
			g.setColor(Color.black);
			g.fillRect(SurviveTheReZombies.screenX/2-75, 100, 150, 160);
			g.setColor(Color.white);
			g.fillRect(SurviveTheReZombies.screenX/2-70, 110, 140, 140);
			g.setColor(Color.black);
			g.drawString("Up: " + org.lwjgl.input.Keyboard.getKeyName(Inputs.up), SurviveTheReZombies.screenX/2-68, 115);
			g.drawString("Down: " + org.lwjgl.input.Keyboard.getKeyName(Inputs.down), SurviveTheReZombies.screenX/2-68, 130);
			g.drawString("Left: " + org.lwjgl.input.Keyboard.getKeyName(Inputs.left), SurviveTheReZombies.screenX/2-68, 145);
			g.drawString("Right: " + org.lwjgl.input.Keyboard.getKeyName(Inputs.right), SurviveTheReZombies.screenX/2-68, 160);
			g.drawString("Shoot: " + org.lwjgl.input.Keyboard.getKeyName(Inputs.shoot), SurviveTheReZombies.screenX/2-68, 175);
			g.drawString("Begin next\nwave: " + org.lwjgl.input.Keyboard.getKeyName(Inputs.spawn), SurviveTheReZombies.screenX/2-68, 200);
		}
	}
	public void setUseful(boolean b){
		useful = b;
	}
}
