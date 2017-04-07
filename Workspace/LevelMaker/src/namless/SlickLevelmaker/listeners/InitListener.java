package namless.SlickLevelmaker.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

import namless.SlickLevelmaker.JPanels;
import namless.SlickLevelmaker.LevelMakerMain;


public class InitListener implements ActionListener {
	public static int x, y;
	public static String name;

	public void actionPerformed(ActionEvent e) {
		boolean[] success = { false, false, false };
		String text = "";
		text = JPanels.xField.getText();
		if (text.equals(null) || text.equals("")) {
			JPanels.errorMessage.setText("X empty");
			success[0] = false;
		} else {
			JPanels.errorMessage.setText("");
			try {
				x = Integer.parseInt(text);
				success[0] = true;
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		text = JPanels.yField.getText();
		if (text.equals(null) || text.equals("")) {
			JPanels.errorMessage.setText("Y empty");
			success[1] = false;
		} else {
			JPanels.errorMessage.setText("");
			try {
				y = Integer.parseInt(text);
				success[1] = true;
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		text = JPanels.nameField.getText();
		if (text.equals(null) || text.equals("")) {
			JPanels.errorMessage.setText("No name");
			success[2] = false;
		} else {
			JPanels.errorMessage.setText("");
			name = text;
			success[2] = true;
		}
		if (success[0] && success[1] && success[2]) {
			LevelMakerMain.newFrame.dispose();
			LevelMakerMain.mappingFrame.add(new JScrollPane(JPanels.createPanel(x, y, false)));
			LevelMakerMain.mappingFrame.setLocationRelativeTo(null);
			LevelMakerMain.mappingFrame.setVisible(true);
			LevelMakerMain.tileFrame.setVisible(true);
		}
	}

}
