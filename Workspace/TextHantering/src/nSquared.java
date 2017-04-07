import javax.swing.*;
public class nSquared {
	/**
	 * Calculates 1sq + 2sq + 3sq + ... + nsq
	 */
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Mata in ett heltal.\nResultatet blir 1\u00b2 + 2\u00b2 + 3\u00b2 + ... + n\u00b2");
		//Gets n
		int n = Integer.parseInt(s);
		//Converts n to int
		if (n == 0)
		{
			JOptionPane.showMessageDialog(null, "Du kan inte använda 0");
			System.exit(0);
		}
		//Checks if int is 0, and cancels the program if it is
		int sum = 0;
		//The sum you get later
		int i = 1;
		//The number you calculate with
		while (i <= n)
		{
			sum = sum + i*i;
			i = i + 1;
		}
		//The calculation
		JOptionPane.showMessageDialog(null, "Din summa blir " + sum + ".");
		//Writes out the answer
		System.exit(0);
	}

}
