package namless.SlickLevelmaker.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JScrollPane;

import namless.SlickLevelmaker.JPanels;
import namless.SlickLevelmaker.LevelMakerMain;
import namless.SlickLevelmaker.Read;

public class StartupListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JPanels.newMap){
			LevelMakerMain.frame.dispose();
			LevelMakerMain.newFrame.setVisible(true);
		}else{
			JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				File file = new File(chooser.getSelectedFile().getAbsolutePath());
				try {
					JPanels.panels = Read.read(file);
					LevelMakerMain.frame.dispose();
					LevelMakerMain.mappingFrame.add(new JScrollPane(JPanels.createPanel(Read.x, Read.y, true)));
					LevelMakerMain.mappingFrame.setLocationRelativeTo(null);
					LevelMakerMain.mappingFrame.setVisible(true);
					LevelMakerMain.tileFrame.setVisible(true);
				} catch (NumberFormatException | IOException e1) {}
			}
		}
	}

}
