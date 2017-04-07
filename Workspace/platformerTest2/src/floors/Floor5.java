package floors;
import java.awt.Color;

import javax.swing.JPanel;
import variables.*;
public class Floor5 {
	public static JPanel[][] create() {
		Strings.currentLocation = "floor5";
		if (!Booleans.customBackground){
			Colors.skyBackground = Color.orange;
		}
		JPanel[][] panel = new JPanel[Ints.screenSizeX][Ints.screenSizeY];
		//CREATE BASE
		for (int i = 0; i<Ints.screenSizeX; i++){
			for (int j = 0; j<Ints.screenSizeY; j++){
				panel[i][j] = new JPanel();
				if (i < Ints.screenSizeX/2){
					panel[i][j].setBackground(Colors.skyBackground);
				}else{
					if (j % 2 == 0){
						panel[i][j].setBackground(Colors.groundBackground);
					}else{
						panel[i][j].setBackground(Colors.skyBackground);
					}
				}
			}
		}
		for (int i = Ints.screenSizeX/2; i < Ints.screenSizeX/2+1; i++){
			panel[i][Ints.screenSizeY-1].setBackground(Colors.groundBackground);
		}
		//FLOOR OF DEATH
		for (int i = 0; i < Ints.screenSizeY; i++){
			for (int j = Ints.screenSizeX/2+1; j < Ints.screenSizeX; j++){
				panel[j][i].setBackground(Colors.death);
			}
		}
		//ROOF OF DEATH
		for (int i = 0; i < Ints.screenSizeY; i++){
			for (int j = 0; j < Ints.screenSizeX/2-5; j++){
				panel[j][i].setBackground(Colors.death);
			}
		}
		//PLAYER LOCATION
		panel[Ints.startingLocation[0]][Ints.startingLocation[1]].add(Icons.playerIcon);
		//NPC LOCATIONS
		panel[Ints.startingLocation[0]][Ints.screenSizeY-2].add(Icons.purpleIcon);
		return panel;
	}
}