package floors;
import java.awt.Color;

import javax.swing.JPanel;
import variables.*;
public class Floor4 {
	public static JPanel[][] create() {
		Strings.currentLocation = "floor4";
		if (!Booleans.customBackground){
			Colors.skyBackground = Color.yellow;
		}
		JPanel[][] panel = new JPanel[Ints.screenSizeX][Ints.screenSizeY];
		//CREATE BASE
		for (int i = 0; i<Ints.screenSizeX; i++){
			for (int j = 0; j<Ints.screenSizeY; j++){
				panel[i][j] = new JPanel();
				if (i < Ints.screenSizeX/2){
					panel[i][j].setBackground(Colors.skyBackground);
				}else{
					if (j % 3 == 0){
						panel[i][j].setBackground(Colors.skyBackground);
					}else{
						panel[i][j].setBackground(Colors.groundBackground);
					}
				}
			}
		}
		//PLAYER LOCATION
		panel[Ints.startingLocation[0]][Ints.startingLocation[1]].add(Icons.playerIcon);
		for (int i = Ints.startingLocation[0]+1; i < Ints.screenSizeX-1; i++){
			panel[i][Ints.startingLocation[1]].setBackground(Colors.groundBackground);
		}
		//FLOOR OF DEATH
		for (int j = 1; j < Ints.screenSizeX/3; j++){
			for (int i = 0; i < Ints.screenSizeY; i++){
				panel[Ints.screenSizeX-j][i].setBackground(Colors.death);
			}
		}
		//ROOF OF DEATH
		for (int j = 0; j < Ints.screenSizeY; j++){
			for (int i = 0; i < Ints.screenSizeX/3; i++){
				panel[i][j].setBackground(Colors.death);
			}
		}
		return panel;
	}
}