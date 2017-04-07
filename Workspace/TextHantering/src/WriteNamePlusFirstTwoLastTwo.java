import javax.swing.*;
public class WriteNamePlusFirstTwoLastTwo {

	/**
	 * Will write a word, plus the first two letters and the last two
	 */
	public static void main(String[] args) {
    String h1, h2, h3;
	h1 = JOptionPane.showInputDialog("Mata in ett ord med minst 2 tecken");
	h1 = h1.trim(); //the full name
	h2 = h1.substring(h1.length()-2); //Gets the two last letters
	h3 = h1.substring(0,2);//gets the first two letters
	JOptionPane.showMessageDialog(null, h1 + " " + h3 + h2); //displays h1 (full name), h3 (first two letters), h2 (last two letters)
	System.exit(0);
	}
}
