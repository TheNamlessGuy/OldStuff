package listeners;
import floors.Floor1;
import game.Get;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import create.CreateJPanels;
import variables.*;
public class TalkingListener implements KeyListener{
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			//RETURN TO NORMAL
			JFrames.gameFrame.remove(JPanels.talkingPanel);
			if (!(Strings.currentLocation.equals("floor5"))){
			int[] location = Get.location();
			JPanels.gamePanel[location[0]][location[1]].remove(Icons.playerIcon);
			location[1]++;
			JPanels.gamePanel[location[0]][location[1]].add(Icons.playerIcon);
			}else{
				JPanels.gamePanel = Floor1.create();
				JPanels.gamePanel[Ints.startingLocation[0]][Ints.startingLocation[1]].remove(Icons.playerIcon);
				JPanels.gamePanel[Ints.startingLocation[0]][Ints.screenSizeY-2].add(Icons.playerIcon);
				JPanels.gamePanel[Ints.startingLocation[0]][Ints.screenSizeY/2+11].add(Icons.purpleIcon);
				JPanels.gamePanel[Ints.startingLocation[0]][2].remove(Icons.blackIcon);
				JPanels.gamePanel[Ints.startingLocation[0]][Ints.screenSizeY/2+9].add(Icons.blackIcon);
				Strings.currentLocation = "floor6";
			}
			JPanels.playingPanel = CreateJPanels.playingPanel();
			JFrames.gameFrame.add(JPanels.playingPanel);
			JFrames.gameFrame.pack();
			JFrames.gameFrame.removeKeyListener(JFrames.gameFrame.getKeyListeners()[0]);
			JFrames.gameFrame.addKeyListener(new MoveListener());
			Dimension d = JFrames.gameFrame.getSize();
	        int w1 = (int)d.getWidth() / 2;
	        int h1 = (int)d.getHeight() / 2;
	        int w2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() / 2;
	        int h2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() / 2;
	        h2 = h2 - h1;
	        w2 = w2 - w1;
	        JFrames.gameFrame.setLocation(w2, h2);
			JFrames.gameFrame.repaint();
		}
	}
	public void keyTyped(KeyEvent e) {}
}
