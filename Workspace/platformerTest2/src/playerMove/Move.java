package playerMove;
import variables.*;
public class Move {
	public static void right() {
		if (Ints.location[1] != Ints.screenSizeY-1 && JPanels.gamePanel[Ints.location[0]][Ints.location[1]+1].getBackground() == Colors.skyBackground){
			JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
			Ints.location[1]++;
			JPanels.gamePanel[Ints.location[0]][Ints.location[1]].add(Icons.playerIcon);
			JFrames.gameFrame.repaint();
			if (Ints.location[1] == Ints.screenSizeY-1 && !(Strings.currentLocation.equals("floor5"))){
				Teleport.nextFloor();
			}
		}
	}
	public static void left() {
		if (Ints.location[1] != 0 && JPanels.gamePanel[Ints.location[0]][Ints.location[1]-1].getBackground() == Colors.skyBackground){
			JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
			Ints.location[1]--;
			JPanels.gamePanel[Ints.location[0]][Ints.location[1]].add(Icons.playerIcon);
			JFrames.gameFrame.repaint();
			if (Ints.location[1] == 0 && !(Strings.currentLocation.equals("floor1"))){
				Teleport.lastFloor();
			}
		}
	}
}