package game;
import java.awt.Color;
import javax.swing.JPanel;
import variables.Icons;
import variables.Ints;
import variables.JPanels;
import variables.Strings;
public class Get {
	public static int[] location() {
		int[] location = Ints.location;
		JPanel[][] p = JPanels.gamePanel;
		for (int i = 0; i<Ints.screenSizeX;i++){
			for (int j = 0; j<Ints.screenSizeY;j++){
				if (p[i][j].getComponentCount() != 0){
					if (p[i][j].getComponent(0) == Icons.playerIcon){
						location[0] = i;
						location[1] = j;
						Ints.getLocation(location);
						break;
					}
				}
			}
		}
		return location;
	}
	public static Color currentSky(){
		switch(Strings.currentLocation){
		case "floor1":
			return Color.blue;
		case "floor2":
			return Color.blue;
		case "floor3":
			return Color.cyan;
		case "floor4":
			return Color.yellow;
		case "floor5":
			return Color.orange;
		default:
			return Color.blue;
		}
	}
}
