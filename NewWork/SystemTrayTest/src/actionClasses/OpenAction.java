package actionClasses;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class OpenAction extends ActionClass {
	String dest;
	public OpenAction(String dest) {
		this.dest = dest;
	}
	
	public void run() {
		try {
			Desktop.getDesktop().open(new File(dest));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not open directory: " + dest);
		}
	}
	public String writeable() {
		return dest;
	}
}
