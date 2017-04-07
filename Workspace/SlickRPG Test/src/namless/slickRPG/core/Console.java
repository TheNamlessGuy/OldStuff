package namless.slickRPG.core;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import namless.slickRPG.Maine;
import namless.slickRPG.PlayLevel;
import namless.slickRPG.items.Potion;
import namless.slickRPG.supers.Item;
import namless.slickRPG.tiles.HiddenTile;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Console {
	private boolean isActive = false;
	private int upPresses = 0;
	private String input = "";
	private ArrayList<String> prevInput = new ArrayList<String>();
	private TextInput textInput = new TextInput();
	public void render(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(0, Maine.screenY-20, Maine.screenX, 20);
		g.setColor(Color.white);
		if (input.length() > 0){
			g.drawString(input, 0, Maine.screenY-18);
		}
	}
	public void update(Input in) throws SlickException{
		if (in.isKeyPressed(Input.KEY_TAB) || in.isKeyPressed(Input.KEY_ESCAPE)) {
			isActive = false;
		}else if (in.isKeyPressed(Input.KEY_ENTER)){
			check(input);
			prevInput.add(input);
			input = "";
			upPresses = 0;
		}else if(in.isKeyPressed(Input.KEY_BACK)){
			if (input.length() > 0){
				input = input.substring(0, input.length()-1);
			}
		}else if(in.isKeyPressed(Input.KEY_UP)){
			if (prevInput != null && upPresses < prevInput.size()){
				input = prevInput.get((prevInput.size()-1)-upPresses);
				upPresses++;
			}
		}else if((in.isKeyDown(Input.KEY_LCONTROL) || in.isKeyDown(Input.KEY_RCONTROL)) && in.isKeyPressed(Input.KEY_V)){
			try {
				input = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			} catch (HeadlessException | UnsupportedFlavorException | IOException e) {}
		}else{
			input = TextInput.check(in, input);
		}
	}
	public void setActive(boolean b){
		isActive = b;
	}
	public boolean isActive(){
		return isActive;
	}
	public String getInput(){
		return input;
	}
	public TextInput getTextInput(){
		return textInput;
	}
	public void check(String s) throws SlickException{
		s = s.toLowerCase();
		if (s.contains("player.")){
			if(s.contains("fullheal")){
				PlayLevel.player.heal(PlayLevel.player.getMaxHealth());
			}else if(s.contains("hit ")){
				s = s.substring(s.indexOf("hit ")+4, s.length());
				try{
					PlayLevel.player.hit(Integer.parseInt(s));
				}catch(Exception e){}
			}else if(s.contains("kill")){ //Kill player
				PlayLevel.player.kill();
			}else if (s.contains("teleport ")){
				s = s.substring(s.indexOf("teleport ")+9, s.length());
				if (s.equals("spawn")){
					PlayLevel.player.moveToSpawn();
				}else{
					try{
						int x = Integer.parseInt(s.substring(0, s.indexOf(" ")));
						int y = Integer.parseInt(s.substring(s.indexOf(" ")+1, s.length()));
						PlayLevel.level.getTiles()[PlayLevel.player.x()][PlayLevel.player.y()].setPlayerLocation(false);
						PlayLevel.player.setLocation(x, y);
						PlayLevel.level.getTiles()[PlayLevel.player.x()][PlayLevel.player.y()].setPlayerLocation(true);
					}catch(Exception e){}
				}
			}else if(s.contains("turn ")){
				s = s.substring(s.indexOf("turn ")+5, s.length());
				PlayLevel.player.setDirection(s);
			}else if(s.contains("tfireresist")){ //Toggle fire resistance
				PlayLevel.player.setFireResistance(!PlayLevel.player.isFireResistant());
			}else if(s.contains("timmortal")){ //Toggle immortality
				PlayLevel.player.setInvulnerable(!PlayLevel.player.isInvulnerable());
			}else if(s.contains("setspawnhere")){
				PlayLevel.player.setSpawn(PlayLevel.player.x(), PlayLevel.player.y());
			}else if(s.contains("revive")){
				PlayLevel.player.revive();
			}else if(s.contains("additem ")){
				s = s.substring(s.indexOf("additem ")+8, s.length());
				if (s.contains("potion ")){
					s = s.substring(s.indexOf("potion ")+7, s.length());
					try{
						boolean b1 = Boolean.parseBoolean(s.substring(0, s.indexOf(" ")));
						s = s.substring(s.indexOf(" ")+1, s.length());
						boolean b2 = Boolean.parseBoolean(s.substring(0, s.indexOf(" ")));
						boolean b3 = Boolean.parseBoolean(s.substring(s.indexOf(" ")+1, s.length()));
						PlayLevel.player.addItemToInventory(new Potion(b1, b2, b3));
					}catch(Exception e){}
				}else{
					switch (s){
					case "healpotion":
						PlayLevel.player.addItemToInventory(new Potion(true, false, false));
						break;
					case "firepotion":
						PlayLevel.player.addItemToInventory(new Potion(false, true, false));
						break;
					case "hurtpotion":
						PlayLevel.player.addItemToInventory(new Potion(false, false, true));
						break;
					case "superpotion":
						PlayLevel.player.addItemToInventory(new Potion(true, true, true));
						break;
					default:
						break;
					}
				}
			}else if(s.contains("tinfitems")){ //Toggle infinite items
				Item.infItems = !Item.infItems;
			}
		}else if(s.contains("hassteppedonfunction ")){
			s = s.substring(s.indexOf("hassteppedonfunction ")+21, s.length());
			try{
				HiddenTile.setHasSteppedOnFunction(Boolean.parseBoolean(s));
			}catch(Exception e){}
		}else if(s.contains("showhidden ")){
			s = s.substring(s.indexOf("showhidden ")+11, s.length());
			try{
				HiddenTile.setShowHidden(Boolean.parseBoolean(s));
			}catch(Exception e){}
		}
	}
}
