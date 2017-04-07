package namless.survivetherezombies;
import namless.survivetherezombies.core.ImageButton;
import namless.survivetherezombies.core.Inputs;
import namless.survivetherezombies.core.Keys;
import namless.survivetherezombies.core.Play;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
public class OptionsMenu extends BasicGameState{
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	boolean shoot;
	boolean wave;
	ImageButton back;
	String errorMessage = "";
	int currentInput;
	public static short soundVolume;
	public static short musicVolume;
	public OptionsMenu(int state){}
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		soundVolume = 5;
		musicVolume = 5;
		up = false;
		down = false;
		left = false;
		right = false;
		shoot = false;
		wave = false;
        back = new ImageButton(new Image("res/buttons/backButton.png"), SurviveTheReZombies.screenX, 400, true);
        back.centerX(SurviveTheReZombies.screenX);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.setFont(MainMenu.normalFont);
        g.drawString("Fullscreen:", 300, 100);
        g.drawRect(480, 100, 20, 20);
        if (SurviveTheReZombies.fullscreen){
        	g.fillRect(485, 105, 11, 11);
        }
        g.setColor(Color.red);
        g.drawString(errorMessage, SurviveTheReZombies.screenX/2 + (MainMenu.normalFont.getWidth(errorMessage)/2), 125);
        //KEYS
        g.setColor(Color.white);
        g.drawString("Move up:", 300, 150);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Inputs.up), 480, 150);
        if (up){
        	g.setColor(Color.red);
        }else{
        	g.setColor(Color.white);
        }
        g.drawRect(480, 150, 100, 20);
    	g.setColor(Color.white);
        g.drawString("Move down:", 300, 175);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Inputs.down), 480, 175);
        if (down){
        	g.setColor(Color.red);
        }else{
        	g.setColor(Color.white);
        }
        g.drawRect(480, 175, 100, 20);
    	g.setColor(Color.white);
        g.drawString("Move left:", 300, 200);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Inputs.left), 480, 200);
        if (left){
        	g.setColor(Color.red);
        }else{
        	g.setColor(Color.white);
        }
        g.drawRect(480, 200, 100, 20);
    	g.setColor(Color.white);
        g.drawString("Move right:", 300, 225);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Inputs.right), 480, 225);
        if (right){
        	g.setColor(Color.red);
        }else{
        	g.setColor(Color.white);
        }
        g.drawRect(480, 225, 100, 20);
    	g.setColor(Color.white);
        g.drawString("Shoot:", 300, 250);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Inputs.shoot), 480, 250);
        if (shoot){
        	g.setColor(Color.red);
        }else{
        	g.setColor(Color.white);
        }
        g.drawRect(480, 250, 100, 20);
    	g.setColor(Color.white);
        g.drawString("Next wave:", 300, 275);
        g.drawString(""+org.lwjgl.input.Keyboard.getKeyName(Inputs.spawn), 480, 275);
        if (wave){
        	g.setColor(Color.red);
        }else{
        	g.setColor(Color.white);
        }
        g.drawRect(480, 275, 100, 20);
        g.setColor(Color.white);
        g.drawString("Sound Volume:", 300, 300);
        g.drawRect(480, 300, 25, 25);
        g.drawString("-", 487, 300);
        g.drawString("" + soundVolume, 525, 300);
        g.drawRect(555, 300, 25, 25);
        g.drawString("+", 562, 300);
        g.drawString("Music Volume:", 300, 330);
        g.drawRect(480, 330, 25, 25);
        g.drawString("-", 487, 330);
        g.drawString("" + musicVolume, 525, 330);
        g.drawRect(555, 330, 25, 25);
        g.drawString("+", 562, 330);
        back.render(g);
		
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input in = gc.getInput();
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		back.isHover(mouseX, mouseY);
		if ((currentInput = Keys.check(in)) != 0){
			if (up){
				Inputs.up = currentInput;
				up = false;
			}else if (down){
				Inputs.down = currentInput;
				down = false;
			}else if(left){
				Inputs.left = currentInput;
				left = false;
			}else if(right){
				Inputs.right = currentInput;
				right = false;
			}else if(shoot){
				Inputs.shoot = currentInput;
				shoot = false;
			}else if (wave){
				Inputs.spawn = currentInput;
				wave = false;
			}
		}else if (in.isMousePressed(0)){
				if (back.isClicked(mouseX, mouseY)){
					errorMessage = "";
					up = false;
					down = false;
					left = false;
					right = false;
					shoot = false;
					wave = false;
					sbg.enterState(SurviveTheReZombies.menu);
				}else if((mouseX > 480 && mouseX < 500) && (mouseY > 100 && mouseY < 120)){
					//Full screen box
					SurviveTheReZombies.fullscreen = !SurviveTheReZombies.fullscreen;
					try{
						gc.setFullscreen(SurviveTheReZombies.fullscreen);
					}catch(Exception e){
						SurviveTheReZombies.fullscreen = false;
						errorMessage = "Your computer does not support fullscreen mode of this game";
					}
				}else if((mouseX > 480 && mouseX < 505) && (mouseY > 300 && mouseY < 325)){
					//Sound Volume minus
					if (!(soundVolume <= 0)){
						Play.setSoundDifference(Play.getSoundDifference() - 0.1f);
						soundVolume--;
					}
				}else if((mouseX > 555 && mouseX < 580) && (mouseY > 300 && mouseY < 325)){
					//Sound Volume plus
					if (!(soundVolume >= 9)){
						Play.setSoundDifference(Play.getSoundDifference() + 0.1f);
						soundVolume++;
					}
				}else if((mouseX > 480 && mouseX < 505) && (mouseY > 330 && mouseY < 355)){
					//Music Volume minus
					if (!(musicVolume <= 0)){
						Play.setMusicDifference(Play.getMusicDifference() - 0.1f);
						musicVolume--;
					}
				}else if((mouseX > 555 && mouseX < 580) && (mouseY > 330 && mouseY < 355)){
					//Music Volume plus
					if (!(musicVolume >= 9)){
						Play.setMusicDifference(Play.getMusicDifference() + 0.1f);
						musicVolume++;
					}
				}else{
					checkKeyChange(in);
				}
			}
	}
	public int getID() {
		return 5;
	}
	public void checkKeyChange(Input in){
		int mouseX = in.getMouseX();
		int mouseY = in.getMouseY();
		if ((mouseX > 480 && mouseX < 580) && (mouseY > 150 && mouseY < 170)){ //MOVE UP
			if (!(down || left || right || shoot || wave)){
				up = !up;
			}
		}else if((mouseX > 480 && mouseX < 580) && (mouseY > 175 && mouseY < 195)){ //MOVE DOWN
			if (!(up || left || right || shoot || wave)){
				down = !down;
			}
		}else if((mouseX > 480 && mouseX < 580) && (mouseY > 200 && mouseY < 220)){ //MOVE LEFT
			if (!(down || up || right || shoot || wave)){
				left = !left;
			}
		}else if((mouseX > 480 && mouseX < 580) && (mouseY > 225 && mouseY < 245)){ //MOVE RIGHT
			if (!(down || left || up || shoot || wave)){
				right = !right;
			}
		}else if((mouseX > 480 && mouseX < 580) && (mouseY > 250 && mouseY < 270)){ //SHOOT
			if (!(down || left || right || up || wave)){
				shoot = !shoot;
			}
		}else if((mouseX > 480 && mouseX < 580) && (mouseY > 275 && mouseY < 295)){ //NEXT WAVE
			if (!(down || left || right || shoot || up)){
				wave = !wave;
			}
		}
	}
}