import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import actionClasses.ActionClass;
import actionClasses.ClipboardAction;
import actionClasses.OpenAction;


public class STTMain {
	static TrayIcon trayIcon = null;
	static SystemTray sysTray = null;
	static JFileChooser chooser = null;
	static String tableLoc = null;
	
	static Hashtable<String, ActionClass> table = null;
	
	public static void init() {
		if (!SystemTray.isSupported()) {
			JOptionPane.showMessageDialog(null, "System Tray Access Denied");
			System.exit(0);
		}
		if (!Desktop.isDesktopSupported()) {
			JOptionPane.showMessageDialog(null, "Can't access Desktop");
			System.exit(0);
		}
		
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		
		tableLoc = chooser.getFileSystemView().getDefaultDirectory().toString() +  File.separator + "SystemTrayThingTable.txt";
		
		table = new Hashtable<String, ActionClass>();
		try {
			readTable();
		} catch (IOException e1) {}
		
		sysTray = SystemTray.getSystemTray();
		
		Image img = Toolkit.getDefaultToolkit().getImage(STTMain.class.getResource("/icon.gif"));
		
		PopupMenu popup = new PopupMenu();

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleDialog();
			}
		};
		MenuItem openWindow = new MenuItem("Open Window");
		openWindow.addActionListener(listener);
		popup.add(openWindow);
		
		listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewCommand();
			}
		};
		MenuItem addNew = new MenuItem("Add new");
		addNew.addActionListener(listener);
		popup.add(addNew);
		
		listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String superString = "";
				for (String key : table.keySet()) {
					superString += key + "\n";
				}
				if (superString == "") { superString = "None available at the moment"; }
				JOptionPane.showMessageDialog(null, superString);
			}
		};
		MenuItem listAvailable = new MenuItem("List Available");
		listAvailable.addActionListener(listener);
		popup.add(listAvailable);

		listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		};
		MenuItem close = new MenuItem("Close");
		close.addActionListener(listener);
		popup.add(close);
		
		trayIcon = new TrayIcon(img, "System Tray Thing", popup);
		trayIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) { handleDialog(); }
			}
		});
	}

	public static void saveTable() throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tableLoc), "UTF-8"));
		for (Map.Entry<String, ActionClass> entry: table.entrySet()) {
			out.write(entry.getKey() + "¤" + entry.getValue().getClass().getSimpleName() + 
					"¤" + entry.getValue().writeable());			
			out.newLine();
		}
		out.close();
	}

	public static void readTable() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(tableLoc), "UTF-8"));
		
		String line = in.readLine();
		while (!(line == null || line.isEmpty())) {
			String[] entries = line.split("¤");
			
			if (entries[1].contains("OpenAction")) {
				table.put(entries[0], new OpenAction(entries[2]));
			} else if (entries[1].contains("ClipboardAction")) {
				table.put(entries[0], new ClipboardAction(entries[2]));
			}
			
			line = in.readLine();
		}
		in.close();
	}
	
	public static String getDir(boolean folder) {
		chooser.setSelectedFile(new File(""));
		
		if (folder) {
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		} else {
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		}
		
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().getAbsolutePath();
		}
		return null;
	}
	
	public static void command(String command) {
		if (command == null || command.isEmpty()) { return; }
		
		if (table.containsKey(command)) {
			table.get(command).run();
		} else {
			JOptionPane.showMessageDialog(null, "Could not find command");
		}
		
	}
	
	public static void addNewCommand() {
		String input = JOptionPane.showInputDialog("Input");
		
		Object[] options = {"Open File", "Open Directory", "Set Clipboard Content"};
		
		int response = JOptionPane.showOptionDialog(null, null, "Output", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, null);
		
		String s;
		switch (response) {
		case 0: //Open File
			s = getDir(false);
			if (s != null) {
				table.put(input, new OpenAction(s));
			} else {
				JOptionPane.showMessageDialog(null, "No file selected");
			}
			break;
		case 1: //Open Directory
			s = getDir(true);
			if (s != null) {
				table.put(input, new OpenAction(s));
			} else {
				JOptionPane.showMessageDialog(null, "No directory selected");
			}
			break;
		case 2: //Set Clipboard Content
			s = JOptionPane.showInputDialog("Set clipboard to:");
			table.put(input, new ClipboardAction(s));
			break;
		default:
			break;
		}
	}
	
	public static void handleDialog() {
		try {
			command(JOptionPane.showInputDialog(null, null, "System Tray Thing", JOptionPane.PLAIN_MESSAGE));
		} catch (Exception e) {
			System.out.println("E1");
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			saveTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Could not save table");
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		init();
		
		try {
			sysTray.add(trayIcon);
		} catch(AWTException e) {
			e.printStackTrace();
		}
	}
}
