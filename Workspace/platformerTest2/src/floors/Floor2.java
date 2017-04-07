package floors;
import java.awt.Color;

import javax.swing.JPanel;
import variables.*;
public class Floor2 {
	public static JPanel[][] create(){
		Strings.currentLocation = "floor2";
		if (!Booleans.customBackground){
			Colors.skyBackground = Color.blue;
		}
		JPanel[][] panel = new JPanel[Ints.screenSizeX][Ints.screenSizeY];
		//CREATE BASE
		for (int i = 0; i<Ints.screenSizeX; i++){
			for (int j = 0; j<Ints.screenSizeY; j++){
				panel[i][j] = new JPanel();
				if (i < Ints.screenSizeX/2){
					panel[i][j].setBackground(Colors.skyBackground);
				}else{
					panel[i][j].setBackground(Colors.groundBackground);
				}
			}
		}
		//PLAYER LOCATION
		panel[Ints.startingLocation[0]][Ints.startingLocation[1]].add(Icons.playerIcon);
		//NPC LOCATIONS
		panel[Ints.startingLocation[0]][Ints.startingLocation[1]+3].add(Icons.blackIcon);
		panel[Ints.startingLocation[0]][Ints.startingLocation[1]+5].add(Icons.greenIcon);
		//GIANT HOLE
		for (int i = 0; i < Ints.screenSizeX-1; i++){
			panel[i][Ints.screenSizeY/3].setBackground(Colors.skyBackground);
		}
		for (int i = 0; i < Ints.screenSizeX-1; i++){
			panel[i][Ints.screenSizeY/3-1].setBackground(Colors.skyBackground);
		}
		//ROOF OF DEATH
		for (int j = 0; j < Ints.screenSizeY; j++){
			for (int i = 0; i < 4; i++){
				panel[i][j].setBackground(Colors.death);
			}
		}
		//FLOOR OF DEATH
		for (int j = 1; j < 4; j++){
			for (int i = 0; i < Ints.screenSizeY; i++){
				panel[Ints.screenSizeX-j][i].setBackground(Colors.death);
			}
		}
		return panel;
	}
}
