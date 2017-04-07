import javax.swing.*;
public class SimpleGame {
	/**
	 * SO EPICZ GAEMS
	 */
public static void main (String [] arg) {
	String h1, h2;
	h1 = JOptionPane.showInputDialog("Mata in minst 6 tecken");
	h2 = h1.substring(4,6) + h1.substring(0,2);
	JOptionPane.showMessageDialog(null, h2);
	System.exit(0);
}
}
