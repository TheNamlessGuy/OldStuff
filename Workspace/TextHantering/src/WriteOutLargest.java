import javax.swing.*;
public class WriteOutLargest {
	/**
	 * Will write out the largest number out of 5
	 */
	public static void main(String[] args) {
		String h1, h2;
		//Creates two String values
		h1 = JOptionPane.showInputDialog("Mata in den första siffran");
		//Gets the first number
		double d1 = Double.parseDouble(h1);
		//Gets h1 as an double
		h2 = JOptionPane.showInputDialog("Mata in den andra siffran");
		//Gets the second number
		double d2 = Double.parseDouble(h2);
		//Gets h2 as a double
		d2 = Math.max(d1, d2);
		//d2 gets the largest value
		h1 = JOptionPane.showInputDialog("Mata in tredje siffran");
		//Gets the 3rd number
		d1 = Double.parseDouble(h1);
		//d1 gets value of 3rd number
		d2 = Math.max(d1, d2);
		//d2 gets new value
		h1 = JOptionPane.showInputDialog("Mata in fjärde siffran");
		//Gets 4th number
		d1 = Double.parseDouble (h1);
		//Gets the value of 4th number
		d2 = Math.max(d1, d2);
		//d2 gets new value again
		h1 = JOptionPane.showInputDialog("Mata in femte siffran");
		//Gets the 5th number
		d1 = Double.parseDouble (h1);
		//Gets the value of 5th number
		d2 = Math.max(d1, d2);
		//d2 gets final value
		JOptionPane.showMessageDialog(null, "Högsta nummret var " + d2);
		//prints out the largest value
		System.exit(0);
	}
}
