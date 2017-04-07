package floors;
import java.awt.Color;

import javax.swing.JPanel;

import variables.Booleans;
import variables.Colors;
import variables.Icons;
import variables.Ints;
import variables.Strings;
public class Floor1 {
	public static JPanel[][] create(){
		Strings.currentLocation = "floor1";
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
		panel[(Ints.screenSizeX/2)-1][2].add(Icons.blackIcon);
		panel[Ints.screenSizeX-3][Ints.screenSizeY/4+3].add(Icons.greenIcon);
		//THE STEPS
		int stepsX = 0, stepsY = 1;
		while(stepsX < 26 && stepsY < 25){ //MAKING LADDERS
			for (int i = Ints.screenSizeX/2;i < Ints.screenSizeX-stepsY;i++){
				panel[i][Ints.screenSizeX/2+stepsX].setBackground(Colors.skyBackground);
			}
			stepsX++;
			stepsY++;
		}
		//SECRET CAVE
		panel[Ints.screenSizeX-3][Ints.screenSizeY/4+4].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-4][Ints.screenSizeY/4+4].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-5][Ints.screenSizeY/4+4].setBackground(Colors.skyBackground);
		
		panel[Ints.screenSizeX-3][Ints.screenSizeY/4+3].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-4][Ints.screenSizeY/4+3].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-5][Ints.screenSizeY/4+3].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-6][Ints.screenSizeY/4+3].setBackground(Colors.skyBackground);

		panel[Ints.screenSizeX-2][Ints.screenSizeY/4+2].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-3][Ints.screenSizeY/4+2].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-4][Ints.screenSizeY/4+2].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-5][Ints.screenSizeY/4+2].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-6][Ints.screenSizeY/4+2].setBackground(Colors.skyBackground);

		panel[Ints.screenSizeX-3][Ints.screenSizeY/4+1].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-4][Ints.screenSizeY/4+1].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-5][Ints.screenSizeY/4+1].setBackground(Colors.skyBackground);
		
		panel[Ints.screenSizeX-3][Ints.screenSizeY/4].setBackground(Colors.skyBackground);
		panel[Ints.screenSizeX-4][Ints.screenSizeY/4].setBackground(Colors.skyBackground);
		
		panel[Ints.screenSizeX-3][Ints.screenSizeY/4-1].setBackground(Colors.skyBackground);
		//FLOOR OF DEATH
		for (int i = 0; i < Ints.screenSizeY; i++){
			panel[Ints.screenSizeX-1][i].setBackground(Colors.death);
		}
		//ROOF OF DEATH
		for (int i = 0; i < Ints.screenSizeY; i++){
			panel[0][i].setBackground(Colors.death);
		}
		return panel;
	}
}
