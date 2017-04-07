package hax;
import game.Get;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

import playerMove.Teleport;
import variables.*;
public class HaxListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JTextField t = (JTextField)e.getSource();
		String s = t.getText();
		if (s.equalsIgnoreCase("HAX")){
			Booleans.hax = !Booleans.hax;
			JFrames.haxFrame.dispose();
		}else if(s.equalsIgnoreCase("deaths")){
			t.setText("Times killed: " + Ints.timesKilled);
		}else if(s.equalsIgnoreCase("currentFloor")){
			t.setText("Current floor: " + Strings.currentLocation);
		}else if(s.equalsIgnoreCase("n")){
			Teleport.nextFloor();
			JFrames.haxFrame.dispose();
		}else if(s.equalsIgnoreCase("floor1")){
			Teleport.floor1();
			JFrames.haxFrame.dispose();
		}else if(s.equalsIgnoreCase("floor2")){
			Teleport.floor2();
			JFrames.haxFrame.dispose();
		}else if(s.equalsIgnoreCase("floor3")){
			Teleport.floor3();
			JFrames.haxFrame.dispose();
		}else if(s.equalsIgnoreCase("floor4")){
			Teleport.floor4();
			JFrames.haxFrame.dispose();
		}else if(s.equalsIgnoreCase("floor5")){
			Teleport.floor5();
			JFrames.haxFrame.dispose();
		}else if (s.length() > 7){
			if ((s.substring(0,8)).equalsIgnoreCase("teleport")){
				if (s.substring(9, s.length()).equalsIgnoreCase("spawn")){
				JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
				JPanels.gamePanel[Ints.startingLocation[0]][Ints.startingLocation[1]].add(Icons.playerIcon);
				Ints.location = Get.location();
				JFrames.gameFrame.repaint();
				}else if(s.substring(9,s.length()).equalsIgnoreCase("end")){
					JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
					JPanels.gamePanel[Ints.startingLocation[0]][Ints.screenSizeY-2].add(Icons.playerIcon);
					Ints.location = Get.location();
					JFrames.gameFrame.repaint();
				}else{
					int i1 = s.indexOf(" ");
					int i2 = 0;
					s = s.substring(i1+1, s.length());
					i1 = s.indexOf(" ");
					String s1 = s.substring(0,i1);
					s = s.substring(i1+1,s.length());
					try{
						i1 = Integer.parseInt(s1);
						i2 = Integer.parseInt(s);
					}catch(Exception ellol){}
					if (i1 < (Ints.screenSizeX-1) && i2 < (Ints.screenSizeY-1) && i1 >= 0 && i2 >= 0){
						JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
						JPanels.gamePanel[i1][i2].add(Icons.playerIcon);
						Ints.location = Get.location();
						JFrames.gameFrame.repaint();
					}
				}
			}
			JFrames.haxFrame.dispose();
		}if (s.length() > 12){
			if((s.substring(0, 12)).equalsIgnoreCase("change color")){
				if (s.contains("sky: ") && s.contains("ground: ") && s.contains("death: ")){
					Color skyChange = Color.blue;
					Color groundChange = Color.gray;
					Color deathChange = Color.red;
					int i1 = s.indexOf("sky: ") + 5;
					int i2 = s.indexOf("ground: ") + 8;
					int i3 = s.indexOf("death: ") + 7;
					String s1 = s.substring(i1,i2-9);
					String s2 = s.substring(i2,i3-8);
					String s3 = s.substring(i3,s.length());
					//SKY COLOR CHANGE
					switch (s1){
					case "red":
						skyChange = Color.red;
						Booleans.customBackground = true;
						break;
					case "blue":
						skyChange = Color.blue;
						Booleans.customBackground = true;
						break;
					case "green":
						skyChange = Color.green;
						Booleans.customBackground = true;
						break;
					case "magenta":
						skyChange = Color.magenta;
						Booleans.customBackground = true;
						break;
					case "cyan":
						skyChange = Color.cyan;
						Booleans.customBackground = true;
						break;
					case "black":
						skyChange = Color.black;
						Booleans.customBackground = true;
						break;
					case "darkgray":
						skyChange = Color.darkGray;
						Booleans.customBackground = true;
						break;
					case "gray":
						skyChange = Color.gray;
						Booleans.customBackground = true;
						break;
					case "lightgray":
						skyChange = Color.lightGray;
						Booleans.customBackground = true;
						break;
					case "orange":
						skyChange = Color.orange;
						Booleans.customBackground = true;
						break;
					case "pink":
						skyChange = Color.pink;
						Booleans.customBackground = true;
						break;
					case "white":
						skyChange = Color.white;
						Booleans.customBackground = true;
						break;
					case "yellow":
						skyChange = Color.yellow;
						Booleans.customBackground = true;
						break;
					case "default":
						skyChange = Get.currentSky();
						Booleans.customBackground = false;
						break;
					default:
						skyChange = Color.blue;
						Booleans.customBackground = false;
						break;
					}
					//GROUND COLOR CHECK
					switch (s2){
					case "red":
						groundChange = Color.red;
						break;
					case "blue":
						groundChange = Color.blue;
						break;
					case "green":
						groundChange = Color.green;
						break;
					case "magenta":
						groundChange = Color.magenta;
						break;
					case "cyan":
						groundChange = Color.cyan;
						break;
					case "black":
						groundChange = Color.black;
						break;
					case "darkgray":
						groundChange = Color.darkGray;
						break;
					case "gray":
						groundChange = Color.gray;
						break;
					case "lightgray":
						groundChange = Color.lightGray;
						break;
					case "orange":
						groundChange = Color.orange;
						break;
					case "pink":
						groundChange = Color.pink;
						break;
					case "white":
						groundChange = Color.white;
						break;
					case "yellow":
						groundChange = Color.yellow;
						break;
					case "default":
						groundChange = Color.gray;
						break;
					default:
						groundChange = Color.gray;
						break;
					}
					//CHANGE DEATH COLOR
					switch (s3){
					case "red":
						deathChange = Color.red;
						break;
					case "blue":
						deathChange = Color.blue;
						break;
					case "green":
						deathChange = Color.green;
						break;
					case "magenta":
						deathChange = Color.magenta;
						break;
					case "cyan":
						deathChange = Color.cyan;
						break;
					case "black":
						deathChange = Color.black;
						break;
					case "darkgray":
						deathChange = Color.darkGray;
						break;
					case "gray":
						deathChange = Color.gray;
						break;
					case "lightgray":
						deathChange = Color.lightGray;
						break;
					case "orange":
						deathChange = Color.orange;
						break;
					case "pink":
						deathChange = Color.pink;
						break;
					case "white":
						deathChange = Color.white;
						break;
					case "yellow":
						deathChange = Color.yellow;
						break;
					case "default":
						deathChange = Color.red;
						break;
					default:
						deathChange = Color.red;
						break;
					}
					for (JPanel[] p1: JPanels.gamePanel){
						for (JPanel p2: p1){
							if (p2.getBackground() == Colors.skyBackground){
								p2.setBackground(skyChange);
							}else if(p2.getBackground() == Colors.groundBackground){
								p2.setBackground(groundChange);
							}else{
								p2.setBackground(deathChange);
							}
						}
					}
					Colors.skyBackground = skyChange;
					Colors.groundBackground = groundChange;
					Colors.death = deathChange;
					JFrames.gameFrame.repaint();
					JFrames.haxFrame.dispose();
				}
			}
		}
	}
}
