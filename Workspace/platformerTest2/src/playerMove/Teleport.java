package playerMove;
import listeners.MoveListener;
import create.CreateJPanels;
import floors.*;
import game.Get;
import variables.*;
public class Teleport {
	public static void dieTeleport() {//WHAT HAPPENS WHEN YOU DIE
		Ints.timesKilled++;
		JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
		JPanels.gamePanel[Ints.startingLocation[0]][Ints.startingLocation[1]].add(Icons.playerIcon);
		Ints.getLocation(Get.location());
		JFrames.gameFrame.repaint();
		Booleans.jumping = false;
		Booleans.dying = false;
	}
	public static void nextFloor(){//TELEPORT TO THE NEXT FLOOR
		switch(Strings.currentLocation){
		case "floor1":
			floor2();
			break;
		case "floor2":
			floor3();
			break;
		case "floor3":
			floor4();
			break;
		case "floor4":
			floor5();
			break;
		case "floor6":
			JFrames.gameFrame.remove(JPanels.playingPanel);
			JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
			JPanels.gamePanel[Ints.startingLocation[0]][Ints.startingLocation[1]].add(Icons.playerIcon);
			JPanels.playingPanel = CreateJPanels.playingPanel();
			JFrames.gameFrame.add(JPanels.playingPanel);
			JFrames.gameFrame.pack();
			Ints.location = Get.location();
			JFrames.gameFrame.repaint();
			break;
		default:
			break;
		}
	}
	public static void lastFloor(){//TELEPORT TO PREVIOUS FLOOR
		switch(Strings.currentLocation){
		case "floor2":
			floor1();
			break;
		case "floor3":
			floor2();
			break;
		case "floor4":
			floor3();
			break;
		case "floor5":
			floor4();
			break;
		case "floor6":
			JFrames.gameFrame.remove(JPanels.playingPanel);
			JPanels.gamePanel[Ints.location[0]][Ints.location[1]].remove(Icons.playerIcon);
			JPanels.gamePanel[Ints.startingLocation[0]][Ints.screenSizeY-1].add(Icons.playerIcon);
			JPanels.playingPanel = CreateJPanels.playingPanel();
			JFrames.gameFrame.add(JPanels.playingPanel);
			JFrames.gameFrame.pack();
			Ints.location = Get.location();
			JFrames.gameFrame.repaint();
			break;
		default:
			break;
		}
	}
	public static void floor1(){
		JFrames.gameFrame.removeKeyListener(JFrames.gameFrame.getKeyListeners()[0]);
		JFrames.gameFrame.remove(JPanels.playingPanel);
		JPanels.gamePanel = Floor1.create();
		JPanels.playingPanel = CreateJPanels.playingPanel();
		JFrames.gameFrame.add(JPanels.playingPanel);
		JFrames.gameFrame.pack();
		Ints.location = Get.location();
		JFrames.gameFrame.repaint();
		JFrames.gameFrame.addKeyListener(new MoveListener());
	}
	public static void floor2(){
		JFrames.gameFrame.removeKeyListener(JFrames.gameFrame.getKeyListeners()[0]);
		JFrames.gameFrame.remove(JPanels.playingPanel);
		JPanels.gamePanel = Floor2.create();
		JPanels.playingPanel = CreateJPanels.playingPanel();
		JFrames.gameFrame.add(JPanels.playingPanel);
		JFrames.gameFrame.pack();
		Ints.location = Get.location();
		JFrames.gameFrame.repaint();
		JFrames.gameFrame.addKeyListener(new MoveListener());
	}
	public static void floor3(){
		JFrames.gameFrame.removeKeyListener(JFrames.gameFrame.getKeyListeners()[0]);
		JFrames.gameFrame.remove(JPanels.playingPanel);
		JPanels.gamePanel = Floor3.create();
		JPanels.playingPanel = CreateJPanels.playingPanel();
		JFrames.gameFrame.add(JPanels.playingPanel);
		JFrames.gameFrame.pack();
		Ints.location = Get.location();
		JFrames.gameFrame.repaint();
		JFrames.gameFrame.addKeyListener(new MoveListener());
	}
	public static void floor4(){
		JFrames.gameFrame.removeKeyListener(JFrames.gameFrame.getKeyListeners()[0]);
		JFrames.gameFrame.remove(JPanels.playingPanel);
		JPanels.gamePanel = Floor4.create();
		JPanels.playingPanel = CreateJPanels.playingPanel();
		JFrames.gameFrame.add(JPanels.playingPanel);
		JFrames.gameFrame.pack();
		Ints.location = Get.location();
		JFrames.gameFrame.repaint();
		JFrames.gameFrame.addKeyListener(new MoveListener());
	}
	public static void floor5(){
		JFrames.gameFrame.removeKeyListener(JFrames.gameFrame.getKeyListeners()[0]);
		JFrames.gameFrame.remove(JPanels.playingPanel);
		JPanels.gamePanel = Floor5.create();
		JPanels.playingPanel = CreateJPanels.playingPanel();
		JFrames.gameFrame.add(JPanels.playingPanel);
		JFrames.gameFrame.pack();
		Ints.location = Get.location();
		JFrames.gameFrame.repaint();
		JFrames.gameFrame.addKeyListener(new MoveListener());
	}
}