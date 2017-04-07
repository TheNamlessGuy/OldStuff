package namless.SlickLevelmaker;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LevelMakerMain {
	public static JFrame frame = new JFrame();
	public static JFrame newFrame = new JFrame();
	public static JFrame tileFrame = new JFrame();
	public static JPanel initPanel = JPanels.initPanel();
	public static JPanel startUpPanel;
	public static JFrame mappingFrame = new JFrame();
	public static String active = "air";
	public static Color purple = new Color(148, 0, 211);

	public static void main(String[] args) {
		startUpPanel = JPanels.startupPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(startUpPanel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setSize(300,300);
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.add(new JScrollPane(initPanel));
		newFrame.setSize(300, 300);
		newFrame.setLocationRelativeTo(null);
		mappingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mappingFrame.setSize(300, 300);
		tileFrame.add(JPanels.tilePanel());
		tileFrame.pack();
		tileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}