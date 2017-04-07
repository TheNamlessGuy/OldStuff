package playerMove;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import listeners.*;
import create.*;
import dialogue.*;
import variables.*;
public class Actions {
	public static void action() {
		if (JPanels.gamePanel[Ints.location[0]][Ints.location[1]].getComponentCount() == 2){//TALKING
			//WHO YOU ARE TALKING TO
			Component[] c = JPanels.gamePanel[Ints.location[0]][Ints.location[1]].getComponents();
			for (Component c1: c){
				if (c1 == Icons.blackIcon){ //IF YOU'RE TALKING TO THE BLACK PIXEL
					JLabels.oLabel = JLabels.bLabel;
					switch(Strings.currentLocation){ //WHICH FLOOR YOU'RE ON
					case "floor1":
						BlackDialogue.floor1();
						break;
					case "floor2":
						BlackDialogue.floor2();
						break;
					case "floor6":
						BlackDialogue.floor6();
						break;
					default: 
						JLabels.oTalkingLabel.setText("<html><center>ERROR</center></html>");
						break;
					}
					break;
				}else if (c1 == Icons.greenIcon){ //IF YOU'RE TALKING TO THE GREEN PIXEL
					JLabels.oLabel = JLabels.gLabel;
					switch(Strings.currentLocation){ //WHICH FLOOR YOU'RE ON
					case "floor1":
						GreenDialogue.floor1();
						break;
					case "floor2":
						GreenDialogue.floor2();
						break;
					case "floor6":
						GreenDialogue.floor6();
						break;
					default: 
						JLabels.oTalkingLabel.setText("<html><center>ERROR</center></html>");
						break;
					}
					break;
				}else if(c1 == Icons.purpleIcon){//IF YOU'RE TALKING TO THE PURPLE PIXEL
					JLabels.oLabel = JLabels.puLabel;
					switch(Strings.currentLocation){//WHICH FLOOR YOU'RE ON
					case "floor5":
						PurpleDialogue.floor5();
						break;
					case "floor6":
						PurpleDialogue.floor6();
						break;
					default:
						JLabels.oTalkingLabel.setText("<html><center>ERROR</center></html>");
						break;
					}
					break;
				}
			}
			JPanels.talkingPanels = CreateJPanels.talkingPanels();
			JPanels.talkingPanel = CreateJPanels.talkingPanel();
			JFrames.gameFrame.remove(JPanels.playingPanel);
			JFrames.gameFrame.add(JPanels.talkingPanel);
			JFrames.gameFrame.pack();
			JFrames.gameFrame.removeKeyListener(JFrames.gameFrame.getKeyListeners()[0]);
			JFrames.gameFrame.addKeyListener(new TalkingListener());
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
}
