package namless.SlickLevelmaker.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import namless.SlickLevelmaker.LevelMakerMain;


public class CreateListener implements MouseListener {
	public void mouseClicked(MouseEvent me) {
		JPanel panel = (JPanel) me.getSource();
		switch(LevelMakerMain.active){
		case "air":
			panel.setBackground(Color.yellow);
			break;
		case "fire":
			panel.setBackground(Color.red);
			break;
		case "hidden":
			panel.setBackground(LevelMakerMain.purple);
			break;
		case "wall":
			panel.setBackground(Color.gray);
			break;
		case "break":
			panel.setBackground(Color.cyan);
			break;
		case "pSpawn":
			panel.setBackground(Color.green);
			break;
		default:
			break;
		}
	}

	public void mouseEntered(MouseEvent me) {

	}

	public void mouseExited(MouseEvent me) {

	}

	public void mousePressed(MouseEvent me) {

	}

	public void mouseReleased(MouseEvent me) {

	}
}
