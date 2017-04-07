import javax.swing.*;
public class TextInmatning {
	/**
	 * Matar in en text, och skriver ut hur många tecken det är
	 */
public static void main (String [] arg) {
	String h1;
	/**
	 * Tar in det användaren vill skriva
	 */
	int i;
	/**
	 * Räknar hur många bokstäver det är i inmatningen
	 */
	h1 = JOptionPane.showInputDialog("Mata in din text");
	i = h1.length();
	JOptionPane.showMessageDialog(null, "Antalet bokstäver är " + i);
	System.exit(0);
}
}
