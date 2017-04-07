import javax.swing.*;
public class WritesOutRandomNumber {
	/**
	 * Writes out a number between 0-9
	 */
	public static void main(String[] args) {
		int i1 = (int)(9 * Math.random());
		//Sets i1 as a random number between 0-9
		JOptionPane.showMessageDialog(null, "The random number of this second is... " + i1);
		//Writes out the random number
		System.exit(0);
	}
}
