import javax.swing.*;
import java.text.*;
public class yCalc {
	/**
	 * Calculates y = x^2 + 4x + 5
	 * for the values of x the user inputs.
	 * Will only write 10 equations
	 */
	public static void main(String[] args) {
		DecimalFormat dF = new DecimalFormat("#.##");
		//Creates new Decimal Format
		String hW = JOptionPane.showInputDialog("Mata in det minsta värdet");
		//Gets the lowest value
		double W = Double.parseDouble(hW);
		//Changes hW to double
		String hZ = JOptionPane.showInputDialog("Mata in det största värdet");
		//Gets the highest value
		double Z = Double.parseDouble(hZ);
		//Changes hZ to double
		if (Z == W) {
			JOptionPane.showMessageDialog(null, "Dina nummer kan inte vara lika!");
			System.exit(0);
		}
		double add = (Z - W);
		add = (add / 10);
		//"add" calculates what we shall add to x after every turn
		double y;
		//Creates "y" from the calculation above
		double x;
		//Creates "x" from the calculation above
		String h1="x    |    y\n*********";
		//Creates the string and sets the first line
		for (x = W; x < Z; x = x + add)
		{
			y = (x*x) + (4 * x) + (5);
			h1 = h1 + "\n" + dF.format(x) + "   |   " + dF.format(y);
		}
		//A for that calculates our calculation and sets it in the String
		JOptionPane.showMessageDialog(null, h1);
		//Prints out answer
		System.exit(0);
	}

}
