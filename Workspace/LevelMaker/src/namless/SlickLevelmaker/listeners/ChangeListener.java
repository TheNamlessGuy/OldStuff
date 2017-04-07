package namless.SlickLevelmaker.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import namless.SlickLevelmaker.JPanels;
import namless.SlickLevelmaker.LevelMakerMain;


public class ChangeListener implements MouseListener {
	public void mouseClicked(MouseEvent e) {
		JPanel[] tiles = JPanels.tiles;
		JPanel tile = (JPanel)e.getSource();
		for (int i = 0; i < tiles.length; i++){
			if (tile == tiles[i]){
				switch (i){
				case 0:
					LevelMakerMain.active = "air";
					break;
				case 1:
					LevelMakerMain.active = "fire";
					break;
				case 2:
					LevelMakerMain.active = "hidden";
					break;
				case 3: 
					LevelMakerMain.active = "wall";
					break;
				case 4: 
					LevelMakerMain.active = "break";
					break;
				case 5: 
					LevelMakerMain.active = "pSpawn";
					break;
				default:
					break;
				}
			}
			
		}
		
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}
