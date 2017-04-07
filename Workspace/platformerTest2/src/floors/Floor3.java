package floors;
import java.awt.Color;
import javax.swing.JPanel;
import variables.*;
public class Floor3 {
	public static JPanel[][] create() {
		Strings.currentLocation = "floor3";
		if (!Booleans.customBackground){
			Colors.skyBackground = Color.cyan;
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
		int stepsX = 5, stepsY = 6;
		//STEPS
		while(stepsX < 26 && stepsY < 25){
			for (int i = Ints.screenSizeX/2;i < Ints.screenSizeX-stepsY;i++){
				panel[i][Ints.screenSizeX/2+stepsX].setBackground(Colors.skyBackground);
			}
			stepsX++;
			stepsY++;
		}
		//PIT #1
		for (int j = 0; j < 7; j++){
			for (int i = 0; i < Ints.screenSizeX-1; i++){
			panel[i][Ints.screenSizeY/2-j].setBackground(Colors.skyBackground);
			}
		}
		//PIT #2
		for (int i = 0; i < Ints.screenSizeX-1; i++){
			panel[i][Ints.screenSizeY/3].setBackground(Colors.skyBackground);
		}
		for (int i = 0; i < Ints.screenSizeX-1; i++){
			panel[i][Ints.screenSizeY/3-1].setBackground(Colors.skyBackground);
		}
		//ROOF OF DEATH
		for (int j = 0; j < Ints.screenSizeY; j++){
			for (int i = 0; i < Ints.screenSizeX/4-3; i++){
				panel[i][j].setBackground(Colors.death);
			}
		}
		//FLOOR OF DEATH
		for (int j = 1; j < Ints.screenSizeX/4-3; j++){
			for (int i = 0; i < Ints.screenSizeY; i++){
				panel[Ints.screenSizeX-j][i].setBackground(Colors.death);
			}
		}
		return panel;
	}
}