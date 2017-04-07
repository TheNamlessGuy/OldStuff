package namless.SlickLevelmaker;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import namless.SlickLevelmaker.listeners.ChangeListener;
import namless.SlickLevelmaker.listeners.CreateListener;
import namless.SlickLevelmaker.listeners.InitListener;
import namless.SlickLevelmaker.listeners.SaveListener;
import namless.SlickLevelmaker.listeners.StartupListener;


public class JPanels {
	public static JTextField xField = new JTextField();
	public static JTextField yField = new JTextField();
	public static JTextField nameField = new JTextField();
	public static JButton ok = new JButton("OK");
	public static JButton newMap = new JButton("New map");
	public static JButton loadMap = new JButton("Load map");
	public static JLabel errorMessage = new JLabel();
	public static JPanel[] tiles = new JPanel[6];
	public static JPanel[][] panels;
	public static JPanel startupPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		panel.add(newMap);
		panel.add(loadMap);
		newMap.addActionListener(new StartupListener());
		loadMap.addActionListener(new StartupListener());
		return panel;
	}
	public static JPanel initPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 2));
		panel.add(errorMessage);
		panel.add(new JLabel(""));
		panel.add(new JLabel("Name: "));
		panel.add(nameField);
		panel.add(new JLabel("X: "));
		panel.add(xField);
		panel.add(new JLabel("Y: "));
		panel.add(yField);
		panel.add(new JLabel(""));
		panel.add(ok);
		ok.addActionListener(new InitListener());
		return panel;
	}
	public static JPanel createPanel(int x, int y, boolean load) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(y, x));
		if (!load){
			panels = new JPanel[y][x];
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (!load){
					panels[j][i] = new JPanel();
					panels[j][i].setBackground(Color.black);
				}
				panels[j][i].addMouseListener(new CreateListener());
				panel.add(panels[j][i]);
			}
		}
		return panel;
	}
	public static JPanel tilePanel() {
		JPanel panel = new JPanel();
		JButton save = new JButton("Save");
		panel.setLayout(new GridLayout(0, 1));
		tiles[0] = new JPanel();
		tiles[0].setBackground(Color.yellow);
		tiles[0].addMouseListener(new ChangeListener());
		tiles[0].setToolTipText("Air block");
		tiles[1] = new JPanel();
		tiles[1].setBackground(Color.red);
		tiles[1].addMouseListener(new ChangeListener());
		tiles[1].setToolTipText("Fire block");
		tiles[2] = new JPanel();
		tiles[2].setBackground(LevelMakerMain.purple);
		tiles[2].addMouseListener(new ChangeListener());
		tiles[2].setToolTipText("Hidden block");
		tiles[3] = new JPanel();
		tiles[3].setBackground(Color.gray);
		tiles[3].addMouseListener(new ChangeListener());
		tiles[3].setToolTipText("Wall block");
		tiles[4] = new JPanel();
		tiles[4].setBackground(Color.cyan);
		tiles[4].addMouseListener(new ChangeListener());
		tiles[4].setToolTipText("Break block");
		tiles[5] = new JPanel();
		tiles[5].setBackground(Color.green);
		tiles[5].addMouseListener(new ChangeListener());
		tiles[5].setToolTipText("Player Spawn");
		panel.add(tiles[0]);
		panel.add(tiles[1]);
		panel.add(tiles[2]);
		panel.add(tiles[3]);
		panel.add(tiles[4]);
		panel.add(tiles[5]);
		save.addActionListener(new SaveListener());
		panel.add(save);
		return panel;
	}
}
